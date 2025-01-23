
fun angle(a:Int): Int = when(a)
{
    in 0 until 90 -> 1
    90 -> 2
    in 91 until 180 -> 3
    180 -> 4
    else -> a % 180

}


fun main()
{
    val a:Int = 188
    println(angle(a))
}