package kr.s03.operation;

import java.util.Scanner;

public class WhileMain08 {
	public static void main(String[] args) {
		/*
		 * [실습] 커피전문점에서 아메리카노가 4,000원입니다. 마실 커피 수량을 정하고 돈을 지불하세요.
		 * 지불한 돈에서 발생한 거스름돈을 출력하고
		 * 커피의 총 비용보다 지불한 돈이 적어서 커피를 구매할 수 없을 경우 
		 * "금액이 부족합니다."라고 알려준 후 다시 지불할 수 있는 프로그램을 작성하세요. 
		 * (정상적으로 아메리카노를 구매하면 반복문을 빠져나오고 금액이 부족하면 계속 반복)
		 * 
		 * [입력 예시]
		 * 구매 수량 입력: 1
		 * 내가 지불한 금액: 5000
		 * or
		 * 내가 지불한 금액: 3000
		 * 
		 * [출력 예시]
		 * 거스름돈은 1,000원입니다. -> 반복문을 빠져나감(거스름돈 >= 0)
		 * or
		 * 1000원이 부족합니다. -> 계속 반복
		 */

		Scanner input = new Scanner(System.in);

		int price = 4000; // 커피 단가
		int quantity; // 수량
		int balance; // 거스름돈
		int payment; // 지불한 돈
		int total; // 총 지불해야 할 금액

		while (true) {
			System.out.print("구매 수량 입력> ");
			quantity = input.nextInt();

			// 0개 이하의 수량을 입력한 경우
			if (quantity <= 0) {
				System.out.println("1개 이상의 수량을 입력해주세요.");
				continue;
			}

			System.out.print("내가 지불한 금액> ");
			payment = input.nextInt();
			total = price * quantity;
			balance = payment - total;

			// 지불한 금액이 부족하여 커피를 구매할 수 없는 경우
			if (balance < 0) {
				System.out.printf("%,d원이 부족합니다.%n", -balance);
				continue;
			}

			// 정상 구매된 경우
			System.out.println();
			System.out.printf("구매가 완료되었습니다. %n거스름돈은 %,d원입니다.", balance);
			break;

		}

		input.close();
	}
}
