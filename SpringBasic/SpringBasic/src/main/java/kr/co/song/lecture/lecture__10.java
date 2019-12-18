package kr.co.song.lecture;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.song.beans.TestBean;
import kr.co.song.config.BeanConfig;

public class lecture__10 implements lecture {
	
	public void run() {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		TestBean tb = (TestBean)ctx.getBean("lec_10"); 
		System.out.printf("%s\n",tb);
		
		//System.out.printf("%d\n",tb.getData1());
		//System.out.printf("%s\n",tb.getData3());
		System.out.printf("%s\n",tb.getDataBean1());
		System.out.printf("%s\n",tb.getDataBean2());
		
		ctx.close();
	}
}
