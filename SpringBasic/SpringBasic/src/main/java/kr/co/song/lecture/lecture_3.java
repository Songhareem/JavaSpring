package kr.co.song.lecture;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.song.beans.TestBean;

public class lecture_3 implements lecture{

	@Override
	public void run() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/song/config/beans.xml");
		
		TestBean tb = (TestBean)ctx.getBean("lec3");
		
		ctx.close();
	}
}
