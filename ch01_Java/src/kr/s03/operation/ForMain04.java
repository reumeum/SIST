package kr.s03.operation;

import java.util.*;

public class ForMain04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("단 입력: ");
		int dan = input.nextInt();

		System.out.println("dan" + "단"
		);
		System.out.println("---------------------------");
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "*" + i + "=" + dan*i);
		}
		

		input.close();
	}
}
