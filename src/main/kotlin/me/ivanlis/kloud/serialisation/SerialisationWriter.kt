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
        dest[pointer++] = value.shr(24).and(0xFF).toByte()
        dest[pointer++] = value.shr(16).and(0xFF).toByte()
        dest[pointer++] = value.shr(8).and(0xFF).toByte()
        dest[pointer++] = value.and(0xFF).toByte()
        return pointer
    }

    // Long capacity: 8 Bytes
    fun writeBytes(dest: ByteArray, pointer: Int, value: Long): Int {
        var pointer = pointer
        dest[pointer++] = value.shr(56).and(0xFF).toByte()
        dest[pointer++] = value.shr(48).and(0xFF).toByte()
        dest[pointer++] = value.shr(40).and(0xFF).toByte()
        dest[pointer++] = value.shr(32).and(0xFF).toByte()
        dest[pointer++] = value.shr(24).and(0xFF).toByte()
        dest[pointer++] = value.shr(16).and(0xFF).toByte()
        dest[pointer++] = value.shr(8).and(0xFF).toByte()
        dest[pointer++] = value.and(0xFF).toByte()
        return pointer
    }

    // Float capacity: 4 bytes
    fun writeBytes(dest: ByteArray, pointer: Int, value: Float): Int {
        val floatToIntBits = java.lang.Float.floatToIntBits(value)
        return writeBytes(dest, pointer, floatToIntBits)
    }

    // Double capacity: 8 bytes
    fun writeBytes(dest: ByteArray, pointer: Int, value: Double): Int {
        val doubleToLongBits = java.lang.Double.doubleToLongBits(value)
        return writeBytes(dest, pointer, doubleToLongBits)
    }

    // Boolean capacity: 1 bytes
    fun writeBytes(dest: ByteArray, pointer: Int, value: Boolean): Int {
        dest[pointer] = if (value.equals(true)) 1.toByte() else 0.toByte()
        return pointer.inc()
    }

    // first 2 bytes represent the length of the string
    fun writeBytes(dest: ByteArray, pointer: Int, value: String) : Int {
        var pointer = writeBytes(dest, pointer, value.length.toShort())
        return writeBytes(dest, pointer, value.toByteArray())
    }


    // Mem copy
    fun writeBytes(dest: ByteArray, pointer: Int, source : ByteArray) : Int {
        var pointer = pointer
        source.forEach {  dest[pointer++] = it }
        return pointer
    }


}