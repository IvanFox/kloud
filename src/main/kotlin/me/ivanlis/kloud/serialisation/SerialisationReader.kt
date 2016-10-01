package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 01/10/2016.
 * Student Course: Software Development
 */
class SerialisationReader {

    fun readInt(src: ByteArray, pointer: Int): Int {
        return src[pointer].toInt().shl(24).
                or(src[pointer + 1].toInt().shl(16)).
                or(src[pointer + 2].toInt().shl(8)).
                or(src[pointer + 3].toInt())
    }

}