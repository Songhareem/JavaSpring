package kr.co.song.lecture;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.song.beans.TestBean;

public class lecture_4 implements lecture{

	@Override
	public void run() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/song/config/beans.xml");
		
		// java code·Î °´Ã¼ »ý¼º
		TestBean tb = new TestBean();
		tb.printData(false);
		System.out.println("==============================");
		
		
		tb = (TestBean)ctx.getBean("lec4");
		tb.printData(false);
		
		ctx.close();
	}
}
