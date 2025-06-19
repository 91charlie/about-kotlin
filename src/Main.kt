class ForLate()
{
    lateinit var late: String

    fun isinit(): Boolean
    {
        return ::late.isInitialized
    }

    inline fun <reified T> isas()
    {
       println(this.late as? T)
    }

}
fun main()
{
    var strr: String? = null



    strr?.let{ // if( strr != null) {}
        strr = "123"
        println(strr)
    }?: run { strr = "도레미"
    println(strr)
    }

    strr?.let{
        strr = "123"
        println(strr)
    }?: run { strr = "도레미"
    println(strr)
    }

    val a = ForLate()
    println(a.isinit())
    a.late = "abc"
    println(a.isinit())

    a.isas<Int>()
    a.isas<String>()


}
// ? ?. ?: as? !!. let{it} lateinit isInitialized