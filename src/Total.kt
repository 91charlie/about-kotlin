import sun.swing.MenuItemLayoutHelper.max
import java.lang.System.`in`
import java.util.Scanner
import javax.swing.text.StyledEditorKit
import kotlin.math.max
import kotlin.random.Random


fun main(){
    // 타입 추론이 가능하다
    var i: Long = 10L // variable 의 약자. 재대입할 변수로 사용
    val j: Int = 30 // value 의 약자. 재대입하지 않는 상수로 사용

    // 타입이 다른 값을 대입할 때 반드시 타입 캐스팅을 해야한다.
    i = j.toLong()

    // 수와 관련된 내장 함수
    println(max(i.toInt(),j)) // import 해야한다.

    val rand:Int = Random.nextInt(1,101) // 난수 생성. () 괄호 내에 범위를 정할 수 있다.
    println(rand)

    // scanner (scanf)
    val reader = Scanner(`in`) // 자바 스캐너
    reader.nextInt() // Int 형
    reader.next() // 문자열
    val Kreader = readLine()!!.toInt() // 코틀린에서 사용
    val Kreader2: Int
    Kreader2 = readLine()!!.toInt() // 해당 형태로 사용가능하다.

    //문자열
    var str: String = "string"
    // 인덱스로 한 글자씩 접근가능
    println(str.uppercase()[0]) // or lowercase
    println("문자열 ("+str+") 더하기 가능")
    println("문자열 ($str) 더하기 가능")
    //긴 수식이 들어간다면 ${} 형태로 사용할 수 있다.

    // 조건문
    if(Kreader % 3 == 0){
        println("3의 배수")
    }else if(Kreader % 3 == 1){
        println("나머지 ... 1")
    }else{
        println("나머지 ... 2")
    }
    // if문은 when으로 치환가능하다. Alt + Enter 키로 가능하다.
    // 조건문의 결과는 변수나 상수의 값으로 대입이 가능하다.
    val result = when {
        Kreader % 3 == 0 -> "3의 배수"
        Kreader % 3 == 1 -> "나머지 ... 1"
        else -> "나머지 ... 2"
    }
    println(result)

    // 삼항연산
    val isZero: Boolean = if (Kreader2 % 3 == 0) true else false
    println("$isZero,${Kreader2 % 3}")

    // 반목문
    val items = listOf(1,2,3,4,5)
    for(item in items)println(item); // 원소를 직접 호출한다.
    for(index in items.indices)println(items[index]); //indices는 리스트의 인덱스 번호를 호출한다.
    items.forEach { item ->
        println(item) } // 원소를 직접 호출한다.

    // 다양하게 표현 가능하다.
    for(i in 0 .. 3) println(i); // 0 에서 3 포함
    for(i in 0 until 3)println(i); // 3을 포함하지 않음 0 에서 2
    for(i in 3 downTo 0)println(i); // 0 포함 3 에서 0 까지 내려간다.
    for(i in 0 .. 5 step 2)println(i); // step은 2의 배수로 설정했다. 0 2 4 출력. 3 5 는 제외된다.

    do {
        println("최초 반복")
        break // 반복문 탈출
        continue // 반복문을 탈출하지 않지만 동작을 건너뛰고 싶을 때 사용
    } while(true) // while내의 조건의 true or false 여부와 상관없이 do 내의 내용은 반드시 동작한다.

    // 컬렉션 <List>
    val list: List<Int> = listOf(1,2,3,4,5) // 읽기만 가능
    val mlist: MutableList<Int> = mutableListOf(1,2,3,4,5) // 변경 가능. add와 remove 가능

    // 컬렉션 <Array>
    val array: Array<Int> = arrayOf(1,2,3,4,5) // get과 set 또는 인덱스로 접근하여 수정가능하다.

    // 예외 처리
    try{
        1 / 0
    }catch(e: Exception){
        println(e.message)
    }

    //nullsafety
    var strr: String? = null //nullable 변수 선언 타입 뒤에 ? 사용
    strr = "abc"
    strr = null
    // 조건문으로 null 체크를 하면 nullable 하지않은 변수에 nullable 변수를 할당할 수 있다.
    var strr2: String = ""

    if(strr != null){
        strr2 = strr // if문 내에서는 nullable하지 않은 타입으로 취급하게 된다. (스마트캐스팅)
    }
    strr?.let{
        strr2 = strr // ?.는 null이 아닐 경우 실행한다는 뜻으로 위 조건문과 같은 쓰임새로 사용가능하다.
    }
    // strr2 = strr!! <-- 이렇게 !!를 통해서 개발자가 임의로 null이 아님을 보증할 수 있지만 이는 모두 개발자 책임이다.(비권장)

    val personInst = Person("john",38)
    personInst.name = "nick"
    println(personInst.hobby)

    // 타입 체크, 타입 캐스팅
     val dog = Dog()
    if(dog is Animal){
        println("타입 체크")
    }
    dog as Feeding // 타입 캐스팅

    // 제네릭
    val box = Boxx(32)
    val box2 = Boxx("str")

    // 고차함수
    funtionn {
        println("고차함수")
    }
}

// 함수
fun sum(a: Int, b: Int): Int = a + b // 탑레벨 함수의 기본 형태
// fun sum(a: Int, b: Int, c: Int): Int = a + b + c 위 함수를 오버로드하여 매개변수를 늘렸다.

// 하지만 마지막 매개변수에 기본값을 설정해 놓으면 하나의 함수로 위 두 함수의 역할을 할 수 있다.
fun sum(a: Int, b: Int, c: Int = 0): Int = a + b + c

// 클래스
class Person(var name: String, val age: Int)
{
    var hobby: String = "math"
        private set
        get() = "${this.name} 의 취미는 $field"
    init{
        println("init block 접근")
    }
}
// 데이타클래스 사용시 tostirng hash equals 등을 재정의 할 필요가 없다.
data class PersonData(var name: String, val age: Int)

// 상속, 인터페이스
interface Feeding{
    fun eat()
}
abstract class Animal(){
    open fun move(){
        println("이동")
    }
}

class Dog: Animal(),Feeding{
    override fun move(){
        println("Dog move")
    }

    override fun eat() {
        println("Dog eat")
    }

}
class Cat: Animal(),Feeding
{
    override fun move() {
        println("Cat move")
    }

    override fun eat() {
        println("Cat eat")
    }
}

// 제네릭
class Boxx<T>(value: T)

// 고차함수
fun funtionn(callback : () -> Unit){
    callback()
}
// 코루틴?? suspend??