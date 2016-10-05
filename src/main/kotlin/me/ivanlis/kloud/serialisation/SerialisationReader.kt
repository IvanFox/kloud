package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 05/10/2016.
 * Student Course: Software Development
 */
interface SerialisationReader {

    fun readByte(src: ByteArray, pointer: Int): Byte

    fun readBoolean(src: ByteArray, pointer: Int) : Boolean

    fun readChar(src: ByteArray, pointer: Int) : Char

    fun readShort(src: ByteArray, pointer: Int): Short

    fun readInt(src: ByteArray, pointer: Int): Int

    fun readLong(src: ByteArray, pointer: Int) : Long

    fun readFloat(src: ByteArray, pointer: Int) : Float

    fun readDouble(src: ByteArray, pointer: Int) : Double
}