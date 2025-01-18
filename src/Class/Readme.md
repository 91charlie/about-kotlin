# about class in Kotlin
### 객체 지향 프로그래밍은 함수 형과 달리 설계가 쉽지만 사이드 이펙트 관리가 힘들다(불변성 부족 , 캡슐화의 한계 등)
## -code의 형태-

    class Name()
     {
        필드 = 클래스내 고유 데이터(변수) 예) var name: type = value

        프로퍼티 = 필드 + *접근제한자* + getter and setter(*접근자*) 
        예) public var name:type = value
        get()
            {
            }
        set()
            {
            }       
        
    fun Name()
        {
          클래스 내의 함수는 메소드라고 한다.
        }
    }

### -- 접근제한자? -- 
#### private - 클래스 내부에서만 사용된다.상속 및 main()에서 직접 호출 불가
#### protected - 상위 클래스에서 하위클래스 사이의 상속까지 가능 main()에서 직접 호출 불가.
#### internal - 모듈 내에서 접근 가능하다.
#### public(기본 설정) - 어디에서나 접근 가능하며 자바와 마찬가지로 별도로 선언하지 않을시 기본으로 설정되는 접근제한자이다.

### -- 접근자? --
#### getter - 클래스 내부에서 선언한 속성의 값을 가져온다.(읽기) val 과 var 모두 생성된다.
#### setter - 클래스 내부에서 선언한 속성의 값을 설정한다.(쓰기) var 만 생성된다.
#### val name:type = value 로 선언시 클래스 내에서 private field 로  선언되고 main() 에서 호출할 경우 public getter 를 통해 값을 읽는다.
#### var name:type = value 로 선언시 클래스 내에서 private field 로 선언되고 main() 에서 public getter 와 public setter 를 통해 값을 읽고 쓸 수 있다.
