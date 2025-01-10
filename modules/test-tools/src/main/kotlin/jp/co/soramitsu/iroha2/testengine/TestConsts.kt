package jp.co.soramitsu.iroha2.testengine

import jp.co.soramitsu.iroha2.asDomainId
import jp.co.soramitsu.iroha2.asName
import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.keyPairFromHex
import jp.co.soramitsu.iroha2.publicKeyFromHex
import jp.co.soramitsu.iroha2.toIrohaPublicKey

const val DEFAULT_DOMAIN = "wonderland"
const val GENESIS_DOMAIN = "genesis"
const val GENESIS_ADDRESS = "ed01204164BF554923ECE1FD412D241036D863A6AE430476C898248B8237D77534CFC4"
const val GENESIS_PRIVATE_KEY = "82B3BDE54AEBECA4146257DA0DE8D59D8E46D5FE34887DCD8072866792FCB3AD"

@JvmField
val GENESIS_ACCOUNT = AccountId(GENESIS_DOMAIN.asDomainId(), publicKeyFromHex(GENESIS_ADDRESS).toIrohaPublicKey())

@JvmField
val DEFAULT_DOMAIN_ID = DEFAULT_DOMAIN.asDomainId()

@JvmField
val ALICE_KEYPAIR = keyPairFromHex(
    "CE7FA46C9DCE7EA4B125E2E36BDB63EA33073E7590AC92816AE1E861B7048B03",
    "CCF31D85E3B32A4BEA59987CE0C78E3B8E2DB93881468AB2435FE45D5C9DCD53",
)

@JvmField
val ALICE_PUBLIC_KEY = ALICE_KEYPAIR.public.toIrohaPublicKey()

@JvmField
val ALICE_ACCOUNT_ID = AccountId(domain = DEFAULT_DOMAIN_ID, signatory = ALICE_PUBLIC_KEY)

@JvmField
val BOB_KEYPAIR = keyPairFromHex(
    "04FF5B81046DDCCF19E2E451C45DFB6F53759D4EB30FA2EFA807284D1CC33016",
    "AF3F96DEEF44348FEB516C057558972CEC4C75C4DB9C5B3AAC843668854BF828",
)

@JvmField
val BOB_PUBLIC_KEY = BOB_KEYPAIR.public.toIrohaPublicKey()

@JvmField
val BOB_ACCOUNT_ID = AccountId(DEFAULT_DOMAIN_ID, BOB_PUBLIC_KEY)

@JvmField
val DEFAULT_ASSET_DEFINITION_ID = AssetDefinitionId(DEFAULT_DOMAIN_ID, "xor".asName())

@JvmField
val DEFAULT_ASSET_ID = AssetId(ALICE_ACCOUNT_ID, DEFAULT_ASSET_DEFINITION_ID)

@JvmField
val XOR_DEFINITION_ID = AssetDefinitionId(DEFAULT_DOMAIN_ID, "xor".asName())

@JvmField
val VAL_DEFINITION_ID = AssetDefinitionId(DEFAULT_DOMAIN_ID, "val".asName())
