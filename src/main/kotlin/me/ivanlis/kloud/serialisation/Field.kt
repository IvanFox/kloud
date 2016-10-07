package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 07/10/2016.
 * Student Course: Software Development
 */
// val nameLength: Short, val name: ByteArray, val dataType: Byte, val data: ByteArray, val field: Byte
class Field() {

    var nameLength : Short? = null
    var name : ByteArray? = null
    var dataType : Byte? = null
    var data : ByteArray? = null
    var indicator : Byte? = null

    fun initName(name : String) = {
        assert(name.length < Short.MAX_VALUE)
        this.nameLength = name.length.toShort()
        this.name = name.toByteArray()
    }
}