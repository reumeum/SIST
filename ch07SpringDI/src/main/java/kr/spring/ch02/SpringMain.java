package kr.spring.ch02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		//applicationContext.xml 설정파일을 읽어들여 스프링 컨테이너를 생성	
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//객체를 컨테이너로부터 읽어옴
		StudentBean studentBean = (StudentBean)context.getBean("studentBean"); //getBean 메서드는 Object 타입을 반환하므로 다운캐스팅
		
		studentBean.study("스프링");
		
		//어플리케이션 종료시 컨테이너에 존재하는 모든 빈(객체)를 종료
		context.close();
	}
}
