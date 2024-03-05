package kr.s21.object.util;

import java.util.Calendar;

public class CalendarMain01Practice {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);

		System.out.printf("%d년 %d월 %d일 ", year, month, date);

		int day = today.get(Calendar.DAY_OF_WEEK); //1~7
		String[] days = { "일", "월", "화", "수", "목", "금", "토" };

		System.out.printf("%s요일", days[day - 1]);
	}
}
