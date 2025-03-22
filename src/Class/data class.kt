package Class

data class ex_dt_class(val ex_dtint:Int,val ex_dtstr:String)

fun main()
{
    // toString
    val inst = ex_dt_class(6,"six")
    println(inst.toString())

    //equals
    val is_equal = ex_dt_class(1,"a")
    val is_equal_2 = ex_dt_class(1,"a")
    val is_equal_3 = is_equal

    println(is_equal == is_equal_2)
    println(is_equal === is_equal_3)

    //copy
    val copy_inst = inst.copy(99)
    println(copy_inst)

    //hashcode x componentN
    println(inst.component1().hashCode())
    println(inst.component2().hashCode())
    println(copy_inst.component1().hashCode())
}
