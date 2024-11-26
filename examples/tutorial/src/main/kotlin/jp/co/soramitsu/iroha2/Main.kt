package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.AssetType
import jp.co.soramitsu.iroha2.generated.AssetValue
import kotlinx.coroutines.runBlocking
import java.net.URI
import java.util.UUID

fun main(args: Array<String>): Unit = runBlocking {
    val chainId = UUID.fromString("00000000-0000-0000-0000-000000000000")
    val apiUrl = "http://127.0.0.1:8080"
    val peerUrl = "http://127.0.0.1:1337"
    val admin = AccountId(
        "wonderland".asDomainId(),
        publicKeyFromHex("CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03").toIrohaPublicKey(),
    )
    val adminKeyPair = keyPairFromHex(
        "CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03",
        "CCF31D85E3B32A4BEA59987CE0C78E3B8E2DB93881468AB2435FE45D5C9DCD53",
    )
    val client = AdminIroha2Client(listOf(URI(apiUrl).toURL()), chainId, admin, adminKeyPair, log = true)
    val query = Query(client, admin, adminKeyPair)
    query.findAllDomains()
        .also { println("ALL DOMAINS: ${it.map { d -> d.id.asString() }}") }
    query.findAllAccounts()
        .also { println("ALL ACCOUNTS: ${it.map { d -> d.id.asString() }}") }
    query.findAllAssets()
        .also { println("ALL ASSETS: ${it.map { d -> d.id.asString() }}") }

    val sendTransaction = SendTransaction(client, admin, adminKeyPair, chainId)

    val domain = "looking_glass_${System.currentTimeMillis()}"
    sendTransaction.registerDomain(domain).also { println("DOMAIN $domain CREATED") }

    val madHatterKeyPair = generateKeyPair()
    val madHatter = AccountId(domain.asDomainId(), madHatterKeyPair.public.toIrohaPublicKey())
    sendTransaction.registerAccount(madHatter.asString())
        .also { println("ACCOUNT $madHatter CREATED") }

    val assetDefinition = "asset_time_${System.currentTimeMillis()}$ASSET_ID_DELIMITER$domain"
    sendTransaction.registerAssetDefinition(assetDefinition, AssetType.numeric())
        .also { println("ASSET DEFINITION $assetDefinition CREATED") }

    val madHatterAsset = AssetId(madHatter, assetDefinition.asAssetDefinitionId())
    sendTransaction.registerAsset(madHatterAsset, AssetValue.Numeric(100.asNumeric()))
        .also { println("ASSET $madHatterAsset CREATED") }

    val whiteRabbitKeyPair = generateKeyPair()
    val whiteRabbit = AccountId(domain.asDomainId(), whiteRabbitKeyPair.public.toIrohaPublicKey())
    sendTransaction.registerAccount(whiteRabbit.asString())
        .also { println("ACCOUNT $whiteRabbit CREATED") }

    val whiteRabbitAsset = AssetId(whiteRabbit, assetDefinition.asAssetDefinitionId())
    sendTransaction.registerAsset(whiteRabbitAsset, AssetValue.Numeric(0.asNumeric()))
        .also { println("ASSET $whiteRabbitAsset CREATED") }

    sendTransaction.transferAsset(madHatterAsset, 10, whiteRabbit.asString(), madHatter, madHatterKeyPair)
        .also { println("$madHatter TRANSFERRED FROM $madHatterAsset TO $whiteRabbitAsset: 10") }
    query.getAccountAmount(madHatter, madHatterAsset.definition).also { println("$madHatterAsset BALANCE: $it") }
    query.getAccountAmount(whiteRabbit, whiteRabbitAsset.definition).also { println("$whiteRabbitAsset BALANCE: $it") }

    sendTransaction.burnAssets(madHatterAsset, 10, madHatter, madHatterKeyPair)
        .also { println("$madHatterAsset WAS BURN") }

    query.getAccountAmount(madHatter, madHatterAsset.definition)
        .also { println("$madHatterAsset BALANCE: $it AFTER ASSETS BURNING") }
}
