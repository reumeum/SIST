package kr.s21.object.util;

import java.util.Calendar;

public class CalendarMain01 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		
		int year = today.get(Calendar.YEAR);  //연도
		int month = today.get(Calendar.MONTH) + 1;  //월 (MONTH 상수는 0~11을 반환함)
		int date = today.get(Calendar.DATE);  //날짜
		
		System.out.printf("%d년 %d월 %d일 ", year, month, date);
		
		int day = today.get(Calendar.DAY_OF_WEEK); //요일 (DAY_OF_WEEK 상수는 1~7을 반환)
		String days[] = {"일", "월", "화", "수", "목", "금", "토"};
		
		System.out.print(days[day-1]+"요일 ");
		
		int amPm = today.get(Calendar.AM_PM);  //오전 0, 오후 1
		String str = amPm == Calendar.AM ? "오전" : "오후";
		
		int hour = today.get(Calendar.HOUR);
		int min = today.get(Calendar.MINUTE);
		int sec = today.get(Calendar.SECOND);
		
		System.out.printf("%s %d시 %d분 %02d초", str, hour, min, sec);
		
		
	}
}
