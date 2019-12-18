package kr.co.song.lecture;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.song.beans.TestBean;
import kr.co.song.config.BeanConfig;

public class lecture_8 implements lecture{

	public void run() {

		// java 파일로 bean 등록
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("kr.co.song.config.BeanConfig.java");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);

		//TestBean tb = (TestBean)ctx.getBean("lec_8");
		//TestBean tb2 = (TestBean)ctx.getBean("lec_8");
		
		//System.out.printf("%s\n",tb);
		//System.out.printf("%s\n",tb2);

		System.out.println("=============================================");
		
		TestBean tb3 = (TestBean)ctx.getBean(TestBean.class);
		TestBean tb4 = (TestBean)ctx.getBean(TestBean.class);
		
		System.out.printf("%s\n",tb3);
		System.out.printf("%s\n",tb4);

		ctx.close();
	}
}
