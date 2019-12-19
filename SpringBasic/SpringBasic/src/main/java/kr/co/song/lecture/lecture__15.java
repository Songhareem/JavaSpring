package kr.co.song.lecture;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.song.beans.ComponentBean;
import kr.co.song.config.BeanConfig;

public class lecture__15 implements lecture {

	public void run() {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		ComponentBean cb = (ComponentBean)ctx.getBean("lec_15");
		System.out.printf("%s\n",cb);
		
		System.out.printf("%d\n",cb.getData1());
		System.out.printf("%s\n",cb.getData2());
		
		System.out.printf("%s\n",cb.getDataBean1());
		System.out.printf("%s\n",cb.getDataBean2());
		
		ctx.close();
		
	}

}
