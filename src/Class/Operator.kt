data class OperatorEx(var x: Int, var y: Int): Comparable<OperatorEx>{
    // operator 키워드를 사용하여 기존의 연산자를 커스터마이즈 가능하다.
    // 이는 객체내의 변수의 연산을 할 경우 별도의 함수를 만들어 호출하지 않고 연산자 기호만 사용하면 연산이 가능하도록 해준다.
    operator fun get(i: Int): Int
    { // 인덱스로 접근하여 값을 get 한다.
        return when(i)
        {
            0 -> this.x
            1 -> this.y
            else -> throw Exception()
        }
    }
    operator fun set(i: Int, v:Int)
    {// 인덱스로 접근하여 값을 set 한다.
        when(i)
        {
            0 -> this.x = v
            1 -> this.y = v
            else -> throw Exception()
        }

    }
    operator fun plus(o: OperatorEx): OperatorEx
    {
        // 이항 연산 키워드 plus, minus, times, div, rems
        //용도에 맞게 함수이름을 설정한다.
        //연산된 결과를 리턴하기 때문에 독립된 값을 참조하게된다.
        //따라서 변화한 값을 기존의 인스턴스에 반영시키고자 한다면
        //아래의 복합연산자를 사용하거나 인스턴스를 var 로 생성해야한다.
        return OperatorEx(this.x + o.x,this.y + o.y)
    }
    operator fun timesAssign(o: OperatorEx): Unit
    {// 복합 대입 연산자 - 연산 된 값을 리턴하지 않고 할당한다.
        //이항 연산 키워드에 Assign 이 추가된 키워들르 사용하여 재정의 가능하다.
        //리턴 값이 없기 때문에 인스턴스의 독립적인 값을 참조하지 않는다.
        //클래스 내의 프로퍼티가 var 일 경우 val 인스턴스일 경우에도 값의 변경이 가능하다.
        //val 인스턴스가 var 변수를 참조하기 때문에 var 의 변화는 한 번만 참조하는 val 의 성질에 벗어나지 않기 때문이다.
        //산술 연산자를 정의할 경우 정의 할 필요없다.
        this.x *= o.x;
        this.y *= o.y;
    }
    operator fun inc(): OperatorEx
    {// 단항연산자 inc 와 dec 사용
        return OperatorEx(this.x + 1,this.y + 1)
    }
    operator fun contains(o: OperatorEx): Boolean
    {// 포함 여부를 확인하는 연산자이다.
        return if (this.x == o.x || this.y == o.y) true else false
    }
    operator fun rangeTo(o: Int): IntRange
    { // 범위 연산자 rangeUntil 도 있지만 호출할때 ..< 기호로 하면 Until 과 동일하다
        return this.. o
    }

    override fun equals(other: Any?): Boolean { // 동등성 연산자는 operator 키워드를 사용하지 않는다.
        return super.equals(other)
    }

    override fun compareTo(other: OperatorEx): Int { // 순서 연산자 또한 operator 키워드를 사용하지 않는다.
        // 해당 메소드를 오버라이드 하기전에 클래스는 Comparable<OperatorEx> 인터페이스를 채택을 선행한다.
        // 아래 함수를 리턴하도록 한다. 우선적으로 비교하고자 하는 프로퍼티를 앞에 작성한다
        // 아래의 예시의 경우 x를 우선적으로 대소비교를 한 뒤 리턴한다 만약 x의 값이 같을 경우에 y값을 비교하게 된다.
        return compareValuesBy(this,other,OperatorEx::x,OperatorEx::y)
    }
}
class compoEx(val comp1: Int, val comp2: Int)
{
    // componentN 의 경우 데이터 클래스에서는 기본으로 제공하지만 일반 클래스의 멤버의 경우 명시적으로 분해해주어야한다.
    operator fun component1() = this.comp1
    operator fun component2() = this.comp2
}
fun printall(l:List<compoEx>): Unit
{
    for((comp1,comp2)in l)
    {
        println("$comp1 , $comp2")
    }
}

fun main()
{
   var inst = OperatorEx(1,2)
    val inst2 = OperatorEx(1,2)
//    inst[0] = 3
//    inst[1] = 4
    println(inst[0])
    println(inst[1])
    println(inst > inst2)
    println(inst != inst2)
    println(inst in inst2)
    println(inst.x .. 5)
    val cinst = compoEx(1,2)

}