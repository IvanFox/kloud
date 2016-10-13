package me.ivanlis.kloud.serialisation.containers

import me.ivanlis.kloud.serialisation.SerialisationWriterImpl
import me.ivanlis.kloud.serialisation.Type
import me.ivanlis.kloud.serialisation.containers.ContainerType

/**
 * Created by ivanlis on 07/10/2016.
 * Student Course: Software Development
 */
abstract class Field(name: String) {

    val containerType = ContainerType.FIELD                 // 1 byte
    val name: ByteArray = name.toByteArray()
    val nameLength: kotlin.Short = name.length.toShort()    // 2 byte
    var dataType: kotlin.Byte = 4                           // 1 byte
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

    fun getSize() : Int = 1 + 1 + 2 + name.size + data.size


    class Bool(name: String, value: Boolean) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.BOOL))
            writer.writeBytes(data, 0, value)
        }
    }

    class Byte(name: String, value: kotlin.Byte) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.BYTE))
            writer.writeBytes(data, 0, value)
        }
    }

    class Char(name: String, value: kotlin.Char) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.CHAR))
            writer.writeBytes(data, 0, value)
        }
    }

    class Short(name: String, value: kotlin.Short) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.SHORT))
            writer.writeBytes(data, 0, value)
        }
    }

    class Integer(name: String, value: Int) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.INT))
            writer.writeBytes(data, 0, value)
        }
    }

    class Long(name: String, value: kotlin.Long) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.LONG))
            writer.writeBytes(data, 0, value)
        }
    }

    class Float(name: String, value: kotlin.Float) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.FLOAT))
            writer.writeBytes(data, 0, value)
        }
    }

    class Double(name: String, value: kotlin.Double) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.DOUBLE))
            writer.writeBytes(data, 0, value)
        }
    }
}