package kr.co.song.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.song.beans.TestBean;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// test1();
		// test2();
		test3();
		test4();
	}

	// BeanFactory �� �⺻������ bean �ڵ� �������� ����
	// BeanFactory - ��Ű�� ����
	public static void test1() {

		ClassPathResource res = new ClassPathResource("kr/co/song/config/beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);

		// ������ t1 �ѹ���, test1, test2 �� ����Ű�� �ּҰ��� ����
		TestBean test1 = factory.getBean("t1", TestBean.class);
		TestBean test2 = factory.getBean("t1", TestBean.class);
	}

	// BeanFactory - ��Ű�� �ܺ�
	public static void test2() {
		FileSystemResource res = new FileSystemResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);

		// ������ t1 �ѹ���, test1, test2 �� ����Ű�� �ּҰ��� ���� 
		TestBean test1 = factory.getBean("t2", TestBean.class);
		TestBean test2 = factory.getBean("t2", TestBean.class);
	}

	// ApplicationContext �� �⺻������ bean �ڵ� ���� ( ���� ���� )
	// ApplicationContext - ��Ű�� ����
	public static void test3() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/song/config/beans.xml");

		// �ѹ� ������ Bean�� �ּ� ����
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		TestBean t2 = (TestBean)ctx.getBean("t1");
		
		System.out.printf("%s\n", t1);
		System.out.printf("%s\n", t2);
		
		ctx.close();
	}
	
	// ApplicationContext - ��Ű�� �ܺ�
	public static void test4() {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");

		// �ѹ� ������ Bean�� �ּ� ����
		TestBean t1 = ctx.getBean("t2", TestBean.class);
		TestBean t2 = (TestBean)ctx.getBean("t2");
		
		System.out.printf("%s\n", t1);
		System.out.printf("%s\n", t2);
		
		ctx.close();
	}
}