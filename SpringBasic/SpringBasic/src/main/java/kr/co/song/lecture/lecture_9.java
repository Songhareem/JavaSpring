package kr.co.song.lecture;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.song.beans.TestBean;
import kr.co.song.config.BeanConfig;

public class lecture_9 implements lecture{

	public void run() {
	
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		TestBean tb = (TestBean)ctx.getBean("lec9");
		System.out.printf("%s\n",tb);
		
		ctx.close();
	}
}
