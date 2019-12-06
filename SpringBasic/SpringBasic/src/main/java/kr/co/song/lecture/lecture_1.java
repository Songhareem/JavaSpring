package kr.co.song.lecture;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.song.beans.TestBean;

//============================================
// lecture_1. BeanFactory와 ApplicationContext
//============================================
public class lecture_1 implements lecture{

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		//test3();
		//test4();
	}
	
	// BeanFactory 는 기본적으로 bean 자동 생성하지 않음
	// BeanFactory - 패키지 내부
	public static void test1() {

		ClassPathResource res = new ClassPathResource("kr/co/song/config/beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);

		// 생성은 t1 한번만, test1, test2 가 가르키는 주소값은 같음
		TestBean test1 = factory.getBean("lec1_inner", TestBean.class);
		TestBean test2 = factory.getBean("lec1_inner", TestBean.class);
	}

	// BeanFactory - 패키지 외부
	public static void test2() {
		FileSystemResource res = new FileSystemResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);

		// 생성은 t1 한번만, test1, test2 가 가르키는 주소값은 같음
		TestBean test1 = factory.getBean("lec1_outter", TestBean.class);
		TestBean test2 = factory.getBean("lec1_outter", TestBean.class);
	}

	// ApplicationContext 는 기본적으로 bean 자동 생성 ( 조절 가능 )
	// ApplicationContext - 패키지 내부
	public static void test3() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/song/config/beans.xml");

		// 한번 생성된 Bean은 주소 같음
		TestBean t1 = ctx.getBean("lec1_inner", TestBean.class);
		TestBean t2 = (TestBean) ctx.getBean("lec1_inner");

		System.out.printf("%s\n", t1);
		System.out.printf("%s\n", t2);

		ctx.close();
	}

	// ApplicationContext - 패키지 외부
	public static void test4() {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");

		// 한번 생성된 Bean은 주소 같음
		TestBean t1 = ctx.getBean("lec1_outter", TestBean.class);
		TestBean t2 = (TestBean) ctx.getBean("lec1_outter");

		System.out.printf("%s\n", t1);
		System.out.printf("%s\n", t2);

		ctx.close();
	}

}
