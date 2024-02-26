package kr.s07.object.method;

class Worker {
	/*
	 * [실습]
	 * Worker class 정의
	 * 1) 멤버 변수 : 직원 이름(name), 급여(money), 계좌 잔고(balance)
	 * 2) 멤버 메서드 : work(실행하면 money에 1000원을 누적)
	 *                  deposit(실행하면 money에 저장된 돈을 balance에 누적시키고 money는 0 처리)
	 *                  
	 * WorkerMain의 main
	 * 1) Worker 객체 생성
	 * 2) 직원의 이름 지정
	 * 3) 10번 일하는데 번 돈이 3000원일 때마다 계좌에 저축
	 * 4) 직원 이름, 현재 계좌에 입금되지 않고 남아 있는 급여(money),
	 *    계좌 잔고(balance)를 출력하시오.
	 */

	String name;
	int money;
	int balance;

	// 일하는 메서드
	public void work() {
		money += 1000;
	}

	// 저축하는 메서드
	public void deposit() {
		balance += money;
		System.out.println(money + "원을 계좌에 입금했습니다.");
		money = 0;
	}
}

public class WorkerMain {
	public static void main(String[] args) {
		Worker w1 = new Worker();
		w1.name = "아담 온드라";

		// 10번 일하는데 번 돈이 3000원이 되면 저축
		for (int i = 0; i < 10; i++) {
			w1.work();
			if (w1.money >= 3000) { // or w1.money == 0;
				w1.deposit();
			}
		}

		System.out.println("직원 이름: " + w1.name);
		System.out.printf("남은 급여: %,d원%n", w1.money);
		System.out.printf("계좌 잔고: %,d원%n", w1.balance);
		
	}
}
