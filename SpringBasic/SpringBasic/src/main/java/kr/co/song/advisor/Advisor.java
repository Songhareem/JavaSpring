package kr.co.song.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class Advisor {

	// Join Point 앞에 호출
	public void beforeMethod() {
		
		System.out.println("before advisor");
	}
	
	// Join Point 뒤에 호출
	public void afterMethod() {
		
		System.out.println("after advisor");
	}
	
	// Join Point 앞뒤로 호출
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("around before");
		
		// 원래의 메서드 호출
		// 원래 메서드는 반환값이 있을 수 있으므로 Object로 받아서 return 
		Object obj = pjp.proceed();
		
		System.out.println("around after");
	
		return obj;
	}
	
	// 정상적으로 끝난경우 호출
	public void afterReturningMethod() {
		
		System.out.println("after returning method");
	}
	
	// 예외상황에서 호출
	public void afterThrowingMethod(Throwable err) {
		System.out.println("after throwing method");
		System.out.println(err);
	}
}
