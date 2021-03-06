package me.ivanlis.kloud.serialisation.containers

import me.ivanlis.kloud.serialisation.constants.ContainerType
import me.ivanlis.kloud.serialisation.constants.Type
import me.ivanlis.kloud.serialisation.writer.SerialisationWriterImpl

/**
 * Created by ivanlis on 07/10/2016.
 * Student Course: Software Development
 */
abstract class KField(name: String) {

    private val containerType = ContainerType.FIELD                 // 1 byte
    private val name: ByteArray = name.toByteArray()
    private val nameLength: kotlin.Short = name.length.toShort()    // 2 byte
    protected var dataType: kotlin.Byte = 0                          // 1 byte
    protected lateinit var data: ByteArray

    protected val writer = SerialisationWriterImpl()

    fun writeBytes(dest: ByteArray, pointer: kotlin.Int): kotlin.Int {
        var currentPointer = pointer
        currentPointer = writer.writeBytes(dest, currentPointer, containerType)
        currentPointer = writer.writeBytes(dest, currentPointer, nameLength)
        currentPointer = writer.writeBytes(dest, currentPointer, name)
        currentPointer = writer.writeBytes(dest, currentPointer, dataType)
        currentPointer = writer.writeBytes(dest, currentPointer, data)
        return currentPointer
    }

    fun getSize(): kotlin.Int =
            Type.getSize(Type.BYTE) + Type.getSize(Type.BYTE) +
            Type.getSize(Type.SHORT) + name.size + data.size


    class Bool(name: String, value: Boolean) : KField(name) {
        init {
            dataType = Type.BOOL
            data = ByteArray(Type.getSize(Type.BOOL))
            writer.writeBytes(data, 0, value)
        }
    }

    class Byte(name: String, value: kotlin.Byte) : KField(name) {
        init {
            dataType = Type.BYTE
            data = ByteArray(Type.getSize(Type.BYTE))
            writer.writeBytes(data, 0, value)
        }
    }

    class Char(name: String, value: kotlin.Char) : KField(name) {
        init {
            dataType = Type.CHAR
            data = ByteArray(Type.getSize(Type.CHAR))
            writer.writeBytes(data, 0, value)
        }
    }

    class Short(name: String, value: kotlin.Short) : KField(name) {
        init {
            dataType = Type.SHORT
            data = ByteArray(Type.getSize(Type.SHORT))
            writer.writeBytes(data, 0, value)
        }
    }

    class Int(name: String, value: kotlin.Int) : KField(name) {
        init {
            dataType = Type.INT
            data = ByteArray(Type.getSize(Type.INT))
            writer.writeBytes(data, 0, value)
        }
    }

    class Long(name: String, value: kotlin.Long) : KField(name) {
        init {
            dataType = Type.LONG
            data = ByteArray(Type.getSize(Type.LONG))
            writer.writeBytes(data, 0, value)
        }
    }

    class Float(name: String, value: kotlin.Float) : KField(name) {
        init {
            dataType = Type.FLOAT
            data = ByteArray(Type.getSize(Type.FLOAT))
            writer.writeBytes(data, 0, value)
        }
    }

    class Double(name: String, value: kotlin.Double) : KField(name) {
        init {
            dataType = Type.DOUBLE
            data = ByteArray(Type.getSize(Type.DOUBLE))
            writer.writeBytes(data, 0, value)
        }
    }
}