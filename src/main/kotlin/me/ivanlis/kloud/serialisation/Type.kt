package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 08/10/2016.
 * Student Course: Software Development
 */
class Type {

    @JvmField val UNKNOWN   = 0.toByte()
    @JvmField val BYTE      = 1.toByte()
    @JvmField val CHAR      = 2.toByte()
    @JvmField val SHORT     = 3.toByte()
    @JvmField val INT       = 4.toByte()
    @JvmField val LONG      = 5.toByte()
    @JvmField val FLOAT     = 6.toByte()
    @JvmField val DOUBLE    = 7.toByte()
    @JvmField val BOOL      = 8.toByte()

    fun getSize(type : Byte) : Int {
        when(type) {
            UNKNOWN -> assert(false)
            BYTE -> return 1
            CHAR -> return 2
            SHORT -> return 2
            INT -> return 4
            LONG -> return 8
            FLOAT -> return 4
            DOUBLE -> return 8
            BOOL -> return 1
        }
        throw Exception("Given type is not exist")
    }


}