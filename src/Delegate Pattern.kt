import kotlin.reflect.KProperty
// 1. 구현되지 않은 인터페이스 생성
interface Logistics {
    fun deliver()
}
interface Payment {
    fun deal()
}
// 2. 인터페이스의 구현체 생성
class Deliv(): Logistics {
    override fun deliver() {
        println("배달")
    }
}
class Casher(): Payment {
    override fun deal() {
        println("거래")
    }
}
// 3. 델리게이터 생성
//델리게이터는 동작을 직접 구현하지 않고 위임한 구현체를 사용한다.
class Mart(l: Logistics, p: Payment): Logistics by l, Payment by p// 추후 확장성을 위해 파라미터로 위임

// 4. (선택) 메모리 최적화(lazy 와 유사), 캡슐화(인스턴스 생성시 구현체를 알 수 없음)를 원한다면 생성까지 위임이 가능하다.
//읽기와 쓰기 중에 공통된 동작을 원할 때 사용한다.
class InstDelegator(val name: String)
{
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Mart {
        return Mart(Deliv(),Casher())
    }

}


fun main() {
    val inst = Mart(Deliv(), Casher())
    inst.deal()
    inst.deliver()

    val inst2 : Mart by InstDelegator("E마트")
    // 여기서 쓰이는 by는 재정의 된 operator getValue 의 리턴 타입을 따라간다

    inst2.deal()
    inst2.deliver()
}
