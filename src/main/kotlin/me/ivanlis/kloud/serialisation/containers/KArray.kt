package me.ivanlis.kloud.serialisation.containers

import me.ivanlis.kloud.serialisation.writer.SerialisationWriterImpl
import me.ivanlis.kloud.serialisation.constants.Type
import me.ivanlis.kloud.serialisation.constants.ContainerType

/**
 * Created by ivanlis on 13/10/2016.
 * Student Course: Software Development
 */
abstract class KArray(name: String, val arraySize: kotlin.Int) {

    private val containerType = ContainerType.ARRAY                 // 1 byte
    private val name: ByteArray = name.toByteArray()
    private val nameLength: kotlin.Short = name.length.toShort()    // 2 byte
    protected var dataType: kotlin.Byte = 4                           // 1 byte
    protected lateinit var data: ByteArray

    val writer = SerialisationWriterImpl()

    fun getBytes(dest: ByteArray, pointer: kotlin.Int): kotlin.Int {
        var currentPointer = pointer
        currentPointer = writer.writeBytes(dest, currentPointer, containerType)
        currentPointer = writer.writeBytes(dest, currentPointer, nameLength)
        currentPointer = writer.writeBytes(dest, currentPointer, name)
        currentPointer = writer.writeBytes(dest, currentPointer, dataType)
        currentPointer = writer.writeBytes(dest, currentPointer, arraySize)
        currentPointer = writer.writeBytes(dest, currentPointer, data)
        return currentPointer
    }

    fun getSize(): kotlin.Int = Type.getSize(Type.BYTE) + Type.getSize(Type.INT) +
            Type.getSize(Type.SHORT) + Type.getSize(Type.BYTE) + name.size + data.size

    class Bool(name: String, data: kotlin.Array<Boolean>) : KArray(name, data.size) {
        init {
            this.dataType = Type.BOOL
            this.data = ByteArray(Type.getSize(Type.BOOL) * this.arraySize)
            writer.writeBytes(this.data, 0, data)
        }
    }

    class Char(name: String, data: kotlin.Array<kotlin.Char>) : KArray(name, data.size) {
        init {
            this.dataType = Type.CHAR
            this.data = ByteArray(Type.getSize(Type.CHAR) * this.arraySize)
            writer.writeBytes(this.data, 0, data)
        }
    }

    class Byte(name: String, data: kotlin.Array<kotlin.Byte>) : KArray(name, data.size) {
        init {
            this.dataType = Type.BYTE
            this.data = ByteArray(Type.getSize(Type.BYTE) * this.arraySize)
            writer.writeBytes(this.data, 0, data)
        }
    }

    class Short(name: String, data: kotlin.Array<kotlin.Byte>) : KArray(name, data.size) {
        init {
            this.dataType = Type.SHORT
            this.data = ByteArray(Type.getSize(Type.SHORT) * this.arraySize)
            writer.writeBytes(this.data, 0, data)
        }
    }

    class Int(name: String, data: kotlin.Array<kotlin.Int>) : KArray(name, data.size) {
        init {
            this.dataType = Type.INT
            this.data = ByteArray(Type.getSize(Type.INT) * this.arraySize)
            writer.writeBytes(this.data, 0, data)
        }
    }

    class Float(name: String, data: kotlin.Array<kotlin.Float>) : KArray(name, data.size) {
        init {
            this.dataType = Type.FLOAT
            this.data = ByteArray(Type.getSize(Type.FLOAT) * this.arraySize)
            writer.writeBytes(this.data, 0, data)
        }
    }

    class Double(name: String, data: kotlin.Array<kotlin.Double>) : KArray(name, data.size) {
        init {
            this.dataType = Type.DOUBLE
            this.data = ByteArray(Type.getSize(Type.DOUBLE) * this.arraySize)
            writer.writeBytes(this.data, 0, data)
        }
    }
}