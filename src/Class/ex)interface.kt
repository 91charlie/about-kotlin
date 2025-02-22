package Class

interface plus
{
    fun p(a:Int , b:Int):Int
}
interface minus
{
    fun m(a:Int , b:Int):Int
}
interface multiply
{
    fun multi(a:Int , b:Int):Int
}
interface divide
{
    fun d(a:Int , b:Int):Int
}

class calculator():plus, minus, multiply, divide
{
    override fun p(a:Int, b:Int): Int {
        return a + b
    }

    override fun m(a:Int , b:Int): Int {
        return a - b
    }

    override fun multi(a:Int , b:Int): Int {
        return a * b
    }

    override fun d(a:Int , b:Int): Int {
        try {
            return a / b
        }
        catch(e:ArithmeticException)
        {
            println("0으로 나눌 경우 1로 나눕니다.")
            return a / 1
        }
    }
}
fun divide.remainder(a:Int, b: Int):Int
{
    println("나눗셈 후 나머지를 출력하는 확장 함수")
    try {
        return a % b
    }
    catch(e:ArithmeticException)
    {
        println("0으로 나눌 수 없습니다.")
        return 0
    }
}
fun main()
{
    val c = calculator()

    println( c.p(1,2))
    println( c.m(4,2))
    println( c.multi(2,2))
    println( c.d(6,2))
    println(c.remainder(5,3))
    println( c.d(6,0))
    println(c.remainder(5,0))
}