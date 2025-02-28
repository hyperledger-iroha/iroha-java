package jp.co.soramitsu.iroha2

import io.qameta.allure.Feature
import io.qameta.allure.Issue
import io.qameta.allure.Owner
import io.qameta.allure.Story
import jp.co.soramitsu.iroha2.annotations.Sdk
import jp.co.soramitsu.iroha2.annotations.SdkTestId
import jp.co.soramitsu.iroha2.client.blockstream.BlockStreamStorage
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.BlockMessage
import jp.co.soramitsu.iroha2.generated.BlockPayload
import jp.co.soramitsu.iroha2.generated.Executable
import jp.co.soramitsu.iroha2.generated.InstructionBox
import jp.co.soramitsu.iroha2.generated.NonZeroOfu64
import jp.co.soramitsu.iroha2.generated.SetKeyValueBox
import jp.co.soramitsu.iroha2.generated.SignedTransaction
import jp.co.soramitsu.iroha2.generated.TransactionPayload
import jp.co.soramitsu.iroha2.testengine.ALICE_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.BOB_ACCOUNT_ID
import jp.co.soramitsu.iroha2.testengine.BOB_KEYPAIR
import jp.co.soramitsu.iroha2.testengine.BOB_PUBLIC_KEY
import jp.co.soramitsu.iroha2.testengine.DEFAULT_DOMAIN
import jp.co.soramitsu.iroha2.testengine.DEFAULT_DOMAIN_ID
import jp.co.soramitsu.iroha2.testengine.GENESIS_ADDRESS
import jp.co.soramitsu.iroha2.testengine.GENESIS_DOMAIN
import jp.co.soramitsu.iroha2.testengine.IrohaTest
import jp.co.soramitsu.iroha2.testengine.NewAccountWithMetadata
import jp.co.soramitsu.iroha2.testengine.WithIroha
import jp.co.soramitsu.iroha2.transaction.Register
import jp.co.soramitsu.iroha2.transaction.SetKeyValue
import jp.co.soramitsu.iroha2.transaction.Transfer
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.withTimeout
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils.randomAlphabetic
import java.math.BigInteger
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

@Owner("akostyuchenko")
@Sdk("Java/Kotlin")
@Feature("Block Streaming")
class BlockStreamTest : IrohaTest<AdminIroha2Client>() {
    @Test
    @WithIroha([NewAccountWithMetadata::class])
    @Story("Successful subscription to block stream")
    @SdkTestId("subscription_to_block_stream")
    @Issue("https://app.zenhub.com/workspaces/iroha-v2-60ddb820813b9100181fc060/issues/gh/hyperledger/iroha-java/361")
    @ResourceLock("blockStream")
    fun `subscription to block stream`(): Unit =
        runBlocking {
            val idToSubscription = client.blocks(count = 3)
            val actionId = idToSubscription.first.first().id
            val subscription = idToSubscription.second
            val newAssetName = "rox"

            client.submit(Transfer.domain(ALICE_ACCOUNT_ID, DEFAULT_DOMAIN_ID, BOB_ACCOUNT_ID)).also { d ->
                withTimeout(txTimeout) { d.await() }
            }
            client
                .submitAs(
                    BOB_ACCOUNT_ID,
                    BOB_KEYPAIR,
                    Register.assetDefinition(AssetDefinitionId(DEFAULT_DOMAIN_ID, newAssetName.asName()), AssetType.Store()),
                ).also { d ->
                    withTimeout(txTimeout) { d.await() }
                }

            val blocks = mutableListOf<BlockMessage>()
            subscription.receive<BlockMessage>(actionId).collect { block -> blocks.add(block) }

            // upgrade executor + set parameters + isi + set topology
            val expectedSize = NewAccountWithMetadata().transaction.instructions.count() + 12
            var isi = blocks[0].validate(1, GENESIS_DOMAIN, GENESIS_ADDRESS, expectedSize)
            val registerDomain =
                isi[1]
                    .cast<InstructionBox.Register>()
                    .extractDomain()
                    .id.name.string

            assertEquals(DEFAULT_DOMAIN_ID.asString(), registerDomain)
            assertEquals(ALICE_ACCOUNT_ID, isi[2].extractAccount().id)
            assertEquals(BOB_ACCOUNT_ID, isi[3].extractAccount().id)
            assertEquals(NewAccountWithMetadata.ACCOUNT_ID, isi[4].extractAccount().id)

            isi = blocks[2].validate(3, DEFAULT_DOMAIN, BOB_PUBLIC_KEY.payload.toHex(true), 1)
            val newAssetDefinition = isi[0].cast<InstructionBox.Register>().extractAssetDefinition()
            assertNotNull(newAssetDefinition)
            assertEquals(newAssetName, newAssetDefinition.id.name.string)
            assertEquals(DEFAULT_DOMAIN, newAssetDefinition.id.domain.asString())

            subscription.stop()
        }

