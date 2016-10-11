import me.ivanlis.kloud.serialisation.*
import me.ivanlis.kloud.serialisation.extensions.printHex
import me.ivanlis.kloud.serialisation.extensions.toHex
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 08/10/2016.
 * Student Course: Software Development
 */
class FieldTest {

    val reader = SerialisationReaderImpl()

    @Test fun testIntegerField() {
        val field = Field.Integer("ages", 65005)
        val data = ByteArray(20)
        field.getBytes(data, 0)
        data.forEach { it.toInt().printHex() }
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "ages".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for a is :", 61, data[3].toHex.toInt())
        Assert.assertEquals("ASCII code for g is :", 67, data[4].toHex.toInt())
        Assert.assertEquals("ASCII code for e is :", 65, data[5].toHex.toInt())
        Assert.assertEquals("ASCII code for s is :", 73, data[6].toHex.toInt())
    }

    @Test fun testBooleanField() {
        val field = Field.Bool("flag", true)
        val data = ByteArray(9)
        field.getBytes(data, 0)
        data.forEach { it.toInt().printHex() }
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "flag".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for f is :", "66", data[3].toHex)
        Assert.assertEquals("ASCII code for l is :", "6c", data[4].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[5].toHex)
        Assert.assertEquals("ASCII code for g is :", "67", data[6].toHex)
        Assert.assertEquals("True is equal to :", 1.toByte(), data[8])
    }


    @Test fun testByteField() {
        val field = Field.Byte("myVar", 127)
        val data = ByteArray(10)
        field.getBytes(data, 0)
        data.forEach { it.toInt().printHex() }
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "myVar".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(127.toByte(), data[9])
    }

    @Test fun testCharField() {
        val field = Field.Char("myVar", 'r')
        val data = ByteArray(11)
        field.getBytes(data, 0)
        data.forEach { it.toInt().printHex() }
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "myVar".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals("72", data[10].toHex)
    }

    @Test fun testShortField() {
        val field = Field.Short("myVar", 255)
        val data = ByteArray(11)
        field.getBytes(data, 0)
        data.forEach { it.toInt().printHex() }
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "myVar".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(255.toShort(), reader.readShort(data, 9))
    }

    @Test fun testLongField() {
        val field = Field.Long("myVar", 25500000L)
        val data = ByteArray(17)
        field.getBytes(data, 0)
        data.forEach { it.toInt().printHex() }
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "myVar".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(25500000L.toLong(), reader.readLong(data, 9))
    }

    @Test fun testDoubleField() {
        val field = Field.Double("myVar", 25500.4)
        val data = ByteArray(17)
        field.getBytes(data, 0)
        data.forEach { it.toInt().printHex() }
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "myVar".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(25500.4, reader.readDouble(data, 9), 0.1)
    }

    @Test fun testFloatField() {
        val field = Field.Float("myVar", 25500.4F)
        val data = ByteArray(13)
        field.getBytes(data, 0)
        data.forEach { it.toInt().printHex() }
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "myVar".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(25500.4F, reader.readFloat(data, 9), 0.1F)
    }

}