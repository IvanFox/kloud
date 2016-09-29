import me.ivanlis.kloud.serialisation.SerialisationWriter

/**
 * Created by ivanlis on 28/09/2016.
 * Student Course: Software Development
 */

fun main(args: Array<String>) {
//    writeBytesWithByteValue()
//    writeBytesWithShortValue()
//    writeBytesWithIntegerValue()
//    writeBytesWithLongValue()
//    writeBytesWithFloatValue()
//    writeBytesWithDoubleValue()
    writeBytesWithBooleanValue()
}

fun writeBytesWithByteValue() {
    val writer = SerialisationWriter()

    val data = ByteArray(16)

    val number = 10.toByte()

    var pointer = writer.writeBytes(data, 0, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)


//  println(pointer)
    println(data.forEach {
        print("0x${Integer.toHexString(it.toInt()).capitalize()}")
    })
}

fun writeBytesWithShortValue() {
    val writer = SerialisationWriter()

    val data = ByteArray(16)

    val number = 10000.toShort()

    var pointer = writer.writeBytes(data, 0, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)

    println(data.forEach {
        print("0x${Integer.toHexString(it.toInt())} ")
    })
}

fun writeBytesWithIntegerValue(){
    val writer = SerialisationWriter()

    val data = ByteArray(16)

    val number = 10000.toInt()

    var pointer = writer.writeBytes(data, 0, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)
//    pointer = writer.writeBytes(data, pointer, number)

    println(data.forEach {
        print("0x${Integer.toHexString(it.toInt())} ")
    })
}

fun writeBytesWithLongValue(){
    val writer = SerialisationWriter()

    val data = ByteArray(16)

    val number = Long.MIN_VALUE

    var pointer = writer.writeBytes(data, 0, number)
    pointer = writer.writeBytes(data, pointer, number)


    println(data.forEach {
        print("0x${java.lang.Integer.toHexString(it.toInt())} ")
    })
}


fun writeBytesWithFloatValue(){
    val writer = SerialisationWriter()

    val data = ByteArray(16)

    val number = 1.1f

    var pointer = writer.writeBytes(data, 0, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)
    pointer = writer.writeBytes(data, pointer, number)

    println("Pointer points to: $pointer")
    println(data.forEach {
        print("0x${Integer.toHexString(it.toInt())} ")
    })
}


fun writeBytesWithDoubleValue(){
    val writer = SerialisationWriter()

    val data = ByteArray(16)

    val number = 1.1

    var pointer = writer.writeBytes(data, 0, number)
    pointer = writer.writeBytes(data, pointer, number)

    println("Pointer points to: $pointer")
    println(data.forEach {
        print("0x${Integer.toHexString(it.toInt())} ")
    })
}

fun writeBytesWithBooleanValue(){
    val writer = SerialisationWriter()

    val data = ByteArray(16)

    val value1 = false
    val value2 = true


    var pointer = writer.writeBytes(data, 0, value2)
    pointer = writer.writeBytes(data, pointer, value2)
    pointer = writer.writeBytes(data, pointer, value1)
    pointer = writer.writeBytes(data, pointer, value2)

    println("Pointer points to: $pointer")
    println(data.forEach {
        print("0x${Integer.toHexString(it.toInt())} ")
    })
}