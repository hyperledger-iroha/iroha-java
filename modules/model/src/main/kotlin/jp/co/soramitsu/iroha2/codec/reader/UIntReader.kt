package jp.co.soramitsu.iroha2.codec.reader

import jp.co.soramitsu.iroha2.codec.ScaleCodecReader
import jp.co.soramitsu.iroha2.codec.ScaleReader
import java.math.BigInteger

class UIntReader(private val bit: Int) : ScaleReader<BigInteger> {
    override fun read(reader: ScaleCodecReader): BigInteger {
        var result = BigInteger.ZERO
        result = result.add(BigInteger.valueOf(reader.readUByte().toLong()))
        for (n in 8..bit - 8 step 8) {
            result = result.add(BigInteger.valueOf(reader.readUByte().toLong()).shiftLeft(n))
        }
        return result
    }
}

class UInt32Reader : ScaleReader<Long> {
    override fun read(reader: ScaleCodecReader): Long {
        var result: Long = 0
        result += reader.readUByte().toLong()
        result += reader.readUByte().toLong() shl 8
        result += reader.readUByte().toLong() shl 16
        result += reader.readUByte().toLong() shl 24
        return result
    }
}

class UInt16Reader : ScaleReader<Int> {
    override fun read(reader: ScaleCodecReader): Int {
        var result = 0
        result += reader.readUByte()
        result += reader.readUByte() shl 8
        return result
    }
}
