package kr.co.song.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
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
	
	@Autowired
	@Qualifier("dataBean3")
	private DataBean dataBean3;
	
	private List<String> list1;
	private List<Integer> list2;
	private List<DataBean> list3;
	
	private Set<String> set1;
	private Set<Integer> set2;
	private Set<DataBean> set3;
	
	private Map<String, Object> map1;
	private Properties prop1;
	
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
	
	public TestBean(int data1, String data2, DataBean data3, DataBean data4) {
		
		this.data1 = data1;
		this.data3 = data2;
		this.dataBean1 = data3;
		this.dataBean2 = data4;
	}
	
	// 일반 메소드
	public void default_init() {
		
		System.out.println("디폴트 초기화 함수 호출");
	}
	
	public void default_destroy() {
		
		System.out.println("디폴트 파괴자 함수 호출");
	}
	
	public void init() {
		
		System.out.println("lec9 init 호출");
	}
	
	public void destroy() {
		
		System.out.println("lec9 destroy 호출");
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
	
	@Autowired
	public void setDataBean1(DataBean dataBean1) {
		this.dataBean1 = dataBean1;
	}

	public DataBean getDataBean2() {
		return dataBean2;
	}

	@Autowired
	public void setDataBean2(DataBean dataBean2) {
		this.dataBean2 = dataBean2;
	}

	// 변수에 @Autowired가 붙었으므로, Setter는 선언하지 않는다
	public DataBean getDataBean3() {
		return dataBean3;
	}

	public List<String> getList1() {
		return list1;
	}

	public void setList1(List<String> list1) {
		this.list1 = list1;
	}

	public List<Integer> getList2() {
		return list2;
	}

	public void setList2(List<Integer> list2) {
		this.list2 = list2;
	}

	public List<DataBean> getList3() {
		return list3;
	}

	public void setList3(List<DataBean> list3) {
		this.list3 = list3;
	}

	public Set<String> getSet1() {
		return set1;
	}

	public void setSet1(Set<String> set1) {
		this.set1 = set1;
	}

	public Set<Integer> getSet2() {
		return set2;
	}

	public void setSet2(Set<Integer> set2) {
		this.set2 = set2;
	}

	public Set<DataBean> getSet3() {
		return set3;
	}

	public void setSet3(Set<DataBean> set3) {
		this.set3 = set3;
	}

	public Map<String, Object> getMap1() {
		return map1;
	}

	public void setMap1(Map<String, Object> map1) {
		this.map1 = map1;
	}

	public Properties getProp1() {
		return prop1;
	}

	public void setProp1(Properties prop1) {
		this.prop1 = prop1;
	}


}
