 class abc
{
    var a:Int = 0 // field
        get() // 커스텀 접근자 getter
        {
            return field * 2
        }
        set(value) // 커스텀 접근자 setter
        {
            field = value + 2
        }
    fun fun_1(b:Int) // 메소드
    {
        println(a * b)
    }
}

fun main()
{

    val avc = abc()
    avc.a = 2 // getter 에 2 입력 *2 연산 후 4가 된다
    val b = 3

    println(avc.a)
    print("${b} x ${avc.a} = ")
    avc.fun_1(b)

}
