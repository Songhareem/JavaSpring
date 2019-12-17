package kr.co.song.config;

import org.springframework.context.annotation.*;

import kr.co.song.beans.TestBean;

@Configuration
public class BeanConfig {

	// ============================================
	// lecture_8
	// Annotation�� �̿��� bean ���
	// ============================================

	// @Bean // �޼ҵ� ���� id
	// public TestBean lec_8() {
	// TestBean tb = new TestBean();
	// return tb;
	// }

	@Bean(name = "lec_8") 	// name�� �Էµ� id���� ���� Bean ���
	//@Lazy 					// getBean �޼ҵ� ȣ��� ��ü ����
	@Scope("prototype")		// Singleton�� �ƴ� �Ź� ��ü ���� ����	
	public TestBean nameTest() {
		TestBean tb = new TestBean();
		return tb;
	}

}
