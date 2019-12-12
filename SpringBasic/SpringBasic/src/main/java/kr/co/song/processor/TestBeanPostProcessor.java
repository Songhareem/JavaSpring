package kr.co.song.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor{

	// object bean ���ڿ� �����Ǵ� bean ��ü�� �ּҰ��� ����
	// beanName ���ڸ� ���� ��ü�� ID�� �ش��ϴ� ��ü�� ����
	
	// init-method ȣ�� ��
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
	
	// init-method ȣ�� ��
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("after");
		return bean;
	}
}
