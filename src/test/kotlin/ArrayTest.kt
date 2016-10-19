import me.ivanlis.kloud.serialisation.constants.ContainerType
import me.ivanlis.kloud.serialisation.constants.Type
import me.ivanlis.kloud.serialisation.containers.KArray
import me.ivanlis.kloud.serialisation.extensions.saveToFile
import me.ivanlis.kloud.serialisation.extensions.toHex
import me.ivanlis.kloud.serialisation.reader.SerialisationReaderImpl
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 13/10/2016.
 * Student Course: Software Development
 */
class ArrayTest {

    val reader = SerialisationReaderImpl()
    val varName = "myArr"

    @Test fun testIntArray() {
        val data: Array<Int> = Array(10000, { i -> i + 1 })
        val intArr = KArray.Int(varName, data)
        val byteData = ByteArray(intArr.getSize())
        intArr.writeBytes(byteData, 0)
        byteData.forEach { print(it.toHex) }
        Assert.assertEquals("The data size should be equal to: ", intArr.getSize(), byteData.size)
        Assert.assertEquals("Container Type: ", ContainerType.ARRAY, byteData[0])
        Assert.assertEquals("Name size should be: ", varName.length.toShort(), reader.readShort(byteData, 1))
        Assert.assertEquals("ASCII code for m is :", "6d", byteData[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", byteData[4].toHex)
        Assert.assertEquals("ASCII code for A is :", "41", byteData[5].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", byteData[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", byteData[7].toHex)
        Assert.assertEquals(Type.INT, byteData[8])
        Assert.assertEquals("Array size should be: ", data.size, reader.readInt(byteData, 9))
    }

    @Test fun testBoolArray() {
        val data: Array<Boolean> = Array(10, { i -> true })
        data.forEach(::print)
        println()
        val boolArr = KArray.Bool(varName, data)
        val byteData = ByteArray(boolArr.getSize())
        boolArr.writeBytes(byteData, 0)
        byteData.forEach { print(it.toHex) }
    }

    @Test fun testFloatArray() {
        val data: Array<Float> = Array(10, { i -> i + 1.0F })
        data.forEach(::print)
        val arr = KArray.Float(varName, data)
        val byteData = ByteArray(arr.getSize())
        arr.writeBytes(byteData, 0)
        byteData.forEach { print(it.toHex) }
    }

    @Test fun serialiseToFile() {
        val numbers : Array<Int> = Array(1000, { i -> i + 1 })
        val arr = KArray.Int(varName, numbers)
        val bytesData = ByteArray(arr.getSize())
        arr.writeBytes(bytesData, 0)
        bytesData.forEach { print(it.toHex) }
        saveToFile("/Users/ivanlis/Projects/kloud/src/main/resources/mydata", bytesData)

    }
}