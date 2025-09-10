class Box<T>(t: T)
{
    val value: T = t
}

fun <T> gen(a: T, b: T): Boolean where T: Number, T:Comparable<T> // .... 여러 제약을 걸 수 있다.
{
    return a > b
}
class TypeErase() {
    // 제네릭의 타입소거로 인해 타입 검사를 할 수 없다
    // 타입 소거는 컴파일 시점에 이루어져 런타임에서는 타입을 알 수 없다.
//    fun <T> er(a: List<T>): Boolean {
//        return a is List<Int>
//    }
//
//    fun <T> bt(a: T, b: Int): Boolean {
//        return b is T
//    }
    fun <T> errr(a: T) : Int // 제네릭 사용시 제약을 사용해야하는 이유
    {
        val an = a as Int
        return an * 2
    }
}
inline fun <reified T> bist(a: T, b: Int) : Boolean {
    return b is T
}

// 인라인 함수를 사용할 경우 메인 함수의 호출부가 함수의 구현부로 대체 되는데 reified 를 사용하면 값이 실체화 되는 과정에서 타입 확인이 가능하다
// 이유는 실체화하는 시점에 값이 어떤 타입의 상속을 받는지 확인 할 수 있기 때문이다.


fun main()
{
    val exint: Int = 3
    val l: List<Int> = listOf(1,2,3,4)
    println(l)
    val inst = TypeErase()
    println(inst.errr(exint))
    println(bist(4,3)) // reified<T> 는 T가 어떤 타입인지 검사한다.

}
// Variance 변성? 공변성과 반공변성? 타입 소거?
// 함수 실행은 스택으로 이루어진다.
// ex) 메인 함수 내에서 abc 함수 호출시
// 메인 함수위에 abc 함수가 스택처럼 쌓이게 되고 abc 함수가 종료되면 후입선출로 메인함수가 남게되어 메인함수가 실행된다.
// 그래서 동일한 함수를 메인 함수내에서 10번 실행해도 스택은 메인 함수와 abc 함수만 쌓이는 것을 반복할 뿐이다.
// 하지만 인라인 함수를 호출할 경우 메인함수 내의 인라인 함수 호출 부분이 인라인 함수의 로직으로 대체되기 때문에 메인 함수가 무거워지게 된다.
// 따라서 인라인 함수는 추적이 필요하지 않는 간단한 로직을 사용하고 싶을 때 사용하는 것이 좋다. 추적이 어렵기 때문이다.