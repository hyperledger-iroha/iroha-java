package jp.co.soramitsu.iroha2

import io.ktor.websocket.Frame
import jp.co.soramitsu.iroha2.generated.crypto.hash.Hash
import jp.co.soramitsu.iroha2.generated.crypto.signature.Signature
import jp.co.soramitsu.iroha2.generated.crypto.signature.SignatureOf
import jp.co.soramitsu.iroha2.generated.datamodel.IdBox
import jp.co.soramitsu.iroha2.generated.datamodel.IdentifiableBox
import jp.co.soramitsu.iroha2.generated.datamodel.RegistrableBox
import jp.co.soramitsu.iroha2.generated.datamodel.Value
import jp.co.soramitsu.iroha2.generated.datamodel.account.AccountId
import jp.co.soramitsu.iroha2.generated.datamodel.asset.AssetId
import jp.co.soramitsu.iroha2.generated.datamodel.asset.DefinitionId
import jp.co.soramitsu.iroha2.generated.datamodel.domain.DomainId
import jp.co.soramitsu.iroha2.generated.datamodel.expression.EvaluatesTo
import jp.co.soramitsu.iroha2.generated.datamodel.expression.Expression
import jp.co.soramitsu.iroha2.generated.datamodel.name.Name
import jp.co.soramitsu.iroha2.generated.datamodel.permission.token.Token
import jp.co.soramitsu.iroha2.generated.datamodel.permission.token.TokenId
import jp.co.soramitsu.iroha2.generated.datamodel.role.RoleId
import jp.co.soramitsu.iroha2.generated.datamodel.transaction.Payload
import jp.co.soramitsu.iroha2.generated.datamodel.transaction.SignedTransaction
import jp.co.soramitsu.iroha2.generated.datamodel.transaction.VersionedSignedTransaction
import jp.co.soramitsu.iroha2.generated.datamodel.trigger.TriggerId
import net.i2p.crypto.eddsa.EdDSAEngine
import org.bouncycastle.jcajce.provider.digest.Blake2b
import org.bouncycastle.util.encoders.Hex
import java.math.BigInteger
import java.security.KeyPair
import java.security.MessageDigest
import java.security.PrivateKey
import java.security.PublicKey

fun <T> Signature.asSignatureOf() = SignatureOf<T>(this)

fun String.asAccountId() = this.split(ACCOUNT_ID_DELIMITER).takeIf {
    it.size == 2
}?.let { parts ->
    AccountId(parts[0].asName(), parts[1].asDomainId())
} ?: throw IllegalArgumentException("Incorrect account ID: $this")

fun String.asAssetDefinitionId() = this.split(ASSET_ID_DELIMITER).takeIf {
    it.size == 2
}?.let { parts ->
    DefinitionId(parts[0].asName(), parts[1].asDomainId())
} ?: throw IllegalArgumentException("Incorrect asset definition ID: $this")

fun String.asAssetId() = this.split(ASSET_ID_DELIMITER).takeIf {
    it.size == 3
}?.let { parts ->
    parts[2].asAccountId().let { accountId ->
        val domainId = parts[1].takeIf { it.isNotBlank() }?.asDomainId()
        AssetId(
            DefinitionId(
                parts[0].asName(),
                domainId ?: accountId.domainId
            ),
            accountId
        )
    }
} ?: throw IllegalArgumentException("Incorrect asset ID: $this")

fun String.asDomainId() = DomainId(Name(this))

fun String.asName() = Name(this)

fun String.asValue() = Value.String(this)

fun Int.asValue() = this.toLong().asValue()

fun Long.asValue() = Value.U32(this)

fun BigInteger.asValue() = Value.U128(this)

fun Boolean.asValue() = Value.Bool(this)

fun AccountId.asValue() = Value.Id(IdBox.AccountId(this))

fun ByteArray.toFrame(fin: Boolean = true) = Frame.Binary(fin, this)

fun ByteArray.toHex(): String = try {
    Hex.toHexString(this)
} catch (ex: Exception) {
    throw HexCodecException("Cannot encode to hex string", ex)
}

fun String.fromHex(): ByteArray = try {
    Hex.decode(this)
} catch (ex: Exception) {
    throw HexCodecException("Cannot decode from hex string `$this`", ex)
}

/**
 * Convert a public key to an Iroha public key
 */
fun PublicKey.toIrohaPublicKey(): jp.co.soramitsu.iroha2.generated.crypto.PublicKey {
    return jp.co.soramitsu.iroha2.generated.crypto.PublicKey(DigestFunction.Ed25519.hashFunName, this.bytes())
}

/**
 * Sign the [message] using the given private key
 *
 * Note: the message must not be prehashed
 */
fun PrivateKey.sign(message: ByteArray): ByteArray = try {
    val sgr = EdDSAEngine(MessageDigest.getInstance(DEFAULT_SPEC.hashAlgorithm))
    sgr.initSign(this)
    sgr.update(message.hash())
    sgr.sign()
} catch (ex: Exception) {
    throw CryptoException("Cannot sign message", ex)
}

/**
 * Verify the [signature] against the [message] and the given public key
 *
 * Note: the message must not be prehashed
 */
