package jp.co.soramitsu.iroha2

import net.i2p.crypto.eddsa.EdDSAPrivateKey
import net.i2p.crypto.eddsa.EdDSAPublicKey
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveSpec
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec
import net.i2p.crypto.eddsa.spec.EdDSAPublicKeySpec
import org.bouncycastle.util.encoders.Hex
import java.security.KeyPair
import java.security.SecureRandom

val DEFAULT_SPEC: EdDSANamedCurveSpec = EdDSANamedCurveTable.getByName(EdDSANamedCurveTable.ED_25519)

enum class DigestFunction(val hashFunName: String, val index: Int) {
    Ed25519("ed25519", 0xed)
}

// todo throw ex
fun generateKeyPair(spec: EdDSAParameterSpec = DEFAULT_SPEC): KeyPair {
    val seed = ByteArray(spec.curve.field.getb() / 8)
    SecureRandom().nextBytes(seed)

    val privKey = EdDSAPrivateKeySpec(seed, spec)
    val pubKey = EdDSAPublicKeySpec(privKey.a, spec)
    return KeyPair(
        PubKeyWrapper(pubKey),
        PrivateKeyWrapper(privKey)
    )
}

fun keyPairFromHex(publicKeyHex: String, privateKeyHex: String, spec: EdDSAParameterSpec = DEFAULT_SPEC) =
    KeyPair(publicKeyFromHex(publicKeyHex, spec), privateKeyFromHex(privateKeyHex, spec))

fun privateKeyFromHex(privateKeyHex: String, spec: EdDSAParameterSpec = DEFAULT_SPEC) =
    EdDSAPrivateKey(EdDSAPrivateKeySpec(Hex.decodeStrict(privateKeyHex), spec))

fun publicKeyFromHex(publicKeyHex: String, spec: EdDSAParameterSpec = DEFAULT_SPEC) =
    EdDSAPublicKey(EdDSAPublicKeySpec(Hex.decodeStrict(publicKeyHex), spec))

// todo remove it
class PubKeyWrapper(pubKeySpec: EdDSAPublicKeySpec) : EdDSAPublicKey(pubKeySpec) {
    override fun getEncoded(): ByteArray = this.abyte
    override fun getFormat() = "RAW"
}

class PrivateKeyWrapper(privKeySpec: EdDSAPrivateKeySpec) : EdDSAPrivateKey(privKeySpec) {
    override fun getEncoded(): ByteArray = this.seed
    override fun getFormat() = "RAW"
}
