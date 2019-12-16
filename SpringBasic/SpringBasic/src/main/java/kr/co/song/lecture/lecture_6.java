package kr.co.song.lecture;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.song.beans.DataBean;
import kr.co.song.beans.TestBean;

public class lecture_6 implements lecture{

	@Override
	public void run() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/song/config/beans.xml");
		
		//listInjection(ctx);
		//setInjection(ctx);
		//mapInjection(ctx);
		propInjection(ctx);
		
		ctx.close();
	}
	
	void listInjection(ClassPathXmlApplicationContext ctx) {
		
		System.out.println("List Injection");
		
		TestBean tbList = (TestBean)ctx.getBean("lec6");
		
		List<String> list1 = tbList.getList1();
		List<Integer> list2 = tbList.getList2();
		List<DataBean> list3 = tbList.getList3();
		
		for(String str: list1) {
			System.out.println(str);
		}
		
		for(Integer i : list2) {
			System.out.println(i);
		}
		
		for(DataBean obj : list3) {
			System.out.printf("%s\n",obj);
		}
	}
	
	void setInjection(ClassPathXmlApplicationContext ctx) {
		
		System.out.println("Set Injection");
		
		TestBean tbSet = (TestBean)ctx.getBean("lec6");
		
		Set<String> set1 = tbSet.getSet1();
		Set<Integer> set2 = tbSet.getSet2();
		Set<DataBean> set3 = tbSet.getSet3();
		
		for(String str: set1) {
			System.out.println(str);
		}
		
		for(Integer i : set2) {
			System.out.println(i);
		}
		
		for(DataBean obj : set3) {
			System.out.printf("%s\n",obj);
		}
	}
	
	void mapInjection(ClassPathXmlApplicationContext ctx) {
		
		System.out.println("Set Injection");
		
		TestBean tbMap = (TestBean)ctx.getBean("lec6");
		
		Map<String, Object> map1 = tbMap.getMap1();
		
		String a1=(String)map1.get("a1");
		int a2 = (Integer)map1.get("a2");
		DataBean a3 = (DataBean)map1.get("a3");
		DataBean a4 = (DataBean)map1.get("a4");
		List<String> a5 = (List<String>)map1.get("a5");
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		for(String str: a5) {
			
			System.out.println(str);
		}
	}
	
	void propInjection(ClassPathXmlApplicationContext ctx) {
		
		System.out.println("Set Injection");
		
		TestBean tbProp = (TestBean)ctx.getBean("lec6");
		
		Properties prop1 = tbProp.getProp1();
		
		String p1 = prop1.getProperty("p1");
		String p2 = prop1.getProperty("p2");
		String p3 = prop1.getProperty("p3");
	
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
	}
}