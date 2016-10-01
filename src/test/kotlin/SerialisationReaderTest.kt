import me.ivanlis.kloud.serialisation.SerialisationReader
import me.ivanlis.kloud.serialisation.SerialisationWriter
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 01/10/2016.
 * Student Course: Software Development
 */
class SerialisationReaderTest {

    @Test fun testReadInt() {
        val writer = SerialisationWriter()
        val reader = SerialisationReader()
        val data = ByteArray(4)
        val value = 6
        writer.writeBytes(data, 0 , value)
        Assert.assertEquals(reader.readInt(data, 0), value)

    }
}