fun PublicKey.verify(signature: ByteArray, message: ByteArray): Boolean = try {
    val sgr = EdDSAEngine(MessageDigest.getInstance(DEFAULT_SPEC.hashAlgorithm))
    sgr.initVerify(this)
    sgr.update(message.hash())
    sgr.verify(signature)
} catch (ex: Exception) {
    throw CryptoException("Cannot verify message", ex)
}

fun ByteArray.hash(): ByteArray = Blake2b.Blake2b256().digest(this)

/**
 * Hash the given versioned transaction (`VersionedTransaction.V1`)
 */
fun VersionedSignedTransaction.V1.hash(): ByteArray {
    return this.signedTransaction
        .payload
        .let { Payload.encode(it) }
        .hash()
}

/**
 * Hash the given versioned transaction. Maintains only `VersionedTransaction.V1`
 */
fun VersionedSignedTransaction.hash() = when (this) {
    is VersionedSignedTransaction.V1 -> this.hash()
}

/**
 * Append signatures to a transaction. Maintains only `VersionedTransaction.V1`
 */
fun VersionedSignedTransaction.appendSignatures(vararg keypairs: KeyPair): VersionedSignedTransaction {
    return when (this) {
        is VersionedSignedTransaction.V1 -> {
            val encodedPayload = signedTransaction
                .payload
                .let { Payload.encode(it) }
            val signatures = keypairs.map {
                Signature(
                    it.public.toIrohaPublicKey(),
                    it.private.sign(encodedPayload)
                ).asSignatureOf<Payload>()
            }.toSet()

            VersionedSignedTransaction.V1(
                SignedTransaction(
                    signedTransaction.payload,
                    signedTransaction.signatures.plus(signatures)
                )
            )
        }
    }
}

/**
 * Cast to another type
 */
inline fun <reified B> Any.cast(): B {
    return this as? B
        ?: throw ClassCastException("Could not cast `${this::class.qualifiedName}` to `${B::class.qualifiedName}`")
}

/**
 * Wrap an object in `EvaluatesTo`
 */
inline fun <reified T> T.evaluatesTo(): EvaluatesTo<T> {
    return when (this) {
        is String -> Value.String(this)
        is Boolean -> Value.Bool(this)
        is AssetId -> Value.Id(IdBox.AssetId(this))
        is DefinitionId -> Value.Id(IdBox.AssetDefinitionId(this))
        is AccountId -> Value.Id(IdBox.AccountId(this))
        is DomainId -> Value.Id(IdBox.DomainId(this))
        is RoleId -> Value.Id(IdBox.RoleId(this))
        is TriggerId -> Value.Id(IdBox.TriggerId(this))
        is IdBox -> Value.Id(this)
        is Hash -> Value.Hash(this)
        is Name -> Value.Name(this)
        is Token -> Value.PermissionToken(this)
        is IdentifiableBox -> Value.Identifiable(this)
        is RegistrableBox -> Value.Identifiable(this.toIdentifiableBox())
        is Value -> this
        else -> throw IllegalArgumentException("Unsupported value type `${T::class.qualifiedName}`")
    }.let { value ->
        EvaluatesTo(Expression.Raw(value))
    }
}

fun AccountId.toValueId() = Value.Id(IdBox.AccountId(this))

fun AssetId.toValueId() = Value.Id(IdBox.AssetId(this))

fun DefinitionId.toValueId() = Value.Id(IdBox.AssetDefinitionId(this))

fun RegistrableBox.toIdentifiableBox() = when (this) {
    is RegistrableBox.Account -> IdentifiableBox.NewAccount(this.newAccount)
    is RegistrableBox.Peer -> IdentifiableBox.Peer(this.peer)
    is RegistrableBox.Asset -> IdentifiableBox.Asset(this.asset)
    is RegistrableBox.AssetDefinition -> IdentifiableBox.NewAssetDefinition(this.newAssetDefinition)
    is RegistrableBox.Role -> IdentifiableBox.NewRole(this.newRole)
    is RegistrableBox.Domain -> IdentifiableBox.NewDomain(this.newDomain)
    is RegistrableBox.Trigger -> IdentifiableBox.Trigger(this.trigger)
    is RegistrableBox.PermissionTokenDefinition -> IdentifiableBox.PermissionTokenDefinition(
        this.definition
    )

    is RegistrableBox.Validator -> IdentifiableBox.Validator(this.validator)
}

fun <T> T.asValue() = when (this) {
    is String -> this.asValue()
    is Long -> this.asValue()
    is Int -> this.asValue()
    is BigInteger -> this.asValue()
    is Boolean -> this.asValue()
    is AccountId -> this.asValue()
    else -> throw RuntimeException("Unsupported type")
}

fun AssetId.asString() = this.definitionId.asString() + ASSET_ID_DELIMITER + this.accountId.asString()

fun DefinitionId.asString() = this.name.string + ASSET_ID_DELIMITER + this.domainId.name.string

fun AccountId.asString() = this.name.string + ACCOUNT_ID_DELIMITER + this.domainId.name.string

fun DomainId.asString() = this.name.string

fun TokenId.asString() = this.name.string

fun RoleId.asString() = this.name.string

fun TriggerId.asString() = when (this.domainId) {
    null -> this.name.string
    else -> this.name.string + TRIGGER_ID_DELIMITER + this.domainId!!.name.string
}
