import me.ivanlis.kloud.serialisation.SerialisationReader
import me.ivanlis.kloud.serialisation.SerialisationWriter
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 01/10/2016.
 * Student Course: Software Development
 */
class SerialisationReaderTest {
    val writer = SerialisationWriter()
    val reader = SerialisationReader()

    @Test fun testReadByte() {
        val data = ByteArray(1)
        val value = 6.toByte()
        writer.writeBytes(data, 0 , value)
        Assert.assertEquals(reader.readByte(data, 0), value)
    }

    @Test fun testReadShort() {
        val data = ByteArray(2)
        val value = 6.toShort()
        writer.writeBytes(data, 0 , value)
        Assert.assertEquals(reader.readShort(data, 0), value)
    }

    @Test fun testReadChar() {
        val data = ByteArray(8)
        val value = 'I'
        writer.writeBytes(data, 0 , value)
        Assert.assertEquals(reader.readChar(data, 0), value)
    }

    @Test fun testReadInt() {
        val data = ByteArray(4)
//        data[0] = 0xf.toByte(); data[1] = 0xf; data[2] = 0xf; data[3] = 0xf
        val value = 25264
        writer.writeBytes(data, 0 , value)
        val result = reader.readInt(data, 0)
        Assert.assertEquals(value, result)
    }

    @Test fun testReadLong() {
        val data = ByteArray(8)
        val value = 65000L
        writer.writeBytes(data, 0 , value)
        Assert.assertEquals(reader.readLong(data, 0), value)
    }

    @Test fun testReadFloat() {
        val data = ByteArray(4)
//        data[0] = 0x0; data[1] = 0x0; data[2] = 0x1; data[3] = 0xf
        val value = 6.4F
        writer.writeBytes(data, 0 , value)
        val result = reader.readFloat(data, 0)
        Assert.assertEquals(value, result)
    }

    @Test fun testReadDouble() {
        val data = ByteArray(8)
        val value = 6.4
        writer.writeBytes(data, 0 , value)
        println(reader.readDouble(data, 0 ))
        Assert.assertEquals(value, reader.readDouble(data, 0 ), 0.1)
    }


}