
fun main()
{
    var a:Int = 0

    while(a < 10) // while(boolean 으로 나타낼 수 있는 조건)
    {
        println(a)
        a++
    }


    do // do + while 문은 while 문의 조건과 상관 없이 do 내의 내용은 최초 동작시 반드시 작동한다.
    {
        println("해당 while문의 조건은 always false 지만 해당 메세지가 출력 될 것이다.")
    }
    while(a<0)
{
        println("해당 메세지는 출력되지 않을 것이다.")
}

    for(i in 1 until 10) // for 문의 in은 범위 내 i 값이 포함하는지 확인하는 역할을 한다.
    {
        print(i) // until 을 사용하면 10을 포함하지 않는다.
    }

    print("\n")

    for (j in 1 .. 10)
    {

        print(j) // .. 을 사용하면 10을 포함하여 출력한다.
    }

    print("\n")

    for (k in 0 .. 10 step 2) // step 은 간격을 설정할 수 있다.
    {
        print(k) // 0 부터 10까지 2의 배수로 출력된다.
    }

    print("\n")

    var arr1 = arrayOf(1,5,7,4,8)
    for (l in arr1) // for 문의 in은 iterable 한 변수의 컬렉션을 하나씩 읽을 때도 사용된다.
    {
        print(l) // arr1의 원소가 하나씩 출력된다.
    }

    print("\n")



    for(m in 'j' downTo 'a' step 2 ) // 코틀린은 문자열의 대소 비교도 가능하며 downTo를 통해 내림차순으로 순회가능하다.
    {
       print(m)
    }

}


