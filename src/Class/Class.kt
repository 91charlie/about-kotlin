package Class

class exxClass(val propertyy:String, val properttyy: Int) {
    override fun toString(): String {
        return "toString 예) 문자열 -> $propertyy 정수 -> $properttyy"
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true // 같은 메모리인지 판별
        if(this is exxClass) return true
        return propertyy == other && properttyy == other
    }

    override fun hashCode(): Int {
        return propertyy.hashCode() % 10
    }



}

fun main()
{
    val a:exxClass = exxClass("abc",123)
    println(a)
    val a2:exxClass = exxClass("abc",123)
    println(a.equals(a2))
    println(a == a2)
    println(a === a2)

    println(a.hashCode())

}