package kr.spring.ch10;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		PerformanceMonitor monitor = (PerformanceMonitor)context.getBean("performanceMonitor");
		System.out.println(monitor);
		
		context.close();
	}
}
