package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.crypto.PublicKey
import jp.co.soramitsu.iroha2.generated.crypto.signature.SignatureOf
import jp.co.soramitsu.iroha2.generated.datamodel.account.AccountId
import jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetId
import jp.co.soramitsu.iroha2.generated.datamodel.asset.DefinitionId
import jp.co.soramitsu.iroha2.generated.datamodel.name.Name
import jp.co.soramitsu.iroha2.generated.datamodel.permission.token.Token
import jp.co.soramitsu.iroha2.generated.datamodel.role.RoleId
import kotlin.reflect.KClass

/**
 * Compare strings
 */
@JvmName("StringComparator")
fun String.Companion.comparator() = compareBy<String> { it }

/**
 * Compare Names
 */
@JvmName("NameComparator")
fun Name.Companion.comparator() = compareBy<Name> { it.string }

/**
 * Compare account IDs
 */
@JvmName("AccountIdComparator")
fun AccountId.Companion.comparator() = compareBy<AccountId> { it.name.string }
    .thenBy { it.domainId.name.string }

/**
 * Compare asset definition IDs
 */
@JvmName("AssetDefinitionIdComparator")
fun DefinitionId.Companion.comparator() = compareBy<DefinitionId> { it.name.string }
    .thenBy { it.domainId.name.string }

/**
 * Compare asset IDs
 */
@JvmName("AssetIdComparator")
fun AssetId.Companion.comparator() = Comparator<AssetId> { o1, o2 ->
    DefinitionId.comparator().compare(
        o1.definitionId,
        o2.definitionId
    )
}.thenComparator { o1, o2 ->
    AccountId.comparator().compare(o1.accountId, o2.accountId)
}

/**
 * Compare role IDs
 */
@JvmName("RoleIdComparator")
fun RoleId.Companion.comparator() = compareBy<RoleId> { it.name.string }

/**
 * Compare public keys
 */
@JvmName("PublicKeyComparator")
fun PublicKey.Companion.comparator() = Comparator<PublicKey> { o1, o2 ->
    ByteArray::class.comparator().compare(o1.payload, o2.payload)
}

/**
 * Compare signatures
 */
@JvmName("SignatureOfComparator")
fun SignatureOf.Companion.comparator() = Comparator<SignatureOf<*>> { o1, o2 ->
    PublicKey.comparator().compare(
        o1.signature.publicKey,
        o2.signature.publicKey
    )
}.thenComparator { o1, o2 ->
    ByteArray::class.comparator().compare(
        o1.signature.payload,
        o2.signature.payload
    )
}

/**
 * Compare permission tokens
 */
@JvmName("PermissionTokenComparator")
fun Token.Companion.comparator() = compareBy<Token> {
    it.definitionId.name.string
}.thenComparator { o1, o2 ->
    val keys1 = o1.params.map { it.key.string }
    val keys2 = o2.params.map { it.key.string }

    keys1.forEachIndexed { index, k1 ->
        val result = keys2.getOrNull(index)
            ?.let { k2 -> k1.compareTo(k2) }
            ?: 1
        if (result != 0) return@thenComparator result
    }

    keys1.size.compareTo(keys2.size)
}

private fun KClass<ByteArray>.comparator() = Comparator<ByteArray> { o1, o2 ->
    if (o1.size != o2.size) {
        throw ComparisonException("Unexpected payload length")
    }

    o1.forEachIndexed { index, b1 ->
        val result = b1.compareTo(o2[index])
        if (result != 0) return@Comparator result
    }
    return@Comparator 0
}

/**
 * Throw if an exception occurs during comparison
 */
class ComparisonException(message: String) : RuntimeException(message)
