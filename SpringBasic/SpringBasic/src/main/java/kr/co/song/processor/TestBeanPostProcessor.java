package kr.co.song.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor{

	// object bean 인자에 생성되는 bean 객체의 주소값이 들어옴
	// beanName 인자를 통해 객체의 ID에 해당하는 객체가 들어옴
	
	// init-method 호출 전
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("before");
		switch(beanName) {
		
		case "lec1" :
			System.out.println("lec1 before");
			break;
		case "lec2" :
			System.out.println("lec2 before");
			break;
		case "lec3" :
			System.out.println("lec3 before");
			break;
		case "lec4" :
			System.out.println("lec4 before");
			break;
		}
		return bean;
	}
	
	// init-method 호출 후
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("after");
		return bean;
	}
}
