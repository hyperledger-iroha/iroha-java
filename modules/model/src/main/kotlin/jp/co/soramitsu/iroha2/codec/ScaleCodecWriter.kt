package jp.co.soramitsu.iroha2.codec

import java.io.Closeable
import java.io.IOException
import java.io.OutputStream
import java.math.BigInteger
import jp.co.soramitsu.iroha2.codec.writer.BoolOptionalWriter
import jp.co.soramitsu.iroha2.codec.writer.BoolWriter
import jp.co.soramitsu.iroha2.codec.writer.CompactBigIntWriter
import jp.co.soramitsu.iroha2.codec.writer.CompactUIntWriter
import jp.co.soramitsu.iroha2.codec.writer.Int32Writer
import jp.co.soramitsu.iroha2.codec.writer.Int64Writer
import jp.co.soramitsu.iroha2.codec.writer.IntWriter
import jp.co.soramitsu.iroha2.codec.writer.UInt16Writer
import jp.co.soramitsu.iroha2.codec.writer.UInt32Writer
import jp.co.soramitsu.iroha2.codec.writer.UIntWriter

class ScaleCodecWriter(private val out: OutputStream) : Closeable {

    fun writeByteArray(value: ByteArray) {
        out.write(value, 0, value.size)
    }

    fun writeAsList(value: ByteArray) {
        writeCompact(value.size)
        out.write(value, 0, value.size)
    }

    /**
     * Write the byte into output stream as-is directly, the input is supposed to be already encoded
     *
     * @param b byte to write
     * @throws IOException if failed to write
     */
    fun directWrite(b: Int) {
        out.write(b)
    }

    fun directWrite(b: Long) {
        out.write(b.toInt())
    }

    fun directWrite(b: BigInteger) {
        out.write(b.toInt())
    }

    /**
     * Write the bytes into output stream as-is directly, the input is supposed to be already encoded
     */
    fun directWrite(bytes: ByteArray, offset: Int, length: Int) {
        out.write(bytes, offset, length)
    }

    fun flush() {
        out.flush()
    }

    override fun close() {
        out.close()
    }

    fun <T> write(writer: ScaleWriter<T>, value: T) {
        writer.write(this, value)
    }

    fun <T> writeNullable(writer: ScaleWriter<T>, value: T?) {
        when (writer) {
            is BoolWriter, is BoolOptionalWriter -> BOOL_OPT.write(this, value as Boolean?)
            else -> when (value) {
                null -> BOOL.write(this, false)
                else -> {
                    BOOL.write(this, true)
                    writer.write(this, value)
                }
            }
        }
    }

    fun writeByte(value: Int) {
        directWrite(value)
    }

    fun writeByte(value: Byte) {
        directWrite(value.toInt())
    }

    fun writeUint16(value: Int) {
        UINT16.write(this, value)
    }

    fun writeUint32(value: Long) {
        UINT32.write(this, value)
    }

    fun writeUint64(value: BigInteger) {
        UINT64.write(this, value)
    }

    fun writeUint128(value: BigInteger) {
        UINT128.write(this, value)
    }

    fun writeUint256(value: BigInteger) {
        UINT256.write(this, value)
    }

    fun writeInt32(value: Int) {
        INT32.write(this, value)
    }

    fun writeInt64(value: Long) {
        INT64.write(this, value)
    }

    fun writeInt128(value: BigInteger) {
        INT128.write(this, value)
    }

    fun writeInt256(value: BigInteger) {
        INT256.write(this, value)
    }

    fun writeCompact(value: Int) {
        COMPACT_UINT.write(this, value)
    }

    companion object {
        val COMPACT_UINT = CompactUIntWriter()
        val COMPACT_BIGINT = CompactBigIntWriter()
        val UINT16 = UInt16Writer()
        val UINT32 = UInt32Writer()
        val UINT64 = UIntWriter(64)
        val UINT128 = UIntWriter(128)
        val UINT256 = UIntWriter(256)
        val INT32 = Int32Writer()
        val INT64 = Int64Writer()
        val INT128 = IntWriter(128)
        val INT256 = IntWriter(256)
        val BOOL = BoolWriter()
        val BOOL_OPT = BoolOptionalWriter()
    }
}
