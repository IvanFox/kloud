package me.ivanlis.kloud.serialisation.extensions

import java.io.BufferedOutputStream
import java.io.FileOutputStream

/**
 * Created by ivanlis on 09/10/2016.
 * Student Course: Software Development
 */

val Int.toHex: String get() = Integer.toHexString(this)
val Int.toBin: String get() = Integer.toBinaryString(this)
val Byte.toHex: String get() = Integer.toHexString(this.toInt())
fun Int.printHex() = print("${this.toHex} \n")
fun Int.printBin() = print("${this.toBin} \n")

fun saveToFile(path : String, data : ByteArray) {
    val stream = BufferedOutputStream(FileOutputStream(path))
    stream.write(data)
    stream.close()
}