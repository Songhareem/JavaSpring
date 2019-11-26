
# Spring IoC
+ IoC?
    + Inversion of Control
    + 내가 사용할 의존성을 안에서 생성하지 않고, 밖에서 인자로 받아옴
    + ex) Dependency Injection

 + Bean? 
    + App의 핵심을 이루는 객체, IoC 컨테이너에 의해 인스턴스화, 관리, 생성

+ IoC 컨테이너?
    + Bean을 만들고 Bean들을 엮어주고 제공
    + BeanFactory OR ApplicationContext 중 하나를 사용 (주로 후자 사용)
    + BeanFactory (사실상 IoC 컨테이너)
    + ApplicationContext (BeanFactory 상속)
    + 의존성 주입은 Bean끼리만 가능! (IoC컨테이너 안에 있는 Bean끼리)

+ 의존성?
    + 코드에서 두 모듈 간의 연결
    + OPP에서는 두 클래스 간의 관계라 표현
    + 일반적으로 둥 중 하나가 다른 하나를 어떤 용도를 위해 사용함 

+ 의존성의 위험성
    + 하나의 모듈이 바뀌면 의존한 모듈까지 변경 필요
    + 테스트 가능한 어플 만들때, 의존성이 있으면 유닛테스트 작성이 어려움
        + 유닛테스트의 목적이 다른 모듈로부터 독립적으로 테스트하는 것을 요구하기 때문

+ 의존성 주입
    + 의존성의 위험성을 해결하기 위해 사용
    + 다른 클래스와 독립적으로 클래스 테스트 가능하게 해줌

+ 의존성 주입 방법
    + public independencyClass(dependencyClass dc) {...}
        + 순환 참조시, 불가능한 방법 (A에서 B참조, B에서 A참조)
    + @Autowired</br> private dependencyClass dc ;
    + @Autowired</br> public void setter(dependencyClass dc) {...}

# Spring AOP

# Spring PSA


# Error 모음

## user lacks privilege or object not found : DB.ColumnName 
+ DB에 해당 컬럼이 없기때문에 발생

## row column count mismatch
+ DB에 입력시, 자주 발생
+ DB 스키마의 data 순서와 입력값의 순서가 다르면 발생(컬럼에 맞지않게 insert)