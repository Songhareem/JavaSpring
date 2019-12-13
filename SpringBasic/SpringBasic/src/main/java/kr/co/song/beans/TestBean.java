package kr.co.song.beans;

public class TestBean {

	//====================
	// 변수
	//====================
	private int data1;
	private double data2;
	private String data3;
	private String data4;
	
	private DataBean dataBean1;
	private DataBean dataBean2;
	
	//====================
	// 메소드
	//====================
	
	// 생성자
	public TestBean() {
		
		System.out.println("TestBean 생성");
		
		this.data1 = 0;
		this.data2 = 0.0;
		this.data3 = null;
		this.data4 = null;
	}

	public TestBean(int data1, double data2, String data3, String data4) {
		
		System.out.println("TestBean 생성");
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
		this.data4 = data4;
	}
	
	public TestBean(DataBean dataBean1, DataBean dataBean2) {
		
		System.out.println("TestBean 생성");
		this.dataBean1 = dataBean1;
		this.dataBean2 = dataBean2;
	}
	
	// 일반 메소드
	public void default_init() {
		
		System.out.println("디폴트 초기화 함수 호출");
	}
	
	public void default_destroy() {
		
		System.out.println("디폴트 파괴자 함수 호출");
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
	
	// getter/setter
	public int getData1() {
		return data1;
	}

	public void setData1(int data1) {
		this.data1 = data1;
	}

	public double getData2() {
		return data2;
	}

	public void setData2(double data2) {
		this.data2 = data2;
	}

	public String getData3() {
		return data3;
	}

	public void setData3(String data3) {
		this.data3 = data3;
	}

	public DataBean getDataBean1() {
		return dataBean1;
	}

	public void setDataBean1(DataBean dataBean1) {
		this.dataBean1 = dataBean1;
	}

	public DataBean getDataBean2() {
		return dataBean2;
	}

	public void setDataBean2(DataBean dataBean2) {
		this.dataBean2 = dataBean2;
	}

	
}
