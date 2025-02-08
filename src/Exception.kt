fun err() // 에러 발생시키는 함수선언
{
    throw IllegalArgumentException("에러 발생") // throw 를 사용하면 에러를 발생 시킬 수 있다.
}

fun main()
{

    try // 에러 가능성이 있는 코드를 작성한다.
    {
        err()
    }
    catch(e:IllegalArgumentException) // 에러가 발생할 경우 실행되는 코드를 작성한다.
    {
        println(e.message)
    }
    finally // 에러 유무와 상관 없이 실행되는 코드를 작성한다.
    {
        println("finally 는 선택 사항")
    }

}
