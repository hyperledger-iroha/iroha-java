@file:JvmName("CryptoUtils")

package jp.co.soramitsu.iroha2

import jp.co.soramitsu.iroha2.generated.PublicKey
import net.i2p.crypto.eddsa.EdDSAPrivateKey
import net.i2p.crypto.eddsa.EdDSAPublicKey
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveSpec
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec
import net.i2p.crypto.eddsa.spec.EdDSAPublicKeySpec
import java.security.Key
import java.security.KeyPair
import java.security.SecureRandom

@JvmField
val DEFAULT_SPEC: EdDSANamedCurveSpec = EdDSANamedCurveTable.getByName(EdDSANamedCurveTable.ED_25519)

enum class DigestFunction(val hashFunName: String, val index: Int) {
    Ed25519("ed25519", 0xed),
}

/**
 * Generate Ed25519 key-pair
 *
 * @throws CryptoException if key-pair cannot be generated
 */
@JvmOverloads
fun generateKeyPair(spec: EdDSAParameterSpec = DEFAULT_SPEC): KeyPair {
    return try {
        val seed = ByteArray(spec.curve.field.getb() / 8)
        SecureRandom().nextBytes(seed)

        val privKey = EdDSAPrivateKeySpec(seed, spec)
        val pubKey = EdDSAPublicKeySpec(privKey.a, spec)
        KeyPair(
            EdDSAPublicKey(pubKey),
            EdDSAPrivateKey(privKey),
        )
    } catch (ex: Exception) {
        throw CryptoException("Cannot generate a key pair", ex)
    }
}

@JvmOverloads
fun generatePublicKey(
    spec: EdDSAParameterSpec = DEFAULT_SPEC,
): PublicKey = generateKeyPair(spec).public.toIrohaPublicKey()

/**
 * Create ED25519 key-pair from given hex of the public and private key
 *
 * @throws CryptoException if key-pair cannot be created
 */
@JvmOverloads
fun keyPairFromHex(publicKeyHex: String, privateKeyHex: String, spec: EdDSAParameterSpec = DEFAULT_SPEC) =
    KeyPair(publicKeyFromHex(publicKeyHex, spec), privateKeyFromHex(privateKeyHex, spec))

/**
 * Create ED25519 private key from a given hex
 *
 * @throws CryptoException if key cannot be created from hex
 */
@JvmOverloads
fun privateKeyFromHex(privateKeyHex: String, spec: EdDSAParameterSpec = DEFAULT_SPEC) =
    try {
        EdDSAPrivateKey(EdDSAPrivateKeySpec(privateKeyHex.fromHex(), spec))
    } catch (ex: Exception) {
        throw CryptoException("Cannot create a private key from hex `$privateKeyHex`", ex)
    }

/**
 * Create ED25519 public key from a given hex
 *
 * @throws CryptoException if key cannot be created from hex
 */
@JvmOverloads
fun publicKeyFromHex(publicKeyHex: String, spec: EdDSAParameterSpec = DEFAULT_SPEC) =
    try {
        when (publicKeyHex.startsWith("ed0120")) {
            true -> EdDSAPublicKey(EdDSAPublicKeySpec(publicKeyHex.drop(6).fromHex(), spec))
            false -> EdDSAPublicKey(EdDSAPublicKeySpec(publicKeyHex.fromHex(), spec))
        }
    } catch (ex: Exception) {
        throw CryptoException("Cannot create a public key from hex `$publicKeyHex`", ex)
    }

/**
 * Return encoded representation of the key, which may be different from `java.security.Key.getEncoded()`.
 *
 * Motivation: this method returns encoded bytes of the ED keys (same as in Iroha1 java-lib) and logical replacement of
 * `java.security.Key.getEncoded()` for such keys.
 * By default, keys in `net.i2p.crypto:eddsa` are encoded in `X.509` format.
 *
 * @see java.security.Key.getEncoded
 * @see java.security.Key.getFormat
 * @return bytes Encoding of the key (empty if encoding is not supported)
 */
fun Key.bytes(): ByteArray {
    return when (this) {
        is EdDSAPublicKey -> abyte
        is EdDSAPrivateKey -> seed
        else -> this.encoded ?: ByteArray(0)
    }
}
