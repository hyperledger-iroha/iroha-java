package jp.co.soramitsu.iroha2.codec

import jp.co.soramitsu.iroha2.MAX_POWER_OF_TWO
import jp.co.soramitsu.iroha2.codec.reader.BoolNullableReader
import jp.co.soramitsu.iroha2.codec.reader.BoolReader
import jp.co.soramitsu.iroha2.codec.reader.CompactBigIntReader
import jp.co.soramitsu.iroha2.codec.reader.CompactUIntReader
import jp.co.soramitsu.iroha2.codec.reader.Int32Reader
import jp.co.soramitsu.iroha2.codec.reader.Int64Reader
import jp.co.soramitsu.iroha2.codec.reader.IntReader
import jp.co.soramitsu.iroha2.codec.reader.StringReader
import jp.co.soramitsu.iroha2.codec.reader.UByteReader
import jp.co.soramitsu.iroha2.codec.reader.UInt16Reader
import jp.co.soramitsu.iroha2.codec.reader.UInt32Reader
import jp.co.soramitsu.iroha2.codec.reader.UIntReader
import java.math.BigInteger
import kotlin.math.abs

/**
 * SCALE codec reader
 */
class ScaleCodecReader(private val source: ByteArray) {
    private var pos = 0

    /**
     * @return true if there are still elements to read
     */
    operator fun hasNext(): Boolean {
        return pos < source.size
    }

    /**
     * Move the reader's position forward (or backward for negative value)
     *
     * @param len the number of bytes to skip
     */
    fun skip(len: Int) {
        require(!(len < 0 && abs(len) > pos)) { "Position cannot be negative: $pos $len" }
        pos += len
    }

    /**
     * Specify a new position for the reader
     *
     * @param pos position
     */
    fun seek(pos: Int) {
        require(pos >= 0) { "Position cannot be negative: $pos" }
        require(pos < source.size) { "Position " + pos + " must be strictly smaller than source length: " + source.size }
        this.pos = pos
    }

    /**
     * Read the next byte
     */
    fun readByte(): Byte {
        if (!hasNext()) {
            throw IndexOutOfBoundsException("Cannot read " + pos + " of " + source.size)
        }
        return source[pos++]
    }

    fun <T> read(scaleReader: ScaleReader<T>?): T {
        if (scaleReader == null) {
            throw NullPointerException("ItemReader cannot be null")
        }
        return scaleReader.read(this)
    }

    fun <T> readNullable(scaleReader: ScaleReader<T>): T? {
        if (scaleReader is BoolReader || scaleReader is BoolNullableReader) {
            return BOOL_NULLABLE.read(this) as T?
        }
        val nullable = readBoolean()
        return when (nullable) {
            true -> read(scaleReader)
            else -> null
        }
    }

    inline fun <reified T : Any> readNullable(): T? {
        return when (T::class) {
            BigInteger::class -> when (readBoolean()) {
                true -> readUint64()
                else -> null
            } as T?
            Long::class -> when (readBoolean()) {
                true -> readUint32()
                else -> null
            } as T?
            Int::class -> when (readBoolean()) {
                true -> readUint16()
                else -> null
            } as T?
            String::class -> when (readBoolean()) {
                true -> readString()
                else -> null
            } as T?
            else -> throw IllegalArgumentException("Unsupported value type `${T::class.qualifiedName}`")
        }
    }

    /**
     * Read Java Integer encoded as unsigned byte SCALE value
     */
    fun readUByte(): Int {
        return UBYTE.read(this)
    }

    /**
     * Read Java Integer encoded as unsigned 16-bit integer SCALE value
     */
    fun readUint16(): Int {
        return UINT16.read(this)
    }

    /**
     * Read Java Long Integer encoded as unsigned 32-bit integer SCALE value
     */
    fun readUint32(): Long {
        return UINT32.read(this)
    }

