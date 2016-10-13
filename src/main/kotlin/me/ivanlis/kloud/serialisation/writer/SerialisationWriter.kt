package me.ivanlis.kloud.serialisation.writer

/**
 * Created by ivanlis on 05/10/2016.
 * Student Course: Software Development
 */
interface SerialisationWriter {

    fun writeBytes(dest: ByteArray, pointer: Int, value: Byte): Int

    fun writeBytes(dest: ByteArray, pointer: Int, value: Short): Int

    fun writeBytes(dest: ByteArray, pointer: Int, value: Char): Int

    fun writeBytes(dest: ByteArray, pointer: Int, value: Int): Int

    fun writeBytes(dest: ByteArray, pointer: Int, value: Long): Int

    fun writeBytes(dest: ByteArray, pointer: Int, value: Float): Int

    fun writeBytes(dest: ByteArray, pointer: Int, value: Double): Int

    fun writeBytes(dest: ByteArray, pointer: Int, value: Boolean): Int

    fun writeBytes(dest: ByteArray, pointer: Int, value: String) : Int
}