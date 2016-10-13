package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 28/09/2016.
 * Student Course: Software Development
 */
class SerialisationWriterImpl : SerialisationWriter {

    val HEADER: ByteArray = "KS".toByteArray()
    val VERSION: Short = 0x0100

    // Byte capacity: 1 Byte
    override fun writeBytes(dest: ByteArray, pointer: Int, value: Byte): Int {
        // TODO assert for errors
        dest[pointer] = value
        return pointer.inc()
    }

    // Short capacity: 2 Bytes
    override fun writeBytes(dest: ByteArray, pointer: Int, value: Short): Int {
        // TODO assert for errors
        var currPointer = pointer
        dest[currPointer++] = value.toInt().shr(8).and(0xFF).toByte()
        dest[currPointer++] = value.toInt().and(0xFF).toByte()
        return currPointer
    }

    // Char capacity: unsigned short / 2 bytes
    override fun writeBytes(dest: ByteArray, pointer: Int, value: Char): Int {
        // TODO assert for errors
        var currPointer = pointer
        dest[currPointer++] = value.toInt().shr(8).and(0xFF).toByte()
        dest[currPointer++] = value.toInt().and(0xFF).toByte()
        return currPointer
    }

    // Int capacity: 4 Bytes
    override fun writeBytes(dest: ByteArray, pointer: Int, value: Int): Int {
        // TODO assert for errors
        var currPointer = pointer
        dest[currPointer++] = value.shr(24).and(0xFF).toByte()
        dest[currPointer++] = value.shr(16).and(0xFF).toByte()
        dest[currPointer++] = value.shr(8).and(0xFF).toByte()
        dest[currPointer++] = value.and(0xFF).toByte()
        return currPointer
    }

    // Long capacity: 8 Bytes
    override fun writeBytes(dest: ByteArray, pointer: Int, value: Long): Int {
        var currPointer = pointer
        // TODO assert for errors
        dest[currPointer++] = value.shr(56).and(0xFF).toByte()
        dest[currPointer++] = value.shr(48).and(0xFF).toByte()
        dest[currPointer++] = value.shr(40).and(0xFF).toByte()
        dest[currPointer++] = value.shr(32).and(0xFF).toByte()
        dest[currPointer++] = value.shr(24).and(0xFF).toByte()
        dest[currPointer++] = value.shr(16).and(0xFF).toByte()
        dest[currPointer++] = value.shr(8).and(0xFF).toByte()
        dest[currPointer++] = value.and(0xFF).toByte()
        return currPointer
    }

    // Float capacity: 4 bytes
    override fun writeBytes(dest: ByteArray, pointer: Int, value: Float): Int {
        // TODO assert for errors
        val floatToIntBits = java.lang.Float.floatToIntBits(value)
        return writeBytes(dest, pointer, floatToIntBits)
    }

    // Double capacity: 8 bytes
    override fun writeBytes(dest: ByteArray, pointer: Int, value: Double): Int {
        // TODO assert for errors
        val doubleToLongBits = java.lang.Double.doubleToLongBits(value)
        return writeBytes(dest, pointer, doubleToLongBits)
    }

    // Boolean capacity: 1 bytes
    override fun writeBytes(dest: ByteArray, pointer: Int, value: Boolean): Int {
        // TODO assert for errors
        dest[pointer] = if (value == true) 1.toByte() else 0.toByte()
        return pointer.inc()
    }

    // first 2 bytes represent the length of the string
    override fun writeBytes(dest: ByteArray, pointer: Int, value: String): Int {
        var currPointer = writeBytes(dest, pointer, value.length.toShort())
        return writeBytes(dest, currPointer, value.toByteArray())
    }


    // Mem copy
    fun writeBytes(dest: ByteArray, pointer: Int, source: ByteArray): Int {
        var currPointer = pointer
        source.forEach { dest[currPointer++] = it }
        return currPointer
    }

    fun writeBytes(dest: ByteArray, pointer: Int, source: Array<Boolean>): Int {
        var currPointer = pointer
        source.forEach {currPointer = writeBytes(dest, currPointer, it) }
        return currPointer
    }

    fun writeBytes(dest: ByteArray, pointer: Int, source: Array<Char>): Int {
        var currPointer = pointer
        source.forEach { currPointer = writeBytes(dest, currPointer, it) }
        return currPointer
    }


    fun <T> writeBytes(dest: ByteArray, pointer: Int, source: Array<T>): Int
            where T : Number {
        var currPointer = pointer
        source.forEach { currPointer = writeBytes(dest, currPointer, it) }
        return currPointer
    }

    private fun writeBytes(dest: ByteArray, pointer: Int, it: Number): Int {
        when (it) {
            is Byte -> return writeBytes(dest, pointer, it)
            is Short -> return writeBytes(dest, pointer, it)
            is Int -> return writeBytes(dest, pointer, it)
            is Long -> return writeBytes(dest, pointer, it)
            is Float -> return writeBytes(dest, pointer, it)
            is Double -> return writeBytes(dest, pointer, it)
        }
        throw Exception("Given number type: '${it.javaClass}' is not supported")
    }

}