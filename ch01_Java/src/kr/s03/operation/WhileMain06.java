package kr.s03.operation;

import java.util.*;

public class WhileMain06 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a, total = 0;
		System.out.println("0전까지 입력받은 정수로 합 구하기");
		
		while(true) {
			System.out.print("누적할 정수 입력: ");
			a = input.nextInt();
			
			if (a == 0)
				break;
			
			total += a;
		}
		
		System.out.println("누적된 정수의 합: " + total);
		
		
		input.close();
	}
}
