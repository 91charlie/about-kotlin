// 주생성자
// constructor 키워드가 생략되어 있지만 접근제한자를 수정할 경우 필수로 명시해야한다.
class ex_class public constructor(val a:Int) // 클래스 생성시 파라미터와 프로퍼티를 동시에 생성가능하다.
{
    fun exfun():Int = this.a * 2
}

class ex_class2 public constructor(b: Int) // 파라미터만 선언
{
    val b:Int // 프로퍼티 선언

    init {
        this.b = b // <-- 주생성자의 매개변수 값을 프로퍼티에 할당
    }
    // 위의 첫번째 예시 클래스에서 생략된 내용이다.
    // init 함수의 역할은 파라미터에서 받아온 값을 (역할 1) 프로퍼티에 할당한다 (역할2)
}

// 부생성자
class ex_class3 public constructor(val c1:Int, val c2:Int, val c3:Int)
{
    init {
        println("주생성자 접근")
    }
    //constructor(파라미터):this(파라미터,기본값)
    constructor(c1: Int,c2: Int):this(c1,c2,1)// this()는 주생성자를 호출한다.
    {
        println("c1, c2 값 할당")
    }
    constructor(c1: Int) : this(c1,0)
    {
        println("c1 값 할당")
    }
}
fun main()
{
    val ex_inst = ex_class(2)
    println(ex_inst.exfun())

    val ex_inst2_3 = ex_class3(6)
    // 부생성자는 최종적으로 주생성자를 호출한다.
    // 할당 순서 c1 -> c1, c2 -> 주생성자
    //호출과 실행은 동시에 이루이지지 않기 때문에 print 출력 순서는 반대가 된다.
    //실행 순서 주생성자 -> c1, c2 -> c1
}
