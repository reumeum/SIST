package kr.s20.object.util;

import java.text.DateFormat;
import java.util.Date;

public class DateMain {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toString());
		System.out.println("---------------------");
		//deprecated되어 사용하지 않음
		System.out.println(now.toLocaleString());
		System.out.println("---------------------");
		
		DateFormat df = DateFormat.getInstance();
		String today = df.format(now);
		System.out.println(today);
		System.out.println("---------------------");
	}
}
