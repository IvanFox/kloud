package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 01/10/2016.
 * Student Course: Software Development
 */
class SerialisationReader {

    fun readByte(src: ByteArray, pointer: Int): Byte {
        return src[pointer].toByte()
    }

    fun readChar(src: ByteArray, pointer: Int) : Char {
        return src[pointer].toInt().shl(8).or(src[pointer + 1].toInt()).toChar()
    }

    fun readShort(src: ByteArray, pointer: Int): Short {
        return src[pointer].toInt().shl(8).or(src[pointer + 1].toInt()).toShort()
    }

    fun readInt(src: ByteArray, pointer: Int): Int {
        return (src[pointer].toInt().and(0xff)).shl(24).
                or((src[pointer + 1].toInt().and(0xff)).shl(16).
                or((src[pointer + 2].toInt().and(0xff)).shl(8)).
                or((src[pointer + 3].toInt().and(0xff))))
    }

    fun readLong(src: ByteArray, pointer: Int) : Long {
        return src[pointer].toInt().shl(56).
                or(src[pointer + 1].toInt().shl(48)).
                or(src[pointer + 2].toInt().shl(40)).
                or(src[pointer + 3].toInt().shl(32)).
                or(src[pointer + 4].toInt().shl(24)).
                or(src[pointer + 5].toInt().shl(16)).
                or(src[pointer + 6].toInt().shl(8)).
                or(src[pointer + 7].toInt()).toLong()
    }

    fun readFloat(src: ByteArray, pointer: Int) : Float {
        print(java.lang.Float.intBitsToFloat(1087163597))
        val floatInIntBits = readInt(src, pointer)
        println(floatInIntBits)
        val float =  java.lang.Float.intBitsToFloat(floatInIntBits)
        return float
    }

    fun readDouble(src: ByteArray, pointer: Int) : Double {
        return java.lang.Double.longBitsToDouble(readLong(src, pointer))
    }

    fun readBoolean(src: ByteArray, pointer: Int) : Boolean {
        return src[pointer] != 0.toByte()
    }

}