/**
 * Created by ivanlis on 28/09/2016.
 * Student Course: Software Development
 */


val Int.toHex: String get() = Integer.toHexString(this)
val Int.toBin: String get() = Integer.toBinaryString(this)
val Byte.toHex: String get() = Integer.toHexString(this.toInt())


fun printHex(num: Int) = print("${num.toHex} \n")
fun printBin(num: Int) = print("${num.toBin} \n")


fun main(args: Array<String>) {
//    val value = 0x1234

//    val rightHalf = value.and(0xff)
//    val leftHalf = value.and(0xff00).shr(8)


    val color = 0x123456 // rgb

    val red = color.and(0xff0000).shr(16)
    val green = color.and(0xff00).shr(8)
    val blue = color.and(0xff)

    val result = red.shl(16).or(green.shl(8)).or(blue)
    printHex(red)
    printHex(green)
    printHex(blue)

    printHex(result)


    val a = 0x12
    val b = 0x7
    printBin(a)
    printBin(b)
    printBin(a.xor(b))
    printBin(a.inv()) // inverse
}