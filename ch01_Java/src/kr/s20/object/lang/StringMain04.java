package kr.s20.object.lang;

import java.util.Scanner;

public class StringMain04 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 입력받은 문자열을 한 문자씩 읽어서 역순으로 표시
		 * 
		 * [입력 예시]
		 * 문자열: Hello
		 * 
		 * [출력 예시]
		 * olleH
		 */

		Scanner input = new Scanner(System.in);
		System.out.print("문자열: ");
		String str = input.nextLine();

		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}

		System.out.println(result);
		
		input.close();
	}
}
