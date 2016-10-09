package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 07/10/2016.
 * Student Course: Software Development
 */
// val nameLength: Short, val name: ByteArray, val dataType: Byte, val data: ByteArray, val field: Byte
abstract class Field(name : String) {

    val containerType = ContainerType.FIELD
    val name: ByteArray = name.toByteArray()
    val nameLength : Short = name.length.toShort()
    var dataType: Byte = 4
    lateinit var data: ByteArray

    val writer = SerialisationWriterImpl()

    fun getBytes(dest: ByteArray, pointer: Int): Int {
        var currentPointer = pointer
        currentPointer = writer.writeBytes(dest, currentPointer, containerType)
        currentPointer = writer.writeBytes(dest, currentPointer, nameLength)
        currentPointer = writer.writeBytes(dest, currentPointer, name)
        currentPointer = writer.writeBytes(dest, currentPointer, dataType)
        currentPointer = writer.writeBytes(dest, currentPointer, data)
        return currentPointer
    }
}