package kr.spring.ch19;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContextScan.xml");
		
		HomeController home = (HomeController)context.getBean("home");
		System.out.println(home);
		
		context.close();
	}
}
