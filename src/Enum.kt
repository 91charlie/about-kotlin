public enum class Day() // enum (열거형) 클래스 선언
{
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
    // enum class 는  특정한 값만 가질 수 있는 타입을 정의 할 때 사용된다.(상수 - 변하지 않고 일정한 수)
    // 필요에 따라 프로퍼티와 메소드를 선언 할 수 있다.
    // 또한 각 상수는 기본적으로 클래스의 인스턴스이다.

    fun weekend_or_not(day:Day):String
    {
        return when(day)

        {
            Day.Saturday,Day.Sunday -> "Happy weekend"
            else -> "have to work for you"
        }
        // when 사용시 enum 클래스에서 선언한 상수를 사용하지 않을 경우 사용하지 않은 상수를 알수있다
        // enum 에서 선언한 상수를 반드시 사용하거나 else 를 사용해야한다.
        // if문 과 마찬가지로 조건의 참과 거짓을 구분하기 때문에 Boolean 타입과 활용성이 좋다.
        // if문 보다 간편하게 작성 가능하다.
    }



}

fun main()
{
    val a = Day.Sunday
    println(a.weekend_or_not(a))
}
