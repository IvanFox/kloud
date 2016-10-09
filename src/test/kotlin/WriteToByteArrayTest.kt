import me.ivanlis.kloud.serialisation.SerialisationWriterImpl
import me.ivanlis.kloud.serialisation.extensions.toHex
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 28/09/2016.
 * Student Course: Software Development
 */

class WriteToByteArrayTest {

    fun printByteArray(data: ByteArray) = data.forEach { print("${it.toHex.toUpperCase()} ") }

    @Test fun writeBytesWithByteValue() {
        val writer = SerialisationWriterImpl()

        val data = ByteArray(16)

        val number = 10.toByte()
        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)


        println("\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 5)
        printByteArray(data)
    }

    @Test fun writeBytesWithShortValue() {
        val writer = SerialisationWriterImpl()

        val data = ByteArray(16)

        val number = 10000.toShort()

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 10)

        printByteArray(data)
    }

    @Test fun writeBytesWithIntegerValue() {
        val writer = SerialisationWriterImpl()

        val data = ByteArray(16)

        val number = 10000.toInt()

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        printByteArray(data)
    }

    @Test fun writeBytesWithLongValue() {
        val writer = SerialisationWriterImpl()

        val data = ByteArray(16)

        val number = Long.MIN_VALUE

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        printByteArray(data)
    }


    @Test fun writeBytesWithFloatValue() {
        val writer = SerialisationWriterImpl()

        val data = ByteArray(16)

        val number = 1.1f

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        printByteArray(data)
    }


    @Test fun writeBytesWithDoubleValue() {
        val writer = SerialisationWriterImpl()

        val data = ByteArray(16)

        val number = 1.1

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        printByteArray(data)
    }

    @Test fun writeBytesWithBooleanValue() {
        val writer = SerialisationWriterImpl()

        val data = ByteArray(16)

        val value1 = false
        val value2 = true


        var pointer = writer.writeBytes(data, 0, value2)
        pointer = writer.writeBytes(data, pointer, value2)
        pointer = writer.writeBytes(data, pointer, value1)
        pointer = writer.writeBytes(data, pointer, value2)

        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 4)
        printByteArray(data)
    }

    @Test fun writeBytesWithByteArray() {
        val writer = SerialisationWriterImpl()
        val data = ByteArray(16)
        val source = ByteArray(8)

        var pointer = writer.writeBytes(data, 0, source)
        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 8)
        printByteArray(data)

    }


    @Test fun writeBytesWithString() {
        val writer = SerialisationWriterImpl()
        val data = ByteArray(16)
        val source = "Ivan"

        var pointer = writer.writeBytes(data, 0, source)
        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 6)
        printByteArray(data)

    }
}