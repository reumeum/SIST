package kr.s08.object.method;

import java.util.Scanner;

class Account {
	// 멤버 변수
	String account_num; // 계좌번호
	String name; // 예금주
	int balance; // 잔고

	// 멤버 메서드
	// 예금하기
	public void deposit(int money) {
		balance += money;
	}

	// 출금하기
	public void withdraw(int money) {
		if (balance >= money) {
			balance -= money;			
		}
	}

	// 계좌 정보 출력하기
	public void printAccount() {
		System.out.println("계좌번호: " + account_num);
		System.out.println("예금주: " + name);
		System.out.printf("잔고: %,d원%n", balance);
	}
}

public class BankMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// 계좌 생성
		Account account = new Account();

		// 계좌 기본 정보 입력
		System.out.println("계좌 기본정보를 입력해서 계좌를 생성합니다.");
		System.out.print("계좌번호: ");
		account.account_num = input.nextLine();
		System.out.print("예금주: ");
		account.name = input.next();
		System.out.print("예금액: ");
		account.balance = input.nextInt();

		System.out.println(account.name + "님 계좌가 개설되었습니다.");

		while (true) {
			System.out.println("--------------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 확인 | 4. 종료");
			System.out.println("--------------------------------------------");
			System.out.print("메뉴 선택> ");
			int menu = input.nextInt();

			if (menu == 1) {   // 예금
				System.out.print("예금할 금액: ");
				account.deposit(input.nextInt());
			} else if (menu == 2) {    // 출금
				System.out.print("출금할 금액: ");
				int money = input.nextInt();
				if (account.balance < money) {
					System.out.println("잔고가 부족합니다.");
				}
				account.withdraw(money);
			} else if (menu == 3) {    // 잔고 확인
				account.printAccount();
			} else if (menu == 4) {    // 종료
				System.out.println("프로그램 종료");
				break;
			} else {   // 잘못 입력
				System.out.println("잘못 입력했습니다.");
			
			}
		}

		input.close();

	}
}
