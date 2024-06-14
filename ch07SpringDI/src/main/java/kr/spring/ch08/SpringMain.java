package kr.spring.ch08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		WorkController work = (WorkController)context.getBean("work");
		System.out.println(work);
		
		context.close();
	}
}
