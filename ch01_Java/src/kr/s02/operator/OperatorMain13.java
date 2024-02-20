package kr.s02.operator;

import java.util.Scanner;

public class OperatorMain13 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * 키보드에서 입력한 정수값에 마지막 자릿수를 제외한 값과 마지막 자릿수를 표시하시오.
		 * 
		 * [입력 예시]
		 * 정수값: 123
		 * 
		 * [출력 예시]
		 * 마지막 자릿수를 제외한 값: 12
		 * 마지막 자릿수: 3
		 */
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("정수값: ");
		
		int num = input.nextInt();
		
		int lastDigit = num % 10;
		int otherDigits = num / 10;
		
		System.out.println("마지막 자릿수를 제외한 값: " + otherDigits);
		System.out.println("마지막 자릿수: " + lastDigit);
		
		input.close();
	}

}
