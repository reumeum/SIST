package kr.s03.operation;

import java.util.*;

public class IfMain07 {
	public static void main(String[] args) {
		/*
		 * [실습] 생년월일을 입력하고 만 나이를 출력하는 프로그램을 작성하시오. 만 나이 = (현재 연도 - 태어난 연도) - (생일이 지났으면
		 * 0, 생일이 지나지 않았으면 1) [입력 예시] 출생 연도 입력:2000 월 입력:3 입 입력:12
		 * 
		 * [출력 예시] 만 나이는 23
		 */
		// 현재 날짜 정보
		int nowYear = 2024;
		int nowMonth = 2;
		int nowDate = 21;

		Scanner input = new Scanner(System.in);
		System.out.print("출생 연도 입력: ");
		int birthYear = input.nextInt();
		System.out.print("월 입력: ");
		int birthMonth = input.nextInt();
		System.out.print("일 입력: ");
		int birthDate = input.nextInt();

		int age;
		if (birthMonth < nowMonth || (birthMonth == nowMonth && birthDate <= nowDate)) {
			age = nowYear - birthYear;
		} else {
			age = nowYear - birthYear - 1;
		}
		
		System.out.println("만 나이는 " + age);
		
		input.close();
		
	}
}
