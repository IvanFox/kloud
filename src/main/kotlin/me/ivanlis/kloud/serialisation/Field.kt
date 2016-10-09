package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 07/10/2016.
 * Student Course: Software Development
 */
// val nameLength: Short, val name: ByteArray, val dataType: Byte, val data: ByteArray, val field: Byte
class Field() {

    val containerType = ContainerType.FIELD
    lateinit var name: ByteArray
    lateinit var data: ByteArray
    var nameLength : Short = 0
    var dataType: Byte = 0

    val writer = SerialisationWriterImpl()

    fun initName(name: String) = {
        assert(name.length < Short.MAX_VALUE)
        this.nameLength = name.length.toShort()
        this.name = name.toByteArray()
    }

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