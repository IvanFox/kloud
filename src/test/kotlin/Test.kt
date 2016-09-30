import me.ivanlis.kloud.serialisation.SerialisationWriter
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 28/09/2016.
 * Student Course: Software Development
 */

class WriteToByteArrayTest {


    @Test fun writeBytesWithByteValue() {
        val writer = SerialisationWriter()

        val data = ByteArray(16)

        val number = 10.toByte()

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)


        println("Pointer points to: $pointer")
        Assert.assertEquals(pointer, 5)
        println(data.forEach {
            print("0x${Integer.toHexString(it.toInt()).capitalize()}")
        })
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

        println("Pointer points to: $pointer")
        Assert.assertEquals(pointer, 10)

        println(data.forEach {
            print("0x${Integer.toHexString(it.toInt())} ")
        })
    }

    @Test fun writeBytesWithIntegerValue() {
        val writer = SerialisationWriter()

        val data = ByteArray(16)

        val number = 10000.toInt()

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("Pointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        println(data.forEach {
            print("0x${Integer.toHexString(it.toInt())} ")
        })
    }

    @Test fun writeBytesWithLongValue() {
        val writer = SerialisationWriter()

        val data = ByteArray(16)

        val number = Long.MIN_VALUE

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("Pointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        println(data.forEach {
            print("0x${java.lang.Integer.toHexString(it.toInt())} ")
        })
    }


    @Test fun writeBytesWithFloatValue() {
        val writer = SerialisationWriter()

        val data = ByteArray(16)

        val number = 1.1f

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("Pointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        println(data.forEach {
            print("0x${Integer.toHexString(it.toInt())} ")
        })
    }


    @Test fun writeBytesWithDoubleValue() {
        val writer = SerialisationWriter()

        val data = ByteArray(16)

        val number = 1.1

        var pointer = writer.writeBytes(data, 0, number)
        pointer = writer.writeBytes(data, pointer, number)

        println("Pointer points to: $pointer")
        Assert.assertEquals(pointer, 16)
        println(data.forEach {
            print("0x${Integer.toHexString(it.toInt())} ")
        })
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

        println("Pointer points to: $pointer")
        Assert.assertEquals(pointer, 4)
        println(data.forEach {
            print("0x${Integer.toHexString(it.toInt())} ")
        })
    }
}