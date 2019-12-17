package kr.co.song.config;

import org.springframework.context.annotation.*;

import kr.co.song.beans.TestBean;

@Configuration
public class BeanConfig {

	// ============================================
	// lecture_8
	// Annotation을 이용한 bean 등록
	// ============================================

	// @Bean // 메소드 명이 id
	// public TestBean lec_8() {
	// TestBean tb = new TestBean();
	// return tb;
	// }

	@Bean(name = "lec_8") 	// name에 입력된 id값을 가진 Bean 등록
	//@Lazy 					// getBean 메소드 호출시 객체 생성
	@Scope("prototype")		// Singleton이 아닌 매번 객체 새로 생성	
	public TestBean nameTest() {
		TestBean tb = new TestBean();
		return tb;
	}

}
