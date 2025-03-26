// 코틀린의 특징
// 자바와의 호환성
// 기존의 자바코드보다 간결하게 작성이 가능하다.
// 컴파일 시점에 타입추론이 이루어지기 때문에 런타임시 에러 발생을 줄일 수 있다.
// 코틀린은 런타임시 타입추론이 가능 하지만 컴파일러의 일이 늘어난다
// 함수형 프로그램

// fun name(파라미터 input):Int return
// input 123 -> 연산 -> return 321
//name(123) -> 321

var isReversed: Boolean = true // 외부의 변수와 상호작용을 하기 때문에 순수함수가 아니다.
fun a(name: String): String {
    if(isReversed) {
       return name.reversed()
    } else {
        return name
    }
}// 함수형 프로그래밍시 외부와의 상호작용이 없도록 한다.(불변성의 보장과 사이드이펙트 방지)
// 순수함수 - 불변성이 보장되고 사이드이펙트가 없는 함수 외부와의 상호작용을 통제해야한다.



fun main() {
    println(a("1234"))
    isReversed = false
    println(a("1234"))
}

