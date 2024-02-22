package kr.s03.operation;

import java.util.Scanner;

public class CoffeeMain02 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// 커피 정보
		int price = 400;

		// 커피 한 잔에 들어갈 양
		int contentCoffee = 5;
		int contentCream = 3;
		int contentSugar = 1;

		// 커피에 들어갈 재료의 현재 보유량
		int coffeeLeft = 10;
		int creamLeft = 10;
		int sugarLeft = 10;

		// 투입한 금액 누적
		int amount = 0;

		// 자판기 보유 동전
		int coin = 1000;

		while (true) {
			System.out.println("1. 커피 주문하기 | 2. 종료");
			System.out.print("메뉴 선택> ");
			int menu = input.nextInt();
			if (menu == 1) {
				System.out.print("동전을 넣으세요(커피값 " + price + "원): ");
				int payment = input.nextInt();

				// 거스름돈 계산
				int change = payment - price;

				//커피 주문이 가능한지 조건 체크
				if (coffeeLeft < contentCoffee) {
					System.out.println("커피가 부족합니다.");
					continue;
				}
				if (creamLeft < contentCream) {
					System.out.println("프림이 부족합니다.");
					continue;
				}
				if (sugarLeft < contentSugar) {
					System.out.println("설탕이 부족합니다.");
					continue;
				}
				if (payment < price) {
					System.out.println("투입한 동전 부족");
					continue;
				}
				if (coin < change) {
					System.out.println("거스름돈 부족");
					continue;
				}

				// 커피 구매가 가능하기 때문에 연산
				coffeeLeft -= contentCoffee; // 커피 차감
				creamLeft -= contentCream; // 크림차감
				sugarLeft -= contentSugar; // 설탕 차감
				coin -= change; // 거스름돈 차감
				amount += payment; // 투입한 금액 누적

				System.out.printf("거스름돈 : %,d원%n", change);
				System.out.println("맛 좋은 커피가 준비되었습니다.");

				System.out.println("======현재 자판기 정보======");
				System.out.printf("커피: %d%n", coffeeLeft);
				System.out.printf("프림: %d%n", creamLeft);
				System.out.printf("설탕: %d%n", sugarLeft);
				System.out.printf("자판기 보유 동전 금액: %,d원%n", coin);
				System.out.printf("투입한 동전 금액: %,d원%n", amount);
				System.out.println("============================");

			} else if (menu == 2) {
				System.out.println("커피 주문을 종료합니다.");
				break;
			} else {
				System.out.println("잘못 입력했습니다. 메뉴를 다시 선택해주세요.");
				continue;
			}
		}

		input.close();
	}
}
