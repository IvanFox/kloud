package me.ivanlis.kloud.serialisation.containers

import me.ivanlis.kloud.serialisation.constants.ContainerType
import me.ivanlis.kloud.serialisation.constants.Type
import me.ivanlis.kloud.serialisation.writer.SerialisationWriterImpl
import java.util.*

/**
 * Created by ivanlis on 18/10/2016.
 * Student Course: Software Development
 */
class KObject<T>(name: String, clazz: Class<T>) {

    private val writer = SerialisationWriterImpl()
    private val containerType = ContainerType.OBJECT                 // 1 byte
    private val name: ByteArray = name.toByteArray()
    private val nameLength: kotlin.Short = name.length.toShort()    // 2 byte

    private val classNameLength :Short = clazz.name.length.toShort()
    private val className = clazz.name.toByteArray()

    private var fieldSize: Short = 0
    private val fields: MutableList<KField> = ArrayList()

    private var arraySize: Short = 0
    private val arrays: MutableList<KArray> = ArrayList()
    private var size = Type.getSize(Type.BYTE) + Type.getSize(Type.SHORT) +
                                 Type.getSize(Type.SHORT) + className.size +
                                 Type.getSize(Type.SHORT) + Type.getSize(Type.SHORT) + name.length

    fun addField(field: KField.Int) {
        fields.add(field)
        fieldSize++
        size += field.getSize()
    }

    fun addArray(array: KArray.Int) {
        arrays.add(array)
        arraySize++
        size += array.getSize()
    }

    fun getSize(): Int {
//        val fieldsSize = fields.foldRight(0, { el, acc -> el.getSize() + acc })
//        val arrSize = arrays.foldRight(0, { el, acc -> el.getSize() + acc })
        return size
    }

    fun writeBytes(dest: ByteArray, pointer: Int) {
        var currentPointer = pointer
        currentPointer = writer.writeBytes(dest, currentPointer, containerType)
        currentPointer = writer.writeBytes(dest, currentPointer, nameLength)
        currentPointer = writer.writeBytes(dest, currentPointer, name)
        currentPointer = writer.writeBytes(dest, currentPointer, classNameLength)
        currentPointer = writer.writeBytes(dest, currentPointer, className)
        currentPointer = writer.writeBytes(dest, currentPointer, fieldSize)
        fields.forEach { currentPointer = it.writeBytes(dest, currentPointer) }
        currentPointer = writer.writeBytes(dest, currentPointer, arraySize)
        arrays.forEach { currentPointer = it.writeBytes(dest, currentPointer) }

    }

}