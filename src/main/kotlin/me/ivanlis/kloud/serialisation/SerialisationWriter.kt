package me.ivanlis.kloud.serialisation

@Suppress("NAME_SHADOWING")
/**
 * Created by ivanlis on 28/09/2016.
 * Student Course: Software Development
 */
class SerialisationWriter {

    val HEADER: ByteArray = "KS".toByteArray()
    val VERSION: Short = 0x0100

    fun writeBytes(dest: ByteArray, pointer: Int, value: Byte): Int {
        dest[pointer] = value
        return pointer.inc()
    }

    fun writeBytes(dest: ByteArray, pointer: Int, value: Short): Int {
        dest[pointer] = value.toInt().shr(8).and(0xFF).toByte()
        dest[pointer.inc()] = value.toInt().and(0xFF).toByte()
        return pointer + 2
    }

    fun writeBytes(dest: ByteArray, pointer: Int, value: Int): Int {
        var pointer = pointer
        dest[pointer++] = value.toInt().shr(24).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(16).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(8).and(0xFF).toByte()
        dest[pointer++] = value.toInt().and(0xFF).toByte()
        return pointer
    }

    fun writeBytes(dest: ByteArray, pointer: Int, value: Long): Int {
        var pointer = pointer
        dest[pointer++] = value.toInt().shr(56).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(48).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(40).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(32).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(24).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(16).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(8).and(0xFF).toByte()
        dest[pointer++] = value.toInt().and(0xFF).toByte()
         return pointer
    }


}