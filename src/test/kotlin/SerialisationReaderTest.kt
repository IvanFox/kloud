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

    @Test fun testReadInt() {
        val data = ByteArray(4)
        val value = 6
        writer.writeBytes(data, 0 , value)
        Assert.assertEquals(reader.readInt(data, 0), value)
    }

    @Test fun testReadLong() {
        val data = ByteArray(8)
        val value = 6.toLong()
        writer.writeBytes(data, 0 , value)
        Assert.assertEquals(reader.readLong(data, 0), value)
    }




}