package funtion

// 1.----------------------------------------------------------------------------
fun calculator(a: Int, b: Int, what: (Int, Int) -> Int): Unit
{
    println(what(a,b))
}
// 2.----------------------------------------------------------------------------
data class ExDataClass(val name: String, val a: Int, val b: Int)
fun <T: Comparable<T>> excomp(l: List<ExDataClass>, comp:(ExDataClass) -> T)
{
    var temp = l[0]
    for(i in 1 until l.size)
    {
        if(comp(l[i]) > comp(temp))
        {
            temp = l[i]
        }
    }
    println(temp)
}

fun main()
{
    // 1. 고차 함수와 람다 예제
    calculator(1,2) {a, b -> a + b} // 고차 함수 what 은 calculator 함수 호출시 {} 내에서 람다 함수로 호출한다.

    // 2. 모든 타입의 리스트 원소를 사용하기 위해 제네릭을 선언한 예제
    val inst1 = ExDataClass("ace",5,2)
    val inst2 = ExDataClass("bravo",3,4)
    val inst3 = ExDataClass("charlie",2,1)

    val ilist:List<ExDataClass> = listOf(inst1,inst2,inst3)
    excomp(ilist){it.name} // 인스턴스의 어떤 원소를 기준으로 연산할 지 정할 수 있다.

    // 3. 내장된 람다 함수의 체이닝과 시퀀스의 예제
    val exlist: List<Int> = listOf(1,2,3,4,5,6,7,8,9,10)
    var a = exlist.asSequence()
        .filter { it % 2 == 0 }
        .map {
            when(it)
            {
                1 -> "a"
                2 -> "b"
                3 -> "c"
                4 -> "d"
                5 -> "e"
                6 -> "f"
                7 -> "g"
                8 -> "h"
                9 -> "i"
                10 -> "j"
                else -> "not yet"
            }
        }
        .take(3)
    println(a.toList())
}
//람다 내장 함수
// 1. .filter
// 2. .map
// 3. .all
// 4. .any
// 5. .count 등이 있다.

//this 는 클래스내 프로퍼티를 명시함으로써 파라미터와의 혼용을 방지한다.
//with(자주 사용되는 변수) 이를 사용하면 thi s로 인식된다. 리턴 타입이 없다.(nothing)
//apply 는 확장함수 형태로 사용된다. with 와 동일하지만 리턴타입이 있다.
