package kr.co.song.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.*;

import kr.co.song.beans.DataBean;
import kr.co.song.beans.TestBean;

@Configuration
@ComponentScan(basePackages = "kr.co.song.beans") // ��γ��� �ִ� @Component(��ϵ� Bean) ã��
public class BeanConfig {

	// ============================================
	// lecture_8
	// Annotation�� �̿��� bean ���
	// ============================================
	
	/*
	// @Bean // �޼ҵ� ���� id
	public TestBean lec_8() {
		
		return new TestBean();
	}

	@Bean//(name = "lec_8") 	// name�� �Էµ� id���� ���� Bean ���
	//@Lazy 					// getBean �޼ҵ� ȣ��� ��ü ����
	@Scope("prototype")		// Singleton�� �ƴ� �Ź� ��ü ���� ����	
	public TestBean nameTest() {
		
		return new TestBean();
	}
	
	@Bean//(name = "lec_8")
	@Primary					// id�� �������� ���� ���� Ÿ���� bean�� ��ǥ bean
	public TestBean primaryTest() {
		TestBean tb = new TestBean();
		System.out.println("==== PrimaryTest ====");
		return tb;
	}
	*/
	
	// ============================================
	// lecture_9
	// Annotation�� �̿���
	// init-method ���
	// destroy-method ���
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
	// Annotation�� �̿���
	// �����ڸ� ���� ���� : �����ڿ� �׳� �� ����
	// Setter�� ���� ���� : ���͸� ���� �� ����
	// �ڵ� ���� : autowire �̿�(Autowire.BY_NAME, Autowire.BY_TYPE) , 5.1 �������� �������� ����
	//             ��ü�� ����
	//
	// file�� �о�ͼ� ���� �־��ټ��� �ְ�,
	// ��Ʈ��ũ socket���� �� �о �־��ټ��� ����
	// ============================================
	
	/* 
	// Constructor �̿�
	@Bean
	public TestBean lec_10() {
	
		return new TestBean(100, "���ڿ� ������", new DataBean(), new DataBean());
	}
	 
	// Setter �̿�
	@Bean
	@Primary
	public TestBean lec_10() {
		
		TestBean tb = new TestBean();
		tb.setData1(200);
		tb.setData3("���ڿ� Setter");
		tb.setDataBean1(new DataBean());
		tb.setDataBean2(new DataBean());
		
		return tb;
	}
	*/
	
	// �ڵ�����(autowire=byName)
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
	
	// �ڵ�����(autowire=Autowire.BY_TYPE)
	// �ϳ��� Ÿ���� �ϳ��� �� ����
	
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
	// @Configuration : Ŭ������ �� ������̼��� �پ� ������ �������� �ش� Ŭ������ Java config�� �����Ѵ�.
	// 
	// @Required : setter�� ���� �ݵ�� �޾ƾ��� ���� ����
	// 5.1 ���� ���ķδ� �ݵ�� �����ؾ��� ������ �����ڸ� ���� ����
	//
	// @Autowired : �ڵ� ���� ������̼�
	// �� ���Ͽ� �ڵ� ������ bean�� ����� ���־�� �Ѵ�
	// ������ �����ϸ�, �ڵ����� setter�޼ҵ尡 �߰��Ǿ� setter���� ���� ����
	//
	// @Qualifier
	// @Autowired �� ���� ���� ������̼�
	// ���� ��ü Ÿ���� Bean�� �ΰ� �̻� ��ϵ� ������, xml������ id, java������ �޼ҵ�� ���� �����Ͽ� ���� ����
	// @Qualifier("�̸�") �� ���� ������ ���
	//
	// @Autowired(required = false) : �ش� �ϴ� ��ü�� ������ �����ϰ� ������ NULL
	// 
	// �����ڸ� ���� ����
	// 
	// ============================================

	/*
	@Bean
	public TestBean lec_11() {
		return new TestBean();
	}
	
	@Bean
	//@Scope("prototype")
	public DataBean dataBean() {
		System.out.println("dataBean3 Bean ����");
		return new DataBean();
	}
	*/
	
	// ============================================
	// lecture_12
	// JSR 250 ������̼�
	// 
	// initMethod / destroyMethod ���� ������ �ڹ� ���Ͽ� ������̼��� �̿��� ���� ���
	// @PostInitaion : initMethod
	// @PreDestroy : destroyMethod
	// @Resource : ������ �̸��� ������ �̸��� bean�� setter�� ���� ���Ե�
	// @Resource(name = "beanName") : ��ϵ� Bean�� beanName�� ���� ������ ����
	// ============================================

	/*
	@Bean
	@Lazy
	public TestBean lec_12() {
		
		return new TestBean();
	}
	
	@Bean
	public DataBean dataBean4() {
		return new DataBean();
	}
	*/
	
	// ============================================
	// lecture_13
	// @Component : BeanConfig ���Ͽ� bean�� ������� �ʾƵ� �ڵ� ���(Ŭ���� type���� bean ���)
	// @Component("beanName") : beanName���� ���
	// @ComponentScan(basePackages = {"Bean�� ����ϰ��� �ϴ� ��ü�� �ִ� ��Ű�� ���","���2",...}) : class���� ����
	//
	// ���� Ÿ���� Ŭ������ ���� �̸����� ����ϴ� ���� �Ұ��� �ϹǷ� �ʿ��� ���, xml�̳� BeanConfig�� �̿��ؾ���
	//
	// @Bean / @Component ���?
	// @Bean : �����ڰ� Class�� �ڵ带 ������ �� ���� ���, ���� Ŭ���� Ÿ���� Bean�� ���� �� ����� ���
	// @Component : �����ڰ� Class�� �ڵ带 ������ �� �ִ� ���
	// ============================================
	
	// ============================================
	// lecture_14
	// Component �ڵ� ����
	//
	// @Autowired : Ÿ���� ���� �ڵ� ����
	// @Qualifier : �̸��� ���� �ڵ� ����
	// @Resource : Autowired + Qualifier
	// �������� ��� Ÿ���� ���� Bean�� ã�� �ڵ����� �����Ѵ� (@Required �ʿ� X), ����Ʈ ������ ����, ����� ���� �����ڸ� ����� �ȴ�
	// 
	// ============================================
	
	/*
	@Bean(name = "id_1")
	public DataBean dataBean() {
		System.out.println("id_1");
		return new DataBean();
	}
	
	@Bean(name = "id_2")
	public DataBean dataBean2() {
		System.out.println("id_2");
		return new DataBean();
	}
	*/
	
	
}
