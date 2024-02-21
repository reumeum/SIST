package kr.s03.operation;

import java.util.Scanner;

public class WhileMain07 {
	public static void main(String[] args) {
		// 은행 프로그램
		Scanner input = new Scanner(System.in);
		
		long balance = 0L; // 잔고
		
		while(true) {
			System.out.println("--------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 확인 | 4.종료");
			System.out.println("--------------------------------------");
			
			System.out.print("메뉴 선택> ");
			int menu = input.nextInt();
			
			if (menu == 1) {
				System.out.print("예금할 금액: ");
				long money = input.nextLong();
				balance += money;
				System.out.printf("%,d원이 예금되었습니다.%n", money);
			} else if (menu == 2) {
				System.out.print("출금할 금액: ");
				long money = input.nextLong();
				if (balance < money) {
					System.out.println("잔고가 부족합니다.");
				} else {
					balance -= money;
					System.out.printf("%,d원이 출금되었습니다.%n", money);					
				}
			} else if (menu == 3) {
				System.out.printf("현재 잔고는 %,d원 입니다.%n", balance);
			} else if (menu == 4) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못 입력했습니다.");
			}
		}
		
		
		
		
		input.close();
	}
}
