import me.ivanlis.kloud.serialisation.constants.ContainerType
import me.ivanlis.kloud.serialisation.containers.KArray
import me.ivanlis.kloud.serialisation.containers.KField
import me.ivanlis.kloud.serialisation.containers.KObject
import me.ivanlis.kloud.serialisation.extensions.toHex
import me.ivanlis.kloud.serialisation.reader.SerialisationReader
import me.ivanlis.kloud.serialisation.reader.SerialisationReaderImpl
import me.ivanlis.kloud.serialisation.reflection.Employee
import org.junit.Assert
import org.junit.Test

/**
 * Created by ivanlis on 18/10/2016.
 * Student Course: Software Development
 */

class KObjectTest {

    val objName = "MyObject"
    val fieldName = "MyField"
    val arrName = "MyArray"
    val arrNumber = Array(100, { i -> i + 1 })
    val reader: SerialisationReader = SerialisationReaderImpl()

    @Test fun testKObjectInit() {
        val field = KField.Int(fieldName, 99999)
        val array = KArray.Int(arrName, arrNumber)
        val myObj = KObject(objName, Employee::class.java)

        myObj.addField(field)
        myObj.addArray(array)

        val stream = ByteArray(myObj.getSize())
        myObj.writeBytes(stream, 0)

        Assert.assertEquals("Container type should be equal to: ", ContainerType.OBJECT, stream[0] )
        Assert.assertEquals("Name length should be equal to: ", objName.length.toShort(), reader.readShort(stream, 1))
        Assert.assertEquals("Name: Ascii value for M is: ", "4d", stream[3].toHex)
        Assert.assertEquals("Name: Ascii value for y is: ", "79", stream[4].toHex)
        Assert.assertEquals("Name: Ascii value for O is: ", "4f", stream[5].toHex)
        Assert.assertEquals("Name: Ascii value for b is: ", "62", stream[6].toHex)
        Assert.assertEquals("Name: Ascii value for j is: ", "6a", stream[7].toHex)
        Assert.assertEquals("Name: Ascii value for e is: ", "65", stream[8].toHex)
        Assert.assertEquals("Name: Ascii value for c is: ", "63", stream[9].toHex)
        Assert.assertEquals("Name: Ascii value for t is: ", "74", stream[10].toHex)
        Assert.assertEquals("Classname length should be equal to: ", Employee::class.qualifiedName,
                                                                                   reader.readShort(stream, 11))
        stream.forEach { print(it.toHex) }
    }

    @Test fun serialiseEmployeeObject() {
        val employee = Employee(30, 300000)
        val fields = employee.javaClass.declaredFields
        val kfields: MutableList<KArray>


        fields.forEach {
            it.isAccessible = true
            print("${it.genericType.typeName} ${it.name} ${it.get(employee)} \n")

        }


    }
}