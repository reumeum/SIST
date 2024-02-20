package kr.s02.operator;

import java.util.*;

public class OperatorMain15 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 3개의 정수를 입력받아서 최대값, 최소값을 출력하는 프로그램을 작성하시오.
		 * 
		 * [입력 예시]
		 * 첫번째 정수: 10
		 * 두번째 정수: 5
		 * 세번째 정수: 7
		 * 
		 * [출력 예시]
		 * 최대값: 10
		 * 최소값: 5
		 */
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("첫번째 정수: ");
		int a = input.nextInt();
		System.out.print("두번째 정수: ");
		int b = input.nextInt();
		System.out.print("세번째 정수: ");
		int c = input.nextInt();
		System.out.println();
		
		// 최대값 구하기
		int max; // 최대값을 저장할 변수 선언
		max = a > b ? a : b;
		max = max > c ? max : c;
		
		// 최소값 구하기
		int min; // 최소값을 저장할 변수 선언
		min = a < b ? a : b;
		min = min < c ? min : c;
		
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
		
		input.close();
	}
}
