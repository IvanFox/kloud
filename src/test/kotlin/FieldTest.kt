import me.ivanlis.kloud.serialisation.Field
import me.ivanlis.kloud.serialisation.Type
import me.ivanlis.kloud.serialisation.extensions.*
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 08/10/2016.
 * Student Course: Software Development
 */
class FieldTest {

    @Test fun TestField() {
        val field = IntField("ages", 5)
        val data = ByteArray(20)
        field.getBytes(data, 0)
        data.forEach { it -> print(it.toHex) }
        Assert.assertEquals("Container type should be:git ", 1, data[0].toHex.toInt())
        Assert.assertEquals("Name size should be: ", 4, data[2].toHex.toInt())
        Assert.assertEquals(61, data[3].toHex.toInt())
        Assert.assertEquals(67, data[4].toHex.toInt())
        Assert.assertEquals(65, data[5].toHex.toInt())
        Assert.assertEquals(73, data[6].toHex.toInt())
    }

    class IntField(name: String, value: Int) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.INT))
            writer.writeBytes(data, 0, value)
        }
    }
}