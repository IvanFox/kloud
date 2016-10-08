package me.ivanlis.kloud.serialisation

/**
 * Created by ivanlis on 08/10/2016.
 * Student Course: Software Development
 */
object ContainerType {

    @JvmField val UKNOWN    = 0.toByte()
    @JvmField val FIELD     = 1.toByte()
    @JvmField val ARRAY     = 2.toByte()
    @JvmField val OBJECT    = 3.toByte()



}