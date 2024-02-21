package kr.s03.operation;

import java.util.*;

public class WhileMain03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("단 입력: ");
		int dan = input.nextInt();
		
		System.out.println(dan + "단");
		System.out.println("---------------------");
		
		int i = 1;
		while (i <= 9) {
			System.out.printf("%d * %d = %d%n", dan, i, dan*i++);
		}
		
		
		
		input.close();
	}
}
