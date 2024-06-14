package kr.spring.ch07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//applicationContext2.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		RegisterService service = (RegisterService)context.getBean("registerService");
		
		service.write();
		
		context.close();
	}
}
