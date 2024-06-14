package kr.spring.ch06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//applicationContext.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//DI 생성자 설정방식 - 여러개의 인자 사용
		SystemMonitor monitor = (SystemMonitor) context.getBean("monitor");
		
		System.out.println(monitor);
		
		context.close();
		
	}
}
