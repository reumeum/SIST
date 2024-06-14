package kr.spring.ch15;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
		
		SystemMonitor monitor = (SystemMonitor)context.getBean("systemMonitor");
		System.out.println(monitor);
		
		context.close();
	}
}
