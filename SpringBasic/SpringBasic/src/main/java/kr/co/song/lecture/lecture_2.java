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
		System.out.println("=========== start ============");

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/song/config/beans.xml");
		{
			//System.out.println("create bean");
			TestBean tb = (TestBean)ctx.getBean("lec2");
			//System.out.println("before block");
		}
		//System.out.println("after block");
		ctx.close();
		System.out.println("=========== end ============");
	}
}
