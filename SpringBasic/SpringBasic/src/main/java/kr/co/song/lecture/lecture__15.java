package kr.co.song.lecture;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.song.beans.ComponentBean;
import kr.co.song.beans.TestBean;
import kr.co.song.config.BeanConfig;

public class lecture__15 implements lecture {

	public void run() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/song/config/beans.xml");
		
		TestBean tb = (TestBean)ctx.getBean("lec_15");
		System.out.printf("%s\n",tb);
		
		System.out.println(tb.aopMethod());
		
		ctx.close();
		
	}

}
