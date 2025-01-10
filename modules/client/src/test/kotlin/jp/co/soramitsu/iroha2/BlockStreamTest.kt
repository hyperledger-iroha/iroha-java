package jp.co.soramitsu.iroha2

import io.qameta.allure.Feature
import io.qameta.allure.Issue
import io.qameta.allure.Owner
import io.qameta.allure.Story
import jp.co.soramitsu.iroha2.annotations.Sdk
import jp.co.soramitsu.iroha2.annotations.SdkTestId
import jp.co.soramitsu.iroha2.client.blockstream.BlockStreamStorage
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
import kotlinx.coroutines.runBlocking
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
    fun `subscription to block stream`(): Unit = runBlocking {
        val idToSubscription = client.subscribeToBlockStream(from = 1, count = 3)
        val actionId = idToSubscription.first.first().id
        val subscription = idToSubscription.second
        val newAssetName = "rox"

        client.tx {
            transferDomainOwnership(ALICE_ACCOUNT_ID, DEFAULT_DOMAIN_ID, BOB_ACCOUNT_ID)
        }
        client.tx(BOB_ACCOUNT_ID, BOB_KEYPAIR) {
            registerAssetDefinition(newAssetName.asName(), DEFAULT_DOMAIN_ID, AssetType.Store())
        }

        val blocks = mutableListOf<BlockMessage>()
        subscription.receive<BlockMessage>(actionId).collect { block -> blocks.add(block) }

        val expectedSize = NewAccountWithMetadata().transaction.instructions.count() + 2 // + wasm + peer register
        var isi = blocks[0].validate(1, GENESIS_DOMAIN, GENESIS_ADDRESS, expectedSize)
        val registerDomain = isi[0].cast<InstructionBox.Register>().extractDomain().id.name.string

        assertEquals(DEFAULT_DOMAIN_ID.asString(), registerDomain)
        assertEquals(ALICE_ACCOUNT_ID, isi[1].extractAccount().id)
        assertEquals(BOB_ACCOUNT_ID, isi[2].extractAccount().id)
        assertEquals(NewAccountWithMetadata.ACCOUNT_ID, isi[3].extractAccount().id)

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
    fun `subscription to endless block stream`(): Unit = runBlocking {
        val repeatTimes = 5
        val shift = 1 // to test not to take more than was ordered
        val idToSubscription = client.subscribeToBlockStream(
            onBlock = { block -> block.extractBlock().height() },
            cancelIf = { block -> block.extractBlock().height().u64 == BigInteger.valueOf(repeatTimes.toLong()) },
        )
        val initialActionId = idToSubscription.first.first().id
        val subscription = idToSubscription.second
        var heightSum = BigInteger.ZERO

        subscription.receive<NonZeroOfu64>(initialActionId) { heightSum += it.u64 }

        repeat(repeatTimes + shift) {
            client.tx { setKeyValue(ALICE_ACCOUNT_ID, randomAlphabetic(16).asName(), randomAlphabetic(16)) }
        }
        assertEquals((1..repeatTimes.toLong()).sum(), heightSum.toLong())

        val isi = mutableListOf<InstructionBox>()
        subscription.subscribeAndReceive<InstructionBox>(
            BlockStreamStorage(
                onBlock = { it.extractBlock().transactions.first().value.extractInstruction() },
            ),
            collector = { isi.add(it) },
        )

        lateinit var lastValue: String
        repeat(repeatTimes * 2) {
            lastValue = randomAlphabetic(16)
            client.tx { setKeyValue(ALICE_ACCOUNT_ID, randomAlphabetic(16).asName(), lastValue) }
        }
        Thread.sleep(5000)
        val actual = isi.last().cast<InstructionBox.SetKeyValue>().setKeyValueBox
            .cast<SetKeyValueBox.Account>().setKeyValueOfAccount.value
        assertEquals(lastValue, actual)

        subscription.stop()
    }

    private fun BlockPayload.payloads(): List<TransactionPayload> = this.transactions.map { tx ->
        tx.value
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
        assertEquals(expectedHeight, committedBlock.header.height.u64.toLong())

        val payloads = committedBlock.payloads()
        assertTrue { payloads.any { it.authority.domain.name.string == expectedDomain } }
        assertTrue {
            payloads.any {
                it.authority.signatory.payload.toHex(true).lowercase() == expectedAccount.lowercase()
            }
        }

        val instructions = payloads.reversed().map {
            it.instructions.cast<Executable.Instructions>().vec
        }.flatten() // wasm isi in the end
        assertEquals(expectedIsiSize, instructions.size)

        return instructions
    }
}
