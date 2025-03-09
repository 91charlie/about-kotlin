
// 중첩 클래스
class O1 // 중첩 클래스는 키워드 없이 클래스 내에 클래스를 선언한다.
{
    val op1:Int = 1

    class I1
    {
        var ip1:Int = 3
    }
}

// 내부 클래스
class O2
{
    val op2:Int = 2
    inner class I2
    {
        val ip2:Int = 4
        fun im()
        {
            println("outer 프로퍼티 출력 : ${this@O2.op2}")
        }
    }
}

// 봉인된 클래스
sealed class S01 // sealed class 는 상속을 "같은 파일 내에서만"으로 제한한다.
{
    class n1:S01()
    class n2:S01()
    class n3:S01()
}
fun s_with_when(a:S01):Int // when 에서 sealed class 사용시 else 가 필요없어짐
{
    return when(a)
    {
        is S01.n1 -> 1
        is S01.n2 -> 2
        is S01.n3 -> 3
    }
}


fun main()
{
    // 중첩 클래스
    val ins = O1() // outer class
    val ins1 = O1.I1() // 중첩 클래스 내 프로퍼티 호출 형태--> val instance = outer name.class name
    println(ins.op1) // outer class
    println(ins1.ip1) // in -> out 으로 참조하지 않기 때문에 inner class 호출 시에도 인스턴스 하나로 호출한다.

    // 내부 클래스
    // outer class 를 참조하기 때문에 인스턴스를 outer 와 inner 두 개를 만든다.
    val inst = O2() // 외부 클래스의 인스턴스 생성
    val inst2 = inst.I2() // 내부 클래스의 인스턴스는 외부 클래스의 인스턴스를 통해 생성
    println(inst.op2)
    println(inst.I2().ip2) // 두가지 방법으로 호출가능
    println(inst2.im())

    // 봉인된 클래스
    val S_inst = S01.n1()
    val S_inst2 = S01.n2()
    val S_inst3 = S01.n3()
    println(s_with_when(S_inst))
    println(s_with_when(S_inst2))
    println(s_with_when(S_inst3))

}

