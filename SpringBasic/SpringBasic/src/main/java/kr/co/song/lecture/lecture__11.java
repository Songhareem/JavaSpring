package kr.co.song.lecture;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.song.beans.TestBean;
import kr.co.song.config.BeanConfig;

public class lecture__11 implements lecture{

	public void run() {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		
		TestBean tb = (TestBean)ctx.getBean("lec_11"); 
		//System.out.printf("%s\n",tb);
		  
		//System.out.printf("%d\n",tb.getData1());
		//System.out.printf("%s\n",tb.getDataBean1());
		//System.out.printf("%s\n",tb.getDataBean2());
		System.out.printf("%s\n",tb.getDataBean3());
		
		ctx.close();
	}
}
