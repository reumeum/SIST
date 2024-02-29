package kr.s17.object.overriding;

public class BankAccount {
	protected String number;
	protected String password;
	protected String name;
	protected long balance;

	// 생성자
	public BankAccount(String number, String password, String name, long balance) {
		// 멤버변수 = 지역변수
		this.number = number;
		this.password = password;
		this.name = name;
		this.balance = balance;
		System.out.println(number + " 계좌가 개설되었습니다.");
	}

	// 예금하기
	public void deposit(long amount) {
		if (amount <= 0) {
			System.out.println("0 이하의 금액은 입금할 수 없습니다.");
			return;
		}
		balance += amount;
		System.out.printf("%,d원이 입금되었습니다.%n", amount);
	}

	// 출금하기
	public void withdraw(long amount) {
		if (amount <= 0) {
			System.out.println("0 이하의 금액은 출금할 수 없습니다.");
			return;
		} else if (balance < amount) {
			System.out.println("잔고가 부족합니다.");
			return;
		}
		balance -= amount;
		System.out.printf("%,d원이 출금되었습니다.%n", amount);
	}
	
	// 계좌 정보 출력하기
	public void printAccount() {
		System.out.println("(일반)계좌번호: " + number);
		System.out.println("비밀번호: " + password);
		System.out.println("예금주: " + name);
		System.out.printf("계좌잔액: %,d원%n", balance);
		System.out.println("------------------------");
	}
}
