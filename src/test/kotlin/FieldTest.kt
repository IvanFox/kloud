import me.ivanlis.kloud.serialisation.ContainerType
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
        data.forEach { it.toInt().printHex() }
        Assert.assertEquals("Container type should be: ", ContainerType.FIELD, data[0])
        Assert.assertEquals("Name size should be: ", "ages".length, data[2].toHex.toInt())
        Assert.assertEquals("ASCII code for a is :", 61, data[3].toHex.toInt())
        Assert.assertEquals("ASCII code for g is :",67, data[4].toHex.toInt())
        Assert.assertEquals("ASCII code for e is :",65, data[5].toHex.toInt())
        Assert.assertEquals("ASCII code for s is :",73, data[6].toHex.toInt())
    }

    class IntField(name: String, value: Int) : Field(name) {
        init {
            data = ByteArray(Type.getSize(Type.INT))
            writer.writeBytes(data, 0, value)
        }
    }
}