package kr.co.song.lecture;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.song.beans.TestBean;

//============================================
//lecture_1. Bean의 생명주기
//============================================
public class lecture_2 implements lecture{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/song/config/beans.xml");
	
		TestBean tb = (TestBean)ctx.getBean("lec2");
		
		ctx.close();
	}
}
