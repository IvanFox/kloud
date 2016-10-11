import me.ivanlis.kloud.serialisation.ContainerType
import me.ivanlis.kloud.serialisation.Field
import me.ivanlis.kloud.serialisation.SerialisationReaderImpl
import me.ivanlis.kloud.serialisation.extensions.toHex
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 08/10/2016.
 * Student Course: Software Development
 */
class FieldTest {

    val reader = SerialisationReaderImpl()
    val varName = "myVar"

    @Test fun testIntegerField() {
        val value = 65005
        val field = Field.Integer(varName, value)
        val data = ByteArray(13)
        field.getBytes(data, 0)
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", varName.length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(value, reader.readInt(data, 9))
    }

    @Test fun testBooleanField() {
        val value = true
        val field = Field.Bool(varName, value)
        val data = ByteArray(10)
        field.getBytes(data, 0)
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", varName.length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals("True is equal to :", 1.toByte(), data[9])
    }


    @Test fun testByteField() {
        val value = 127.toByte()
        val field = Field.Byte(varName, value)
        val data = ByteArray(10)
        field.getBytes(data, 0)
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", varName.length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(value, data[9])
    }

    @Test fun testCharField() {
        val value = 'r'
        val field = Field.Char(varName, value)
        val data = ByteArray(11)
        field.getBytes(data, 0)
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", varName.length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(value, reader.readChar(data, 9))
    }

    @Test fun testShortField() {
        val value = 255.toShort()
        val field = Field.Short(varName, value)
        val data = ByteArray(11)
        field.getBytes(data, 0)
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "myVar".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(value, reader.readShort(data, 9))
    }

    @Test fun testLongField() {
        val value = 25500000L
        val field = Field.Long(varName, value)
        val data = ByteArray(17)
        field.getBytes(data, 0)
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "myVar".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(value, reader.readLong(data, 9))
    }

    @Test fun testDoubleField() {
        val value = 25500.4
        val field = Field.Double(varName, 25500.4)
        val data = ByteArray(17)
        field.getBytes(data, 0)
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", varName.length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(value, reader.readDouble(data, 9), 0.1)
    }

    @Test fun testFloatField() {
        val value = 25500.4F
        val field = Field.Float(varName, 25500.4F)
        val data = ByteArray(13)
        field.getBytes(data, 0)
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", varName.length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for m is :", "6d", data[3].toHex)
        Assert.assertEquals("ASCII code for y is :", "79", data[4].toHex)
        Assert.assertEquals("ASCII code for V is :", "56", data[5].toHex)
        Assert.assertEquals("ASCII code for a is :", "61", data[6].toHex)
        Assert.assertEquals("ASCII code for r is :", "72", data[7].toHex)
        Assert.assertEquals(value, reader.readFloat(data, 9), 0.1F)
    }

}