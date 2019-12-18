package kr.co.song.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.*;

import kr.co.song.beans.DataBean;
import kr.co.song.beans.TestBean;

@Configuration
public class BeanConfig {

	// ============================================
	// lecture_8
	// Annotation을 이용한 bean 등록
	// ============================================
	
	/*
	// @Bean // 메소드 명이 id
	public TestBean lec_8() {
		
		return new TestBean();
	}

	@Bean//(name = "lec_8") 	// name에 입력된 id값을 가진 Bean 등록
	//@Lazy 					// getBean 메소드 호출시 객체 생성
	@Scope("prototype")		// Singleton이 아닌 매번 객체 새로 생성	
	public TestBean nameTest() {
		
		return new TestBean();
	}
	
	@Bean//(name = "lec_8")
	@Primary					// id가 정해지지 않은 같은 타입의 bean중 대표 bean
	public TestBean primaryTest() {
		TestBean tb = new TestBean();
		System.out.println("==== PrimaryTest ====");
		return tb;
	}
	*/
	
	// ============================================
	// lecture_9
	// Annotation을 이용한
	// init-method 등록
	// destroy-method 등록
	// ============================================
	
	/*
	@Bean(initMethod = "init", destroyMethod="destroy")
	@Lazy
	public TestBean lec9() {
		
		return new TestBean();
	}
	*/
	
	// ============================================
	// lecture_10
	// Annotation을 이용한
	// 생성자를 통한 주입 : 생성자에 그냥 값 주입
	// Setter를 통한 주입 : 세터를 통해 값 주입
	// 자동 주입 : autowire 이용(Autowire.BY_NAME, Autowire.BY_TYPE) , 5.1 버전부터 권장하지 않음
	//             객체만 가능
	//
	// file을 읽어와서 값을 넣어줄수도 있고,
	// 네트워크 socket에서 값 읽어서 넣어줄수도 있음
	// ============================================
	
	/* 
	// Constructor 이용
	@Bean
	public TestBean lec_10() {
	
		return new TestBean(100, "문자열 생성자", new DataBean(), new DataBean());
	}
	 
	// Setter 이용
	@Bean
	@Primary
	public TestBean lec_10() {
		
		TestBean tb = new TestBean();
		tb.setData1(200);
		tb.setData3("문자열 Setter");
		tb.setDataBean1(new DataBean());
		tb.setDataBean2(new DataBean());
		
		return tb;
	}
	*/
	
	// 자동주입(autowire=byName)
	/*
	@Bean
	public DataBean dataBean1() {
		
		return new DataBean();
	}
	
	@Bean
	public DataBean dataBean2() {
		
		return new DataBean();
	}
	
	@Bean(autowire=Autowire.BY_NAME)
	public TestBean lec_10() {
		
		return new TestBean();
	}
	*/
	
	// 자동주입(autowire=Autowire.BY_TYPE)
	// 하나의 타입은 하나만 빈 지정
	
	/*
	@Bean
	public DataBean dataBean() {
		return new DataBean();
	}
	
	@Bean(autowire=Autowire.BY_TYPE)
	public TestBean lec_10() {
		
		return new TestBean();
	}
	*/
	
	// ============================================
	// lecture_11
	// @Configuration : 클래스에 이 어노테이션이 붙어 있으면 스프링은 해당 클래스를 Java config로 간주한다.
	// 
	// @Required : setter를 통해 반드시 받아야할 값에 설정
	// 5.1 버전 이후로는 반드시 주입해야할 값들은 생성자를 통해 받음
	//
	// @Autowired : 자동 주입 어노테이션
	// 이 파일에 자동 주입할 bean을 등록을 해주어야 한다
	// 변수에 설정하면, 자동으로 setter메소드가 추가되어 setter통해 주입 받음
	//
	// @Qualifier
	// @Autowired 와 같이 쓰는 어노테이션
	// 같은 객체 타입의 Bean이 두개 이상 등록돼 있을때, xml에서는 id, java에서는 메소드명 으로 구분하여 주입 받음
	// @Qualifier("이름") 와 같은 식으로 사용
	//
	// @Autowired(required = false) : 해당 하는 객체가 있으면 주입하고 없으면 NULL
	// 
	// 생성자를 통한 주입
	// ============================================

	@Bean
	public TestBean lec_11() {
		return new TestBean();
	}
	
	@Bean
	//@Scope("prototype")
	public DataBean dataBean3() {
		System.out.println("dataBean3 Bean 생성");
		return new DataBean();
	}
}
