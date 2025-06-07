
fun main()
{
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
//나는 (버스)를 타고 간다
//람다 내장 함수 1. List.filter 2. .map 3. .all 4. .any 5. .count <- 복습 어떻게 구성되어 있는지 학습 람다의 재사용성 체험 it 최대한 활용
// 체이닝
