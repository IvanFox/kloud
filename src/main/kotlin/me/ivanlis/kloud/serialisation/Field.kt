package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 07/10/2016.
 * Student Course: Software Development
 */
abstract class Field(name: String) {

    val containerType = ContainerType.FIELD
    val name: ByteArray = name.toByteArray()
    val nameLength: kotlin.Short = name.length.toShort()
    var dataType: kotlin.Byte = 4
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

    class Integer(name: String, value: kotlin.Int) : Field(name) {
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