    /**
     * Read Java Big Integer encoded as unsigned 64-bit integer SCALE value
     */
    fun readUint64(): BigInteger {
        return UINT64.read(this)
    }

    /**
     * Read Java Big Integer encoded as unsigned 128-bit integer SCALE value
     */
    fun readUint128(): BigInteger {
        return UINT128.read(this)
    }

    /**
     * Read Java Big Integer encoded as unsigned 256-bit integer SCALE value
     */
    fun readUint256(): BigInteger {
        return UINT256.read(this)
    }

    /**
     * Read Java Integer encoded as 32-bit integer SCALE value
     */
    fun readInt32(): Int {
        return INT32.read(this)
    }

    /**
     * Read a Java Long Integer encoded as 64-bit integer SCALE value
     */
    fun readInt64(): Long {
        return INT64.read(this)
    }

    /**
     * Read a Java Big Integer encoded as 128-bit integer SCALE value
     */
    fun readInt128(): BigInteger {
        return INT128.read(this)
    }

    /**
     * Read a Java Big Integer encoded as 256-bit integer SCALE value
     */
    fun readInt256(): BigInteger {
        return INT256.read(this)
    }

    /**
     * Read an unsigned integer
     */
    fun readCompactInt(): Int {
        return COMPACT_UINT.read(this)
    }

    /**
     * Read a Boolean value
     */
    fun readBoolean(): Boolean {
        return BOOL.read(this)
    }

    /**
     * Read a byte array
     */
    fun readByteArray(): ByteArray {
        val len = readCompactInt()
        return readByteArray(len)
    }

    /**
     * Read a byte array of a specified [length][len]
     */
    fun readByteArray(len: Int): ByteArray {
        val result = ByteArray(len)
        System.arraycopy(source, pos, result, 0, result.size)
        pos += len
        return result
    }

    /**
     * Read a set
     */
    fun <T> readSet(size: Int, supplier: () -> T): MutableSet<T> {
        val set = HashSet<T>(capacity(size))
        for (index in 0 until size) {
            set.add(supplier())
        }
        return set
    }

    /**
     * Read a map
     */
    fun <K, V> readMap(size: Int, key: () -> K, value: () -> V): MutableMap<K, V> {
        val map = HashMap<K, V>(capacity(size))
        for (index in 0 until size) {
            map[key()] = value()
        }
        return map
    }

    /**
     * Read an array of a specified [size]
     */
    inline fun <reified T> readArray(size: Int, supplier: () -> T): Array<T> {
        return Array(size) { supplier() }
    }

    /**
     * Read a vector of a specified [size]
     */
    fun <T> readVec(size: Int, supplier: () -> T): List<T> {
        return List(size) { supplier() }
    }

    /**
     * Read a string encoded as UTF-8 bytes
     *
     * @return String value
     */
    fun readString(): String {
        return String(readByteArray())
    }

    private fun capacity(expectedSize: Int): Int {
        return when {
            expectedSize < 0 -> throw IllegalArgumentException("Expected size cannot be negative but was: $expectedSize")
            expectedSize < 3 -> expectedSize + 1
            expectedSize < MAX_POWER_OF_TWO -> (expectedSize.toFloat() / 0.75f + 1.0f).toInt()
            else -> Int.MAX_VALUE
        }
    }

    companion object {
        val UBYTE = UByteReader()
        val UINT16 = UInt16Reader()
        val UINT32 = UInt32Reader()
        val UINT64 = UIntReader(64)
        val UINT128 = UIntReader(128)
        val UINT256 = UIntReader(256)
        val INT32 = Int32Reader()
        val INT64 = Int64Reader()
        val INT128 = IntReader(128)
        val INT256 = IntReader(256)
        val COMPACT_UINT = CompactUIntReader()
        val COMPACT_BIGINT = CompactBigIntReader()
        val BOOL = BoolReader()
        val BOOL_NULLABLE = BoolNullableReader()
        val STRING = StringReader()
    }
}
