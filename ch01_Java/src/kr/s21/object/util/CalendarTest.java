package kr.s21.object.util;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today);

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		int day = today.get(Calendar.DAY_OF_WEEK) - 1;

		String[] days = { "일", "월", "화", "수", "목", "금", "토" };

		System.out.printf("%d년 %d월 %d일 %s요일", year, month, date, days[day]);
	}
}
