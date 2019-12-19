package kr.co.song.lecture;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.song.beans.TestBean;
import kr.co.song.config.BeanConfig;

public class lecture__12 implements lecture{

	public void run() {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		TestBean tb = (TestBean)ctx.getBean("lec_12"); 
		System.out.printf("%s\n",tb);
		
		System.out.printf("%s\n",tb.getDataBean4());
		System.out.printf("%s\n",tb.getDataBean5());
		
		ctx.close();
	}
}
