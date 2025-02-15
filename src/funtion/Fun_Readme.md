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
