package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.AccountId
import jp.co.soramitsu.iroha2.generated.AssetDefinitionId
import jp.co.soramitsu.iroha2.generated.AssetId
import jp.co.soramitsu.iroha2.generated.CustomParameterId
import jp.co.soramitsu.iroha2.generated.Name
import jp.co.soramitsu.iroha2.generated.Permission
import jp.co.soramitsu.iroha2.generated.PublicKey
import jp.co.soramitsu.iroha2.generated.RoleId
import jp.co.soramitsu.iroha2.generated.SignatureOf
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
fun AccountId.Companion.comparator() = compareBy<AccountId> { it.domain.name.string }.thenComparator { o1, o2 ->
    PublicKey.comparator().compare(o1.signatory, o2.signatory)
}

/**
 * Compare asset definition IDs
 */
@JvmName("AssetDefinitionIdComparator")
fun AssetDefinitionId.Companion.comparator() = compareBy<AssetDefinitionId> { it.name.string }
    .thenBy { it.domain.name.string }

/**
 * Compare asset IDs
 */
@JvmName("AssetIdComparator")
fun AssetId.Companion.comparator() = Comparator<AssetId> { o1, o2 ->
    AssetDefinitionId.comparator().compare(
        o1.definition,
        o2.definition,
    )
}.thenComparator { o1, o2 ->
    AccountId.comparator().compare(o1.account, o2.account)
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
    ByteArray::class.comparator().compare(
        o1.signature.payload,
        o2.signature.payload,
    )
}

/**
 * Compare permissions
 */
@JvmName("PermissionComparator")
fun Permission.Companion.comparator() = compareBy<Permission> {
    it.name
}.thenComparator { o1, o2 ->
    o1.payload?.compareTo(o2.payload ?: "") ?: 0
}

/**
 * Compare custom parameter ID
 */
@JvmName("CustomParameterIdComparator")
fun CustomParameterId.Companion.comparator() = compareBy<CustomParameterId> {
    it.name.string
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
