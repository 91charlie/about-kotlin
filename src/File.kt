import java.io.File
import java.io.FileWriter

class stack()
{
    val intarray: MutableList<Int> = mutableListOf()
    var top: Int = -1

    fun push(){
        while(true) {
            println("스택에 추가할 정수를 입력하시오")
            try {
                val v = readLine()
                intarray.add(v!!.toInt())
                println("${this.intarray[++top]} 입력 됨.")
                println("현재 스택 상태 $intarray")
                break
            }
            catch(e: IllegalArgumentException)
            {
                println("정수를 입력하시오.")
            }
        }
    }
    fun pop()
    {
        if(top < 0)
        {
            println("삭제할 원소가 없습니다.")
        }
        else {
            intarray.remove(intarray[top])
            println("마지막 요소 삭제 됨")
            println("현재 스택 상태 $intarray")
            top--
        }
    }
    fun save()
    {
        println("세이브할 파일명 입력")
        val txtname = readLine()
        val txtpath = File("C:\\Users\\Business\\Desktop\\$txtname.txt")
        val writer = FileWriter(txtpath)
        writer.write(intarray.toString())
        writer.close()
    }
}
fun fileReader(): String{
    val file = File("C:\\Users\\Business\\Desktop\\ExText.txt")
    val text = file.readText()
    return text
}
fun main(){
    val s = stack()

//    while(true) {
//        println("1. push // 2. pop // 3. save // else. break")
//        val choose = readLine()!!.toInt()
//        if(choose == 1) {
//            s.push()
//        }
//        else if(choose == 2) {
//            s.pop()
//        }
//        else if(choose == 3) {
//            s.save()
//        }
//        else
//        {
//            break
//        }
//    }

}

// 토크나이저 - ㅁ ㅜ ㄴ ㅈ ㅏ 문자
//렉서 - 문자 - 의미
// parser - 나는 카페를 갔다 문법을 검사해준다

// 런타임에 객체 내부를 볼 수 있다 참조를 통해서

//fun. main. (.).{.} 토크나이저
// fun <- 키워드 부여 main <- 의미 부여

//제이슨 인코딩 디코딩

