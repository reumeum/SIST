package kr.s04.array;

import java.util.Scanner;

public class ArrayMain12 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 단을 입력 받아서 1~9까지 곱하고 결과값을 배열에 저장.
		 * 배열에 저장된 값을 읽어서 구구단 출력 형식 (2 * 1 = 2)으로 출력하시오.
		 * 
		 * [입력 예시]
		 * 단 입력: 2
		 * 
		 * [출력 예시]
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * ...
		 * 2 * 9 = 18
		 */

		Scanner input = new Scanner(System.in);

		System.out.print("단 입력: ");
		int dan = input.nextInt();

		int[] array = new int[9];
		
		System.out.println(dan + "단");
		System.out.println("------------------");

		for (int i = 0; i < array.length; i++) {
			array[i] = dan * (i + 1);
			System.out.printf("%d * %d = %d%n", dan, i + 1, array[i]);
		}

		input.close();
	}
}
