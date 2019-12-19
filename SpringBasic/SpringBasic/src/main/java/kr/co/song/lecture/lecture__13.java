package kr.co.song.lecture;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.song.beans.ComponentBean;
import kr.co.song.beans.TestBean;
import kr.co.song.config.BeanConfig;

public class lecture__13 implements lecture{

	
	public void run() {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		ComponentBean cb = (ComponentBean)ctx.getBean("lec_13");
		System.out.printf("%s\n",cb);
		
		ctx.close();	
	}

}
