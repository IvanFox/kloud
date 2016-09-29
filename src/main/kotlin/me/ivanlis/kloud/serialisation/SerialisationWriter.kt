package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 28/09/2016.
 * Student Course: Software Development
 */
class SerialisationWriter {

    val HEADER: ByteArray = "KS".toByteArray()
    val VERSION: Short = 0x0100

    // Byte capacity: 1 Byte
    fun writeBytes(dest: ByteArray, pointer: Int, value: Byte): Int {
        dest[pointer] = value
        return pointer.inc()
    }

    // Short capacity: 2 Bytes
    fun writeBytes(dest: ByteArray, pointer: Int, value: Short): Int {
        var pointer = pointer
        dest[pointer++] = value.toInt().shr(8).and(0xFF).toByte()
        dest[pointer++] = value.toInt().and(0xFF).toByte()
        return pointer
    }

    // Char capacity: unsigned short / 2 bytes
    fun writeBytes(dest: ByteArray, pointer: Int, value: Char): Int {
        var pointer = pointer
        dest[pointer++] = value.toInt().shr(8).and(0xFF).toByte()
        dest[pointer++] = value.toInt().and(0xFF).toByte()
        return pointer
    }

    // Int capacity: 4 Bytes
    fun writeBytes(dest: ByteArray, pointer: Int, value: Int): Int {
        var pointer = pointer
        dest[pointer++] = value.toInt().shr(24).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(16).and(0xFF).toByte()
        dest[pointer++] = value.toInt().shr(8).and(0xFF).toByte()
        dest[pointer++] = value.toInt().and(0xFF).toByte()
        return pointer
    }

    // Long capacity: 8 Bytes
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

    // Float capacity: 4 bytes
    fun writeBytes(dest: ByteArray, pointer: Int, value: Float) : Int {
        val floatToIntBits = java.lang.Float.floatToIntBits(value)
        return writeBytes(dest, pointer, floatToIntBits)
    }

    // Double capacity: 8 bytes
    fun writeBytes(dest: ByteArray, pointer: Int, value: Double) : Int {
        val doubleToLongBits = java.lang.Double.doubleToLongBits(value)
        return writeBytes(dest, pointer, doubleToLongBits)
    }




}