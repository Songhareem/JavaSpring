package kr.co.song.lecture;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.song.beans.TestBean;

public class lecture_7 implements lecture{

	@Override
	public void run() {
	
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/song/config/beans.xml");
		
		TestBean tb = (TestBean)ctx.getBean("lec7");
		
		System.out.printf("data1 : %d\n", tb.getData1());
		System.out.printf("data2 : %s\n", tb.getData3());
		System.out.printf("data3 : %s\n", tb.getDataBean1());
		System.out.printf("data4 : %s\n", tb.getDataBean2());
		
		ctx.close();
	}
}
