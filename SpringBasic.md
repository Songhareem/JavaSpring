
# Spring IoC

+ IoC?
    + Inversion of Control (제어 역전)
    + 객체에 대한 제어권을 개발자가 아닌 프레임워크가 가짐
    + 내가 사용할 의존성을 안에서 생성하지 않고, 밖에서 인자로 받아옴
    + ex) Dependency Injection

 + Bean? (Plain Old Java Object)
    + App의 핵심을 이루는 객체, IoC 컨테이너에 의해 인스턴스화, 관리, 생성
    + 자바 모델이나 기능 프레임워크 등에 따르지 않고 홀로 독립적이며 단순한 기능만을 가진 객체

+ IoC 컨테이너?
    + Bean을 만들고 Bean들을 엮어주고 제공
    + BeanFactory OR ApplicationContext 중 하나를 사용 (주로 후자 사용)
    + BeanFactory (사실상 IoC 컨테이너)
    + ApplicationContext (BeanFactory 상속)
    + 의존성 주입은 Bean끼리만 가능! (IoC컨테이너 안에 있는 Bean끼리)

+ Bean 객체 생성
    + xml 파일을 통해 빈 등록
        + xml을 로딩할 때 자동으로 객체가 생성된다.(디폴트로 lazy-init = "false")
        + 생성된 객체는 더 이상 생성되지 않는다. (디폴트로 scope="singleton")
        + Bean 태그의 속성
            + class : 객체를 생성하기위해 사용할 클래스를 지정
            + id : id 속성 부여하면 getBean 메서드를 통해 객체의 주소값을 받아 사용가능
            + lazy-init : = "true" 값을 넣으면, xml 로딩시 객체를 생성하는 것이 아닌,
            getBean 호출시 생성
            + scope : 객체의 범위를 설정 (Singleton: 객체를 하나만 생성해서 사용)
            + prototype: 객체를 가져올때마다 객체 생성(암묵적으로 lazy-init = "true")
            + init-method : 생성자 호출 이후 자동으로 지정 메서드 호출
            + destroy-method : 객체가 소멸될 때 자동으로 호출
            + default-init-method : init-method 설정 안한 경우 자동으로 호출
            + default-destroy-method : destroy-method 설정 안한 경우 자동으로 호출
            + primary : id 없는 같은 클래스 다수가 bean 등록이 되어있을 때, primary = "true" 를 설정한 bean이 대표 bean이 된다
    + java 파일에서 Annotation 활용하여 빈 등록
        + xml 파일에 비해 비교적 코드 작성이 자유로움
        + @Bean
            + bean 객체 정의시 사용
            + 메서드의 이름이 bean의 이름이 된다
            + (name=이름) : bean의 이름을 새롭게 정의
            + (initMethod=메소드명) : 객체 생성시, 해당 메소드명을 가진 메소드를 실행
            + (destroyMethod=메소드명) : 객체 파괴시, 해당 메소드명을 가진 메소드를 실행
        + @Lazy : lazy-init = true 으로 설정
        + @Scope : bean의 scope=prototype 으로 설정
        + @Primary : primary 속성 지정

+ Bean 객체 생명 주기
    + 생성
        + scope = "singleton" : 객체를 한번만 생성
            + lazy-init = "false" : xml파일 로딩시 생성
            + lazy-init = "true" : getBean시 객체 생성
        + scope = "prototype" : getBean시, 객체 매번 새로 생성
    + 삭제
        + IoC 컨테이너 종료 시
    + 생성 및 삭제 시 호출될 메서드 등록 방법
        + 각 Bean에 적용
            + init-method
            + destroy-method
        + 전체 Bean에 적용
            + default-init-method
            + default-destroy-method
        + 메서드가 없을 경우?
            + default-init-method/default-destroy-method : 아무일도 없음
            + init-method/destroy-method : 오류 발생
    
+ BeanPostProcessor
    + BeanPostProcessor 인터페이스를 구현한 클래스를 정의하면 Bean객 체를 생성하면</br>
      init-method로 지정된 메서드를 호출하지 않고, 다른 메서드를 호출하게 할 수 있다
    + postProcessBeforeInitialization : init-method 지정 메서드 호출 전에 호출
    + postProcessAfterInitalization : init-mehtod 지정 메서드 호출 후에 호출
    + 위의 두 메서드는 init-method가 지정되있지 않아도 자동 호출
    + 매개변수
        + Object bean       : 생성되는 객체의 주소값
        + String beanName   : beanName = 생성된 객체에 해당하는 ID값

+ 의존성?
    + 코드에서 두 모듈 간의 연결
    + OPP에서는 두 클래스 간의 관계라 표현
    + 일반적으로 둥 중 하나가 다른 하나를 어떤 용도를 위해 사용함 

+ 의존성의 위험성
    + 하나의 모듈이 바뀌면 의존한 모듈까지 변경 필요
    + 테스트 가능한 어플 만들때, 의존성이 있으면 유닛테스트 작성이 어려움
        + 유닛테스트의 목적이 다른 모듈로부터 독립적으로 테스트하는 것을 요구하기 때문

