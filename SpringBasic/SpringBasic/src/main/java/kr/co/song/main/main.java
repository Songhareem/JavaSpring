package kr.co.song.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.song.beans.TestBean;
import kr.co.song.lecture.lecture;
import kr.co.song.lecture.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		lecture lec = new lecture_7();
		lec.run();
	}
}
