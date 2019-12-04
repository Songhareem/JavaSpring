
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