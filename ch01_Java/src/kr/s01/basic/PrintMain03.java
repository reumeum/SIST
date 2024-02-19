package kr.s01.basic;

public class PrintMain03 {

	public static void main(String[] args) {
		// 문자 : 한 문자
		System.out.println('A'); // ''(작은 따옴표)는 출력이 안되는 특수문자 <=> 일반문자
		System.out.println('강');

		// 문자열에 '' 사용할 수 없음
		// System.out.println('도시');

		// 문자열 : 한 문자 이상의 문자들
		System.out.println("Z");
		System.out.println("city");
		System.out.println("한강");

		// 숫자(정수)
		System.out.println(123); // 숫자(연산 가능)
		System.out.println("123"); // 문자열(연산 불가능)

		// 숫자(실수)
		System.out.println(3.14);
		System.out.println("3.14"); // 문자열

		// 논리값(boolean)
		System.out.println(true);
		System.out.println(false);
		System.out.println("true"); // 문자열
	}

}
