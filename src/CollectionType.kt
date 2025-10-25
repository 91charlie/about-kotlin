fun main(){
    // 리스트
    val a: List<String> = listOf("a","b","c") // 전용 함수 안에 값을 입력하면된다.
    for(i in a) {
        print(i)
    }

    println()

    //MutableList 는 추가 및 삭제가 가능해진다.
    val b: MutableList<Int> = mutableListOf(1,2,3,4,5,6) // 값을 입력하기 위한 전용 함수.
    b.add(7) // 7 추가
    b.add(0,0) // <-- 원하는 인덱스에 값을 추가할 수도 있다.
    print(b) // [0, 1, 2, 3, 4, 5, 6, 7]
    b.remove(7) // 해당 값을 삭제
    b.removeAt(b.size-1) //해당 인덱스의 값 삭제
    print("\n$b")
    b.shuffle()
    print("\n$b")
    b.sort()
    print("\n$b")

    // 셋
    // 리스트와 달리 순서가 정렬 되지 않고 중복을 허용하지 않는다. 따라서 인덱스 접근 불가
    val set: MutableSet<String> = mutableSetOf("abc","도레미")

    set.forEach { println(it)}

    set.add("flower")
    println(set)

    set.remove("abc")
    println(set)

    println(set.contains("도레미"))

//     맵
//     key 와 value 가 한 쌍으로 이루어져있다.
//     key 를 통해 value를 참조한다.
//     기존의 key에 다른 value를 삽입 할 경우 기존의 값은 새로운 값으로 대체된다.

    val map: MutableMap<String, Int> = mutableMapOf("one" to 1,"two" to 2, "three" to 3)
    map.forEach { println("${it.key} = ${it.value}")}

    map["four"] = 4
    map.put("five",5)
    println(map)

    map.remove("one")
    println(map)

    println(map["two"])

    // 컬렉션 함수
    a.forEach { it } // <-- 이는 반복문을 사용하지 않고 it으로 컬렉션의 모든 개체를 참조할 수 있는 함수이다.
    b.filter {it < 100} // <-- 조건에 부합 하는 값을 반환한다.
    b.map{it * 2} // <-- 조건에 맞게 변환 된 값을 포함한 컬렉션을 반환한다.
    b.any{it == 0} // 하나라도 조건에 맞으면 true
    b.all{it == 0} // 모두 조건에 맞으면 true
    b.none{it == 0} // 모두 조건에 안맞으면 true
    b.firstOrNull() // 컬렉션의 첫번째 원소 반환
    b.firstOrNull(){it > 3} // 조건에 부합하는 첫번째 원소 반환. find로 대체 가능하다
    b.lastOrNull() // 컬렉션의 마지막 원소 반환. findLast로 대체 가능하다.
    b.lastOrNull(){it > 3} // 조건에 부합하는 마지막 원소 반환
    b.count() // 컬렉션의 모든 원소의 개수 반환
    b. count() {it > 3} // 조건에 부합하는 원소의 개수 반환

    val personList = listOf(
        Personn("first",1992),
        Personn("second",1996),
        Personn("third",1999),
        Personn("first",2003),
    )
    //associateBy key값을 추출하여 객체를 value로 하는 map으로 변환한다.
    val birthmap = personList.associateBy{it.birthYear}
    val namemap = personList.associateBy{it.name}
    println("$birthmap \n $namemap")

    //groupBy key로 설정한 기준으로 그룹을 만들어 map타입으로 반환한다.
    val namegroup = personList.groupBy { it.name }
    val birthgroup = personList.groupBy { it.birthYear }
    println("\n $birthgroup \n $namegroup")
    println()
    // partition 객체의 기준을 걸어 두 가지 컬렉션으로 나누어 준다.
    val (over98, under98) = personList.partition { it.birthYear > 1998 }
    println(over98)
    println(under98)

    val numbers:List<Int> = listOf(-3, 7, 2, -10, 1)

    // flatMap 조건의 연산이 적용된 리스트를 반환한다.
    val flatmapNumbers = numbers.flatMap { listOf(it * 10)}
    val flatmapNumbers2 = numbers.flatMap { listOf(it * 10, it + 10)}
    println(flatmapNumbers)
    println(flatmapNumbers2)

    // getOrElse 인덱스의 원소가 없을 경우 임의의 값을 반환한다.
    val getorelse1 = numbers.getOrElse(3){100}
    val getorelse2 = numbers.getOrElse(32){100}
    println(getorelse1)
    println(getorelse2)

    // collection A zip collection 두 리스트의 원소를 1:1 로 pair 클래스의 객체로 만들어 리스트로 반환한다.
    // 두 컬렉션의 짝이 맞지않는 경우 사이즈가 더 작은 컬렉션을 따른다.
    val lettersList: List<String> = listOf("a","b","c","d","e")
    val ziplist = lettersList zip numbers
    println(ziplist)



}

data class Personn(val name: String, val birthYear: Int)