+ 의존성 주입
    + Bean 객체 생성시, Bean 객체가 관리할 값이나 객체를 주입하는 것을 의미
    + Bean 객체 생성 후, Bean 객체가 가질 기본값을 자가코드가 아닌 xml 코드에서 정의
    + 의존성의 위험성을 해결하기 위해 사용
    + 다른 클래스와 독립적으로 클래스 테스트 가능하게 해줌
    + Spring에서 의존성 주입시 + type 미지정시, 우선순위 : 문자열 > 실수 > 정수
    + 1 ) 생성자를 통한 주입
        + 의존성 주입시, 매개변수의 type과 생성자 매개변수 type이 일치한다면, 순서 상관없음
        + < constructor-arg > 태그 사용
        + value : 매개변수에 넣고 싶은 값
        + type : 매개변수에 넣을 값의 type (class라면 풀패키지 path 지정)
        + index : 몇번째 매개변수에 값을 넣을지 지정, 0에서 시작
    + 2 ) Setter를 이용한 주입
        + < property > 태그 사용
        + name : 앞에 'set'을 붙여서 해당 setter를 호출
        + value : 매개변수에 넣을 값
        + type : 넣을 value의 type

+ 의존성 주입 방법
    + public independencyClass(dependencyClass dc) {...}
        + 순환 참조시, 불가능한 방법 (A에서 B참조, B에서 A참조)
    + @Autowired</br> 
      private dependencyClass dc ;
    + @Autowired</br> 
      public void setter(dependencyClass dc) {...}

# Spring AOP

+ AOP?
    + Aspect Oriented Programming
    + 흩어진 코드를 한 곳으로 모아놓는 것

+ 다양한 AOP 구현방법
    + 컴파일
        + AspectJ 이용 
        + a.java -------(AOP)-------> a.class
    + 바이트코드 조작
        + AspectJ 이용
        + a.java ---> a.class ----(AOP)---> 메모리
    + 프록시 패턴
        + 스프링 AOP가 사용
        + ref: https://refactoring.guru/design-patterns/proxy
    
+ 프록시 패턴 실제 구현 예제
    + proxy 패키지 생성
    + proxy/Payment.java 생성
        + payment.java 
            <pre>
            public interface payment {
            
                void pay(int amount);
            }
            </pre>
    + proxy/Store.java 생성
        + Store.java 
            <pre>
            public class Store {
            
                Payment payment;

                public Store(Payment payment) {
                 this.payment = payment;
                }

                public void buySomething(int amount) {
                    payment.pay(amount);
                }
            }
            </pre>
    + proxy/Cash.java 생성
        + Cash.java 
            <pre>
            public class Cash implements Payment {
            
                @Override
                public void pay(int amount) {
                    System.out.println(amount + "현금 결제");
                }
            }
            </pre>
    + proxy/CashPerf.java 생성 => 프록시 역할
        + CashPerf.java 
            <pre>
            public class CashPerf implements Payment {
                
                Payment cash = new Cash();
                
                @Override
                public void pay(int amount) {
                    StopWatch stopWatch = new StopWatch();
                    stopWatch.start();
                    cash.pay(amount);
                    stopWatch.stop();
                    System.out.println(stopWatch.prettyPrint());
                }
            }
            </pre>
    + proxy/mainStore.java 생성
        + mainStore.java 
            <pre>
            public class mainStore {
                
                @Test
                public void testPay() {
                    // proxy 사용 코드
                    Payment cashPerf = new CashPerf();
                    // proxy 미사용 코드
                    //Payment cash = new Cash();
                    Store store = new Store(cashPerf);
                    store.buySomething(100);    
                }
            }
            </pre>

+ @AOP 실습
    + 에노테이션을 이용한 AOP 만들기
    + @LogExecutionTime 에노테이션으로 사용
    + <pre>
        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Sample {}
    </pre>
    + <pre>
        @Componet
        @Aspect
        public class LogAspect {

            Logger loger = LoggerFactory.getLogger(LogAspect.class);

            @Around("@annotation(LogExecutionTime)")
            public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                
                Object proceed = joinPoint.proceed();

                stopWatch.stop();
                logger.info(stopWatch.prettyPrint());

                return proceed;
            }
        }
    </pre>

# Spring PSA

+ PSA?
    + Potable Service Abstraction
    + = 잘 만든 인더페이스
    + 코드를 거의 OR 아예 변경하지 않고 쓰이는 기술을 바꿀 수 있다
        + Servlet? OR Reactive?
        + Tomcat? OR Netty? OR Jetty? OR Undertow?

+ PSA 사용
    + 스프링 웹 MVC
        + @Controller | @RequestMapping | ...
    + 스프링 트랜잭션
        + @Transactional
    + 스프링 캐시
        + @Casheable | @CacheEvict

+ WebFlex? 
    + CPU 갯수만큼의 스레드 유지 
    + Netty 기반

+ servlet 
    + 하나의 요청당 하나의 스레드
    + 보통 Tomcat 기반

# 알아두면 좋은 것?

+ spring 제공 프로파일러
    + StopWatch stopWatch = new StopWatch();
    + stopWatch.start();
    + stopWatch.stop();
    + stopWatch().prettyPrint();

+ java 컴파일 과정
    + ref: https://aljjabaegi.tistory.com/387

# Error 모음

## user lacks privilege or object not found : DB.ColumnName 
+ DB에 해당 컬럼이 없기때문에 발생

## row column count mismatch
+ DB에 입력시, 자주 발생
+ DB 스키마의 data 순서와 입력값의 순서가 다르면 발생(컬럼에 맞지않게 insert)