package kr.co.song.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class Advisor {

	// Join Point �տ� ȣ��
	public void beforeMethod() {
		
		System.out.println("before advisor");
	}
	
	// Join Point �ڿ� ȣ��
	public void afterMethod() {
		
		System.out.println("after advisor");
	}
	
	// Join Point �յڷ� ȣ��
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("around before");
		
		// ������ �޼��� ȣ��
		// ���� �޼���� ��ȯ���� ���� �� �����Ƿ� Object�� �޾Ƽ� return 
		Object obj = pjp.proceed();
		
		System.out.println("around after");
	
		return obj;
	}
	
	// ���������� ������� ȣ��
	public void afterReturningMethod() {
		
		System.out.println("after returning method");
	}
	
	// ���ܻ�Ȳ���� ȣ��
	public void afterThrowingMethod(Throwable err) {
		System.out.println("after throwing method");
		System.out.println(err);
	}
}
