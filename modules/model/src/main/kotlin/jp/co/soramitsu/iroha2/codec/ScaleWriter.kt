package jp.co.soramitsu.iroha2.codec

import java.io.ByteArrayOutputStream

/**
 * SCALE codec writer for a complex data type
 *
 * @param <T> type </T>
 */
interface ScaleWriter<T> {
    /**
     * Write SCALE value to the specified writer.
     *
     * @param writer writer with the data
     * @param instance the data to write
     */
    fun write(
        writer: ScaleCodecWriter,
        instance: T,
    )

    /**
     * Encode provided data as a SCALE value
     */
    fun encode(data: T): ByteArray {
        // resource is freed inside `ScaleCodecWriter`
        val buffer = ByteArrayOutputStream()
        val scaleCodecWriter = ScaleCodecWriter(buffer)
        this.write(scaleCodecWriter, data)
        return buffer.toByteArray()
    }
}
