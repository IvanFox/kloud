import me.ivanlis.kloud.serialisation.SerialisationReaderImpl
import me.ivanlis.kloud.serialisation.SerialisationWriterImpl
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 01/10/2016.
 * Student Course: Software Development
 */
class SerialisationReaderTest {
    val writer = SerialisationWriterImpl()
    val reader = SerialisationReaderImpl()

    @Test fun testReadByte() {
        val data = ByteArray(1)
        val value = 6.toByte()
        writer.writeBytes(data, 0, value)
        val result = reader.readByte(data, 0)
        Assert.assertEquals(value, result)
    }

    @Test fun testReadShort() {
        val data = ByteArray(2)
        val value = 255.toShort()
        writer.writeBytes(data, 0, value)
        val result = reader.readShort(data, 0)
        Assert.assertEquals(value, result)
    }

    @Test fun testReadChar() {
        val data = ByteArray(8)
        val value = 'I'
        writer.writeBytes(data, 0, value)
        Assert.assertEquals(value, reader.readChar(data, 0))
    }

    @Test fun testReadInt() {
        val data = ByteArray(4)
//        data[0] = 0xf.toByte(); data[1] = 0xf; data[2] = 0xf; data[3] = 0xf
        val value = 25264
        writer.writeBytes(data, 0, value)
        val result = reader.readInt(data, 0)
        Assert.assertEquals(value, result)
    }

    @Test fun testReadLong() {
        val data = ByteArray(8)
        val value = 65003212123.toLong()
        writer.writeBytes(data, 0, value)
        val result = reader.readLong(data, 0)
        Assert.assertEquals(value, result)
    }

    @Test fun testReadFloat() {
        val data = ByteArray(4)
//        data[0] = 0x0; data[1] = 0x0; data[2] = 0x1; data[3] = 0xf
        val value = 6.41F
        writer.writeBytes(data, 0, value)
        val result = reader.readFloat(data, 0)
        println(result)
        Assert.assertEquals(value, result)
    }

    @Test fun testReadDouble() {
        val data = ByteArray(8)
        val value = 632313.414341
        writer.writeBytes(data, 0, value)
        println(reader.readDouble(data, 0))
        Assert.assertEquals(value, reader.readDouble(data, 0), 0.1)
    }

    @Test fun testReadBoolean() {
        val data = ByteArray(2)
        val value = false
        val value2 = true
        writer.writeBytes(data, 0, value)
        writer.writeBytes(data, 1, value2)
        Assert.assertEquals(value, reader.readBoolean(data, 0))
        Assert.assertEquals(value2, reader.readBoolean(data, 1))
    }

}