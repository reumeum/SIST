package kr.spring.ch09;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		//DI - XML 네임스페이스를 이용한 프로퍼티 설정
		UploadController upload = (UploadController)context.getBean("upload");
		System.out.println(upload);
		
		context.close();
	}
}
