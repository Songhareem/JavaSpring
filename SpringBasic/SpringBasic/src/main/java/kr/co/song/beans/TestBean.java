package kr.co.song.beans;

public class TestBean {

	private int data1;
	private double data2;
	private String data3;
	private String data4;
	
	private DataBean dataBean1;
	private DataBean dataBean2;
	
	public TestBean() {
		
		System.out.println("TestBean ����");
		
		this.data1 = 0;
		this.data2 = 0.0;
		this.data3 = null;
		this.data4 = null;
	}
	
	public TestBean(int data1, double data2, String data3, String data4) {
		
		System.out.println("TestBean ����");
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
	}
	
	public TestBean(DataBean dataBean1, DataBean dataBean2) {
		
		System.out.println("TestBean ����");
		this.dataBean1 = dataBean1;
		this.dataBean2 = dataBean2;
	}
	
	
	public void default_init() {
		
		System.out.println("����Ʈ �ʱ�ȭ �Լ� ȣ��");
	}
	
	public void default_destroy() {
		
		System.out.println("����Ʈ �ı��� �Լ� ȣ��");
	}
	
	public void printData(boolean sw) {
		
		if(sw == true ) {
			System.out.printf("data1 : %d\n", data1);
			System.out.printf("data2 : %f\n", data2);
			System.out.printf("data3 : %s\n", data3);
			System.out.printf("data4 : %s\n", data4);
		}
		else { 
			System.out.printf("dataBean1 : %s\n", dataBean1);
			System.out.printf("dataBean2 : %s\n", dataBean2);
		}
	}
}
