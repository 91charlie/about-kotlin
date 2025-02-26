interface itf01
{
    fun mthd01() // 추상 메소드 구현
    fun same_name()
    {
        println("1번 인터페이스의 same_name 메소드")
    }
}

interface itf02 // 기본 구현
{
    fun mthd02()
    {
        println("itf02 인터페이스의 메소드 mthd02 출력")
    }
    fun same_name()
    {
        println("2번 인터페이스의 same_name 메소드")
    }
}
interface itf03 // 추상 프로퍼티와 기본 구현된 프로퍼티 사용가능
{
    val text:String
    val num:Int
        get() = 1
    fun printex()
    {
        println("삽입 된 문자열 -> ${text}")
        println("기본 선언된 정수 -> ${num}")
    }
}
class clss01(override val text: String):itf01,itf02,itf03 // 2가지 이상의 인터페이스를 채택했다.
{
    // 다중상속
    // 기본 구현된 메소드를 사용할 경우 따로 작성하지 않고 호출 가능하다.
    override fun mthd01() {
        println("itf01 인터페이스의 메소드 mthd01 재정의 후 출력")
    }

    // 다른 인터페이스에 중복 된 이름의 메소드가 있다면 어떤 인터페이스의 메소드를 사용할 것인지 명시해야한다
    override fun same_name() {
        super<itf01>.same_name()
        super<itf02>.same_name()
    }

}
fun itf02.extfun()
{
    println("확장 된 itf02 인터페이스")
    (this as? itf02)?.mthd02()
    (this as? itf02)?.same_name()
    // this as? itf02 타입이 아닐 경우 null 반환 뒤 null.메소드로 재호출 시도시 오류 발생
    // ?.에서 아무 동작없이 null 의 예외 처리 가능
}

fun main()
{
    val a = clss01("abc 도레미") // <-- 추상 프로퍼티의 값을 인스턴스에서 삽입했다.
    a.mthd01() // <-- 재정의 후 호출

    // -- 재정의 없이 호출
    a.mthd02()
    a.printex()

    // 다른 인터페이스 내 중복된 이름 메소드 호출
    a.same_name()

    //확장 인터페이스 호출
    (a as itf02).extfun()

}