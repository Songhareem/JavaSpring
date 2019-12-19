package kr.co.song.beans;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

//@Component // ComponentBean Type���� Bean���� ���
@Component("lec_15") // "~" ���� Bean ���
public class ComponentBean {

	//==========================
	// ����
	//==========================
	
	/*
	@Autowired
	@Qualifier("id_1")
	private DataBean dataBean1;
	
	@Autowired
	@Qualifier("id_2")
	private DataBean dataBean2;
	*/
	
	private int data1;
	private String data2;
	private DataBean dataBean1;
	private DataBean dataBean2;
	
	//==========================
	// ������
	//==========================
	
	public ComponentBean(
			@Value("100")int data1, 
			@Value("���ڿ�")String data2, 
			DataBean dataBean1, 
			DataBean dataBean2) {
		this.data1 = data1;
		this.data2 = data2;
		this.dataBean1 = dataBean1;
		this.dataBean2 = dataBean2;
	}
	 
	//==========================
	// setter / getter
	//==========================
	
	public int getData1() {
		return data1;
	}


	public String getData2() {
		return data2;
	}

	public DataBean getDataBean1() {
		return dataBean1;
	}
	
	public DataBean getDataBean2() {
		return dataBean1;
	}
}
