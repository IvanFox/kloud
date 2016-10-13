package me.ivanlis.kloud.serialisation.constants

/**
 * Created by ivanlis on 08/10/2016.
 * Student Course: Software Development
 */
object Type {

    const val UNKNOWN   = 0.toByte()
    const val BYTE      = 1.toByte()
    const val CHAR      = 2.toByte()
    const val SHORT     = 3.toByte()
    const val INT       = 4.toByte()
    const val LONG      = 5.toByte()
    const val FLOAT     = 6.toByte()
    const val DOUBLE    = 7.toByte()
    const val BOOL      = 8.toByte()

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