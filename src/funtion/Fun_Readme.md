# 함수의 기본 구조
fun 이름(파라미터):변수 타입 {   
함수내용   
}
# 확장 함수의 기본 구조
fun 확장할 타입.이름(파라미터):변수타입 {    
확장 함수 내용   
}
# 확장 프로퍼티의 기본 구조
var 확장할 타입.이름: 변수 타입

get() = ...  <-- getter 구현    
set(value) {  <-- setter 구현   
// value 는 외부에서 할당된 값을 저장하는 매개변수
}

# @JvmOverload 
### 예제) fun j_ex(a:Int, b:Int = 3):Int = a + b
<pre>
public final class ExampleKt    
{ 
    public static final int j_ex(int a, int b)   
    {   
        return a + b;   
    }   
public static final int j_ex(int a)   
    {     
        return j_ex(a, 3)   
    }   
}</pre>
자바는 기본 파라미터를 지원하지 않기 때문에 파라미터의 값을 직접 삽입하여 오버로드하는 메소드를 생성한다.

# @file:JvmName
자바의 코드는 클래스 내에서 작성되기 때문에 코틀린 함수를 자바로 변환시에 클래스 내의 스태틱 메소드로 변환된다.
이때 생성되는 클래스의 이름은 코틀린.kt 파일 이름이 되기때문에 다른 이름을 원한다면 @file:JvmName("이름")
어노테이션으로 다른 이름의 자바 클래스를 생성할 수 있다.

<pre>
예)
코틀린 파일 이름 - ex.kt
@file:JvmName("new_name")

package 코틀린 패키지
class 코틀린 클래스
{
    fun 코틀린 함수
    {
        함수 내용
    }
}
</pre>
해당 내용을 자바에서 호출시 

exkt.코틀린 함수가 아닌 new_name.코틀린 함수로 호출 가능하다.

import mypackage.이름; <-- 을 해야한다.

ex.kt -> 자바변환시 exkt 클래스로 변환
@file:JvmName 사용 -> 자바변환시 설정한 이름의 클래스로 변환
