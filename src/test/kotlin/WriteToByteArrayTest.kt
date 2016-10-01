import me.ivanlis.kloud.serialisation.SerialisationWriter
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 28/09/2016.
 * Student Course: Software Development
 */

class WriteToByteArrayTest {

    fun printByteArray(data: ByteArray) = data.forEach { print("${it.toHex.toUpperCase()} ")}

    @Test fun writeBytesWithByteValue() {
        val writer = SerialisationWriter()

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
        val writer = SerialisationWriter()

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
        val writer = SerialisationWriter()

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
        val writer = SerialisationWriter()

        val data = ByteArray(16)

        val number = Long.MIN_VALUE

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        printByteArray(data)
    }


    @Test fun writeBytesWithFloatValue() {
        val writer = SerialisationWriter()

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
        val writer = SerialisationWriter()

        val data = ByteArray(16)

        val number = 1.1

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("\n\n\nPointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        printByteArray(data)
    }

    @Test fun writeBytesWithBooleanValue() {
        val writer = SerialisationWriter()

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
}