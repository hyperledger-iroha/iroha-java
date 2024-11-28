@file:Suppress("ktlint:standard:no-wildcard-imports")

package jp.co.soramitsu.iroha2

import com.fasterxml.jackson.module.kotlin.readValue
import jp.co.soramitsu.iroha2.generated.*
import net.i2p.crypto.eddsa.EdDSAEngine
import org.bouncycastle.jcajce.provider.digest.Blake2b
import org.bouncycastle.util.encoders.Hex
import java.math.BigDecimal
import java.math.BigInteger
import java.security.MessageDigest
import java.security.PrivateKey
import java.security.PublicKey
import kotlin.experimental.or
import jp.co.soramitsu.iroha2.generated.PublicKey as IrohaPublicKey

fun BlockSubscriptionRequest.Companion.of(from: Long) = BlockSubscriptionRequest(NonZeroOfu64(BigInteger.valueOf(from)))

fun <T> Signature.asSignatureOf() = SignatureOf<T>(this)

fun String.asAccountId() = this.split(ACCOUNT_ID_DELIMITER).takeIf {
    it.size == 2
}?.let { parts ->
    AccountId(parts[1].asDomainId(), publicKeyFromHex(parts[0]).toIrohaPublicKey())
} ?: throw IllegalArgumentException("Incorrect account ID: $this")

fun String.asAssetDefinitionId() = this.split(ASSET_ID_DELIMITER).takeIf {
    it.size == 2
}?.let { parts ->
    AssetDefinitionId(parts[1].asDomainId(), parts[0].asName())
} ?: throw IllegalArgumentException("Incorrect asset definition ID: $this")

fun String.asAssetId() = this.split(ASSET_ID_DELIMITER).takeIf {
    it.size == 3
}?.let { parts ->
    parts[2].asAccountId().let { accountId ->
        val domainId = parts[1].takeIf { it.isNotBlank() }?.asDomainId()

        AssetId(
            accountId,
            AssetDefinitionId(
                domainId ?: accountId.domain,
                parts[0].asName(),
            ),
        )
    }
} ?: throw IllegalArgumentException("Incorrect asset ID: $this")

fun String.asDomainId() = DomainId(Name(this))

fun String.asRoleId() = RoleId(Name(this))

fun String.asName() = Name(this)

