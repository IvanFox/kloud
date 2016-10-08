package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 07/10/2016.
 * Student Course: Software Development
 */
// val nameLength: Short, val name: ByteArray, val dataType: Byte, val data: ByteArray, val field: Byte
class Field() {

    val containerType = ContainerType.FIELD
    var nameLength: Short? = null
    var name: ByteArray? = null
    var data: ByteArray? = null
    var dataType: Byte? = null

    val writer = SerialisationWriterImpl()

    fun initName(name: String) = {
        assert(name.length < Short.MAX_VALUE)
        this.nameLength = name.length.toShort()
        this.name = name.toByteArray()
    }

    fun getBytes(dest: ByteArray, pointer: Int): Int {
        var currentPointer = pointer
        currentPointer = writer.writeBytes(dest, currentPointer, containerType!!)
        currentPointer = writer.writeBytes(dest, currentPointer, nameLength!!)
        currentPointer = writer.writeBytes(dest, currentPointer, name!!)
        currentPointer = writer.writeBytes(dest, currentPointer, dataType!!)
        currentPointer = writer.writeBytes(dest, currentPointer, data!!)
        return currentPointer
    }
}