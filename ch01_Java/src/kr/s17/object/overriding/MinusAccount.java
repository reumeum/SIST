package kr.s17.object.overriding;

public class MinusAccount extends BankAccount {
	/*
	 * [실습]
	 * 1. BannkAccount를 상속 받는다.
	 * 2. 한도를 의미하는 MinusLimit 멤버변수 정의
	 * 3. 생성자에서 number, password, name, balance, minusLimit를 저장받아서
	 *    멤버변수에 저장.
	 * 4. withdraw, printAccount 메서드 재정의
	 */

	private long minusLimit;

	// 생성자
	public MinusAccount(String number, String password, String name, long balance, long minusLimit) {
		super(number, password, name, balance);
		this.minusLimit = minusLimit;
	}

	// 출금하기
	@Override
	public void withdraw(long amount) {
		if (amount <= 0) {
			System.out.println("0 이하의 금액은 출금할 수 없습니다.");
			return;
		}
		if (balance + minusLimit < amount) {
			System.out.println("한도 초과로 출금되지 않습니다.");
			return;
		}
		balance -= amount;
		System.out.printf("%,d원이 출금되었습니다.%n", amount);
	}

	// 계좌 정보 출력하기
	@Override
	public void printAccount() {
		System.out.println("(마이너스)계좌번호: " + number);
		System.out.println("비밀번호: " + password);
		System.out.println("예금주: " + name);
		System.out.printf("계좌잔액: %,d원%n", balance);
		System.out.printf("마이너스 한도: %,d원%n", minusLimit);
		System.out.println("------------------------");
	}
}