fun ByteArray.toHex(withPrefix: Boolean = false): String = try {
    val prefix = when (withPrefix) {
        true -> "ed0120"
        false -> ""
    }
    "${prefix}${Hex.toHexString(this)}"
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
fun PublicKey.toIrohaPublicKey(): IrohaPublicKey = IrohaPublicKey(Algorithm.Ed25519(), this.bytes())

/**
 * Sign the [message] using the given private key
 *
 * Note: the message must not be prehashed
 */
fun PrivateKey.signAs(message: ByteArray): ByteArray = try {
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

fun ByteArray.toIrohaHash(): Hash {
    if (this.size != 32) throw IrohaSdkException("Hash byte array size must be 32")

    this[31] = this[31] or 1
    return Hash(this)
}

fun <T> ByteArray.asHashOf() = HashOf<T>(this.toIrohaHash())

fun ByteArray.hash(): ByteArray {
    val bytes = Blake2b.Blake2b256().digest(this)
    bytes[bytes.size - 1] = bytes[bytes.size - 1] or 1
    return bytes
}

/**
 * Hash the given versioned transaction. Maintains only `VersionedTransaction.V1`
 */
fun SignedTransaction.hash() = SignedTransaction.encode(this).hash()

/**
 * Cast to another type
 */
inline fun <reified B> Any.cast(): B = this as? B
    ?: throw ClassCastException("Could not cast `${this::class.qualifiedName}` to `${B::class.qualifiedName}`")

fun AssetId.asString(withPrefix: Boolean = true) = this.definition.asString() + ASSET_ID_DELIMITER + this.account.asString(withPrefix)

fun AssetDefinitionId.asString() = this.name.string + ASSET_ID_DELIMITER + this.domain.name.string

fun AccountId.asString(withPrefix: Boolean = true) = this.signatory.payload.toHex(withPrefix) +
    ACCOUNT_ID_DELIMITER + this.domain.name.string

inline fun <reified T> Json.readValue(): T = JSON_SERDE.readValue(this.string)
fun <V> Json.Companion.writeValue(value: V): Json {
    val value = JSON_SERDE.writeValueAsString(value)

    if (value == "{ }") {
        return Json("null")
    }

    return Json(value)
}

fun DomainId.asString() = this.name.string

fun RoleId.asString() = this.name.string

fun SocketAddr.asString() = when (this) {
    is SocketAddr.Host -> this.socketAddrHost.let { "${it.host}:${it.port}" }
    is SocketAddr.Ipv4 -> this.socketAddrV4.let { "${it.ip}:${it.port}" }
    is SocketAddr.Ipv6 -> this.socketAddrV6.let { "${it.ip}:${it.port}" }
}

fun TriggerId.asString() = this.name.string

fun Metadata.merge(extra: Metadata) = Metadata(
    this.sortedMapOfName.toMutableMap().also { it.putAll(extra.sortedMapOfName) },
)

fun Iterable<InstructionBox>.extractRegisterBoxes() = this.asSequence()
    .filterIsInstance<InstructionBox.Register>()
    .map { it.registerBox }
fun IdBox.extractId(): Any = when (this) {
    is IdBox.RoleId -> this.roleId
    is IdBox.AccountId -> this.accountId
    is IdBox.AssetId -> this.assetId
    is IdBox.AssetDefinitionId -> this.assetDefinitionId
    is IdBox.DomainId -> this.domainId
    is IdBox.TriggerId -> this.triggerId
    is IdBox.PeerId -> this.peerId
    is IdBox.CustomParameterId -> this.customParameterId
    is IdBox.Permission -> this.permission
}

fun InstructionBox.extractAccount() = this
    .cast<InstructionBox.Register>()
    .registerBox
    .cast<RegisterBox.Account>()
    .registerOfAccount.`object`

fun InstructionBox.Register.extractAccount() = this
    .registerBox
    .cast<RegisterBox.Account>()
    .registerOfAccount.`object`

fun InstructionBox.Register.extractDomain() = this
    .cast<InstructionBox.Register>()
    .registerBox
    .cast<RegisterBox.Domain>()
    .registerOfDomain.`object`

fun InstructionBox.Register.extractAssetDefinition() = this
    .cast<InstructionBox.Register>()
    .registerBox
    .cast<RegisterBox.AssetDefinition>()
    .registerOfAssetDefinition.`object`

inline fun <reified I : InstructionBox> SignedTransaction.extractInstruction(): I = this
    .cast<SignedTransaction.V1>()
    .extractInstruction<I>()

inline fun <reified I : InstructionBox> SignedTransaction.V1.extractInstruction() = this
    .extractInstructionVec<I>()
    .first().cast<I>()

inline fun <reified I : InstructionBox> SignedTransaction.V1.extractInstructions() = this
    .extractInstructionVec<I>()
    .cast<List<I>>()

inline fun <reified I : InstructionBox> SignedTransaction.V1.extractInstructionVec() = this
    .signedTransactionV1.payload.instructions
    .cast<Executable.Instructions>()
    .vec.filterIsInstance<I>()

fun InstructionBox.SetKeyValue.extractDomainId() = this
    .cast<InstructionBox.SetKeyValue>()
    .setKeyValueBox
    .cast<SetKeyValueBox.Domain>()
    .setKeyValueOfDomain
    .`object`

fun InstructionBox.Grant.extractValuePermissionToken() = this
    .cast<InstructionBox.Grant>()
    .grantBox
    .cast<GrantBox.Permission>()
    .grantOfPermissionAndAccount
    .`object`

fun EventFilterBox.extractSchedule() = this
    .cast<EventFilterBox.Time>()
    .timeEventFilter.executionTime
    .cast<ExecutionTime.Schedule>().schedule

fun BlockMessage.extractBlock() = this.signedBlock.cast<SignedBlock.V1>().signedBlockV1.payload

fun BlockPayload.height() = this.header.height

fun Asset.metadata() = this.value.cast<AssetValue.Store>().metadata.sortedMapOfName

fun String.toSocketAddr() = this.split(":").let { parts ->
    if (parts.size != 2) throw IrohaSdkException("Incorrect address")

    SocketAddr.Host(SocketAddrHost(parts.first(), parts.last().toInt()))
}

fun FindError.extract() = when (this) {
    is FindError.Account -> this.accountId.asString()
    is FindError.Asset -> this.assetId.asString()
    is FindError.AssetDefinition -> this.assetDefinitionId.asString()
    is FindError.Domain -> this.domainId.asString()
    is FindError.Role -> this.roleId.asString()
    is FindError.Block -> this.hashOf.hash.arrayOfU8.toHex()
    is FindError.MetadataKey -> this.name.string
    is FindError.Peer -> this.peerId.toString()
    is FindError.Permission -> this.permission.name
    is FindError.PublicKey -> this.publicKey.payload.toString()
    is FindError.Trigger -> this.triggerId.asString()
    is FindError.Transaction -> this.hashOf.hash.arrayOfU8.toHex()
}

fun Number.asNumeric() = when (this) {
    is Int -> this.asNumeric()
    is Long -> this.asNumeric()
    is BigInteger -> this.asNumeric()
    is Double -> this.asNumeric()
    is BigDecimal -> this.asNumeric()
    else -> throw IrohaSdkException("Unexpected type to extract numeric ${this::class}")
}

fun String.asNumeric() = Numeric(mantissa = this.toBigInteger(), scale = 0)

fun Int.asNumeric() = Numeric(mantissa = this.toBigInteger(), scale = 0)

fun Long.asNumeric() = Numeric(mantissa = this.toBigInteger(), scale = 0)

fun BigInteger.asNumeric() = Numeric(mantissa = this, scale = 0)

fun Double.asNumeric() = this.toBigDecimal().asNumeric()

fun BigDecimal.asNumeric() = Numeric(mantissa = this.unscaledValue(), scale = this.scale().toLong())

fun Numeric.asInt() = this.mantissa.toInt()

fun Numeric.asLong() = this.mantissa.toLong()

fun Numeric.asBigInteger() = this.mantissa

fun Numeric.asBigDecimal() = BigDecimal.valueOf(this.mantissa.toLong(), this.scale.toInt())

fun Numeric.asNumber() = when (this.scale) {
    0L -> this.mantissa
    else -> this.asBigDecimal()
}

fun Numeric.asString() = this.asNumber().toString()

fun AssetType.Companion.numeric(scale: Long? = null) = AssetType.Numeric(NumericSpec(scale))
fun RegisterOfPeer.asInstructionBoxExt() = InstructionBox.Register(RegisterBox.Peer(this))
fun RegisterOfDomain.asInstructionBoxExt() = InstructionBox.Register(RegisterBox.Domain(this))
fun RegisterOfAssetDefinition.asInstructionBoxExt() = InstructionBox.Register(RegisterBox.AssetDefinition(this))
fun RegisterOfAccount.asInstructionBoxExt() = InstructionBox.Register(RegisterBox.Account(this))
fun RegisterOfAsset.asInstructionBoxExt() = InstructionBox.Register(RegisterBox.Asset(this))
fun RegisterOfRole.asInstructionBoxExt() = InstructionBox.Register(RegisterBox.Role(this))
fun RegisterOfTrigger.asInstructionBoxExt() = InstructionBox.Register(RegisterBox.Trigger(this))

fun UnregisterOfPeer.asInstructionBoxExt() = InstructionBox.Unregister(UnregisterBox.Peer(this))
fun UnregisterOfDomain.asInstructionBoxExt() = InstructionBox.Unregister(UnregisterBox.Domain(this))
fun UnregisterOfAssetDefinition.asInstructionBoxExt() = InstructionBox.Unregister(UnregisterBox.AssetDefinition(this))
fun UnregisterOfAccount.asInstructionBoxExt() = InstructionBox.Unregister(UnregisterBox.Account(this))
fun UnregisterOfAsset.asInstructionBoxExt() = InstructionBox.Unregister(UnregisterBox.Asset(this))
fun UnregisterOfRole.asInstructionBoxExt() = InstructionBox.Unregister(UnregisterBox.Role(this))
fun UnregisterOfTrigger.asInstructionBoxExt() = InstructionBox.Unregister(UnregisterBox.Trigger(this))

fun SetKeyValueOfDomain.asInstructionBoxExt() = InstructionBox.SetKeyValue(SetKeyValueBox.Domain(this))
fun SetKeyValueOfAssetDefinition.asInstructionBoxExt() = InstructionBox.SetKeyValue(SetKeyValueBox.AssetDefinition(this))
fun SetKeyValueOfAccount.asInstructionBoxExt() = InstructionBox.SetKeyValue(SetKeyValueBox.Account(this))
fun SetKeyValueOfAsset.asInstructionBoxExt() = InstructionBox.SetKeyValue(SetKeyValueBox.Asset(this))
fun SetKeyValueOfTrigger.asInstructionBoxExt() = InstructionBox.SetKeyValue(SetKeyValueBox.Trigger(this))

fun RemoveKeyValueOfDomain.asInstructionBoxExt() = InstructionBox.RemoveKeyValue(RemoveKeyValueBox.Domain(this))
fun RemoveKeyValueOfAssetDefinition.asInstructionBoxExt() = InstructionBox.RemoveKeyValue(RemoveKeyValueBox.AssetDefinition(this))
fun RemoveKeyValueOfAccount.asInstructionBoxExt() = InstructionBox.RemoveKeyValue(RemoveKeyValueBox.Account(this))
fun RemoveKeyValueOfAsset.asInstructionBoxExt() = InstructionBox.RemoveKeyValue(RemoveKeyValueBox.Asset(this))
fun RemoveKeyValueOfTrigger.asInstructionBoxExt() = InstructionBox.RemoveKeyValue(RemoveKeyValueBox.Trigger(this))

fun MintOfNumericAndAsset.asInstructionBoxExt() = InstructionBox.Mint(MintBox.Asset(this))
fun MintOfu32AndTrigger.asInstructionBoxExt() = InstructionBox.Mint(MintBox.TriggerRepetitions(this))

fun BurnOfNumericAndAsset.asInstructionBoxExt() = InstructionBox.Burn(BurnBox.Asset(this))
fun BurnOfu32AndTrigger.asInstructionBoxExt() = InstructionBox.Burn(BurnBox.TriggerRepetitions(this))

fun TransferOfAccountAndDomainIdAndAccount.asInstructionBoxExt() = InstructionBox.Transfer(TransferBox.Domain(this))
fun TransferOfAccountAndAssetDefinitionIdAndAccount.asInstructionBoxExt() = InstructionBox.Transfer(TransferBox.AssetDefinition(this))
fun TransferOfAssetAndNumericAndAccount.asInstructionBoxExt() = InstructionBox.Transfer(TransferBox.Asset(AssetTransferBox.Numeric(this)))
fun TransferOfAssetAndMetadataAndAccount.asInstructionBoxExt() = InstructionBox.Transfer(TransferBox.Asset(AssetTransferBox.Store(this)))

fun GrantOfPermissionAndAccount.asInstructionBoxExt() = InstructionBox.Grant(GrantBox.Permission(this))
fun GrantOfRoleIdAndAccount.asInstructionBoxExt() = InstructionBox.Grant(GrantBox.Role(this))
fun GrantOfPermissionAndRole.asInstructionBoxExt() = InstructionBox.Grant(GrantBox.RolePermission(this))

fun RevokeOfPermissionAndAccount.asInstructionBoxExt() = InstructionBox.Revoke(RevokeBox.Permission(this))
fun RevokeOfRoleIdAndAccount.asInstructionBoxExt() = InstructionBox.Revoke(RevokeBox.Role(this))
fun RevokeOfPermissionAndRole.asInstructionBoxExt() = InstructionBox.Revoke(RevokeBox.RolePermission(this))

fun ExecuteTrigger.asInstructionBoxExt() = InstructionBox.ExecuteTrigger(this)
