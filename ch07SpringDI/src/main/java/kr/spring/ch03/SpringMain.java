package kr.spring.ch03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//applicationContext.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		OperatorBean bean = (OperatorBean)context.getBean("operatorBean");
		int result = bean.add(10, 7);
		System.out.println("결과: " + result);
		
		context.close();
	}
}
