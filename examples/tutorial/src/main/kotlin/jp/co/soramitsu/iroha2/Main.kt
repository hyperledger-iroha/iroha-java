package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetValue
import jp.co.soramitsu.iroha2.generated.AssetValueType
import kotlinx.coroutines.runBlocking
import java.net.URL

fun main(args: Array<String>): Unit = runBlocking {
    val peerUrl = "http://127.0.0.1:8080"
    val telemetryUrl = "http://127.0.0.1:8180"
    val admin = AccountId("wonderland".asDomainId(), "bob".asName())
    val adminKeyPair = keyPairFromHex(
        "7233bfc89dcbd68c19fde6ce6158225298ec1131b6a130d1aeb454c1ab5183c0",
        "9ac47abf59b356e0bd7dcbbbb4dec080e302156a48ca907e47cb6aea1d32719e",
    )

    val client = AdminIroha2Client(URL(peerUrl), URL(peerUrl), URL(telemetryUrl))
    val query = Query(client, admin, adminKeyPair)
    query.findAllDomains()
        .also { println("ALL DOMAINS: ${it.map { d -> d.id.asString() }}") }

    val sendTransaction = SendTransaction(client, admin, adminKeyPair)

    val domain = "looking_glass_${System.currentTimeMillis()}"
    sendTransaction.registerDomain(domain).also { println("DOMAIN $domain CREATED") }

    val madHatter = "madHatter_${System.currentTimeMillis()}$ACCOUNT_ID_DELIMITER$domain"
    val madHatterKeyPair = generateKeyPair()
    sendTransaction.registerAccount(madHatter, listOf(madHatterKeyPair.public.toIrohaPublicKey()))
        .also { println("ACCOUNT $madHatter CREATED") }

    query.findAllAccounts()
        .also { println("ALL ACCOUNTS: ${it.map { a -> a.id.asString() }}") }

    val assetDefinition = "asset_time_${System.currentTimeMillis()}$ASSET_ID_DELIMITER$domain"
    sendTransaction.registerAssetDefinition(assetDefinition, AssetValueType.Quantity())
        .also { println("ASSET DEFINITION $assetDefinition CREATED") }

    val madHatterAsset = "$assetDefinition$ASSET_ID_DELIMITER$madHatter"
    sendTransaction.registerAsset(madHatterAsset, AssetValue.Quantity(100))
        .also { println("ASSET $madHatterAsset CREATED") }

    val whiteRabbit = "whiteRabbit_${System.currentTimeMillis()}$ACCOUNT_ID_DELIMITER$domain"
    val whiteRabbitKeyPair = generateKeyPair()
    sendTransaction.registerAccount(whiteRabbit, listOf(whiteRabbitKeyPair.public.toIrohaPublicKey()))
        .also { println("ACCOUNT $whiteRabbit CREATED") }

    val whiteRabbitAsset = "$assetDefinition$ASSET_ID_DELIMITER$whiteRabbit"
    sendTransaction.registerAsset(whiteRabbitAsset, AssetValue.Quantity(0))
        .also { println("ASSET $whiteRabbitAsset CREATED") }

    sendTransaction.transferAsset(madHatterAsset, 10, whiteRabbit, madHatter.asAccountId(), madHatterKeyPair)
        .also { println("$madHatter TRANSFERRED FROM $madHatterAsset TO $whiteRabbitAsset: 10") }
    query.getAccountAmount(madHatter, madHatterAsset).also { println("$madHatterAsset BALANCE: $it") }
    query.getAccountAmount(whiteRabbit, whiteRabbitAsset).also { println("$whiteRabbitAsset BALANCE: $it") }

    sendTransaction.burnAssets(madHatterAsset, 10, madHatter.asAccountId(), madHatterKeyPair)
        .also { println("$madHatterAsset WAS BURN") }

    query.getAccountAmount(madHatter, madHatterAsset)
        .also { println("$madHatterAsset BALANCE: $it AFTER ASSETS BURNING") }
}