    @Test
    @WithIroha([NewAccountWithMetadata::class])
    @Story("Successful subscription to endless block stream")
    @SdkTestId("subscription_to_endless_block_stream")
    @ResourceLock("blockStream")
    fun `subscription to endless block stream`(): Unit =
        runBlocking {
            val repeatTimes = 5
            val shift = 1 // to test not to take more than was ordered
            val idToSubscription =
                client.blocks(
                    onBlock = { block -> block.extractBlock().height() },
                    cancelIf = { block -> block.extractBlock().height().u64 == BigInteger.valueOf(repeatTimes.toLong()) },
                )
            val initialActionId = idToSubscription.first.first().id
            val subscription = idToSubscription.second
            var heightSum = BigInteger.ZERO

            subscription.receive<NonZeroOfu64>(initialActionId) { heightSum += it.u64 }

            repeat(repeatTimes + shift) {
                client.submit(SetKeyValue.account(ALICE_ACCOUNT_ID, randomAlphabetic(16).asName(), randomAlphabetic(16))).also { d ->
                    withTimeout(txTimeout) { d.await() }
                }
            }
            assertEquals((1..repeatTimes.toLong()).sum(), heightSum.toLong())

            val isi = mutableListOf<InstructionBox>()
            subscription.subscribeAndReceive<InstructionBox>(
                BlockStreamStorage(
                    onBlock = {
                        it
                            .extractBlock()
                            .transactions
                            .first()
                            .extractInstruction()
                    },
                ),
                collector = { isi.add(it) },
            )

            lateinit var lastValue: String
            repeat(repeatTimes * 2) {
                lastValue = randomAlphabetic(16)
                client.submit(SetKeyValue.account(ALICE_ACCOUNT_ID, randomAlphabetic(16).asName(), lastValue)).also { d ->
                    withTimeout(txTimeout) { d.await() }
                }
            }
            Thread.sleep(5000)
            val actual =
                isi
                    .last()
                    .cast<InstructionBox.SetKeyValue>()
                    .setKeyValueBox
                    .cast<SetKeyValueBox.Account>()
                    .setKeyValueOfAccount.value
            assertEquals(lastValue, actual.readValue())

            subscription.stop()
        }

    private fun BlockPayload.payloads(): List<TransactionPayload> =
        this.transactions.map { tx ->
            tx
                .cast<SignedTransaction.V1>()
                .signedTransactionV1
                .payload
        }

    private fun BlockMessage.validate(
        expectedHeight: Long,
        expectedDomain: String,
        expectedAccount: String,
        expectedIsiSize: Int,
    ): List<InstructionBox> {
        val committedBlock = this.extractBlock()
        assertEquals(
            expectedHeight,
            committedBlock.header.height.u64
                .toLong(),
        )

        val payloads = committedBlock.payloads()
        assertTrue { payloads.any { it.authority.domain.name.string == expectedDomain } }
        assertTrue {
            payloads.any {
                it.authority.signatory.payload
                    .toHex(true)
                    .lowercase() == expectedAccount.lowercase()
            }
        }

        val instructions =
            payloads
                .reversed()
                .map {
                    it.instructions.cast<Executable.Instructions>().vec
                }.flatten() // wasm isi in the end
        assertEquals(expectedIsiSize, instructions.size)

        return instructions
    }
}
