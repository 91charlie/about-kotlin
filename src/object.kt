// object 키워드는 싱글톤 객체 또는 익명 객체를 정의 할 때 사용된다.
object ex_ob {
    val ob_concept: String = "this is Singleton object"
    override fun toString(): String {
        return "object_concept - ${ob_concept}"
    }
}

fun main()
{
    // 싱글톤 객체 = 오브젝트의 선언과 인스턴스의 생성이 동시에 이루어지면서 단 한번만 이루어진다.
    // 클래스의 인스턴스는 다수 생성가능하지만 싱글톤 객체의 인스턴스는 하나만 존재한다.
    println( ex_ob.ob_concept)

    val a:ex_ob = ex_ob // <- 티입과 프로퍼티로 사용가능
    println(a)

    // 익명 객체 - 클래스 생성 없이 이름 없는 객체 생성가능
    // 간단한 동작을 위해 사용하기 좋지만 내부 함수에 따라 복잡한 기능도 가능
    val b = object
    {
        val b1:Int = 0
        fun printb1()
        {
            println("익명 객체의 정수 - $b1")
        }
    }
    b.printb1()
}