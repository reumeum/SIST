package kr.s03.operation;

import java.util.Scanner;

public class CoffeeMain {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 동전을 넣고 커피를 주문하면 커피를 판매하는 자판기 프로그램
		 * 
		 * 자판기는 자판기 보유 동전(1000), 커피(10), 프림(10), 설탕(10)
		 * 을 보유하고 있고 커피를 주문할 때 마다 자판기 보유 동전-거스름돈,
		 * 커피 5, 프림 3, 설탕 1 씩 차감된다. 0이 되면 판매를 중단한다. 
		 * 
		 * [입력 및 출력 예시]
		 * 동전을 넣으세요(커피값: 400원): 500
		 * 거스름돈: 100원
		 * 맛 좋은 커피가 준비되었습니다.
		 * 
		 * or
		 * 
		 * 동전을 넣으세요(커피값: 400원): 300
		 * (고객이 투입한 동전이 커피값보다 작으면) 투입한 동전이 부족합니다.
		 * 
		 * or
		 * 
		 * 동전을 넣으세요(커피값: 400원): 2000
		 * (자판기 보유 동전이 부족하면) 거스름돈이 부족합니다.
		 * 
		 * 동전을 넣으세요(커피값: 400원): 500
		 * (커피가 부족하면) 커피가 부족합니다.
		 * (프림이 부족하면) 프림이 부족합니다.
		 * (설탕이 부족하면) 설탕이 부족합니다.
		 * 
		 * =====현재 자판기 정보=====
		 * 커피 : 5
		 * 프림 : 7
		 * 설탕 : 9
		 * 자판기 보유 동전 금액 : 900원
		 * 투입한 동전 금액 : 500원
		 * ==========================
		 * 
		 */

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
				System.out.print("동전을 넣으세요(커피값: 400원)> ");
				int insertedMoney = input.nextInt();
				int change = insertedMoney - price;

				// 투입한 동전이 부족할 때
				if (insertedMoney < price) {
					System.out.println("투입한 동전이 부족합니다.");
					continue;
				}

				// 거스름돈이 부족할 때
				if (coin - change < 0) {
					System.out.println("거스름돈이 부족합니다.");
					continue;
				}

				// 커피가 부족할 때
				if (coffeeLeft < contentCoffee) {
					System.out.println("커피가 부족하여 자판기를 이용을 종료합니다.");
					break;
				}

				// 프림이 부족할 때
				if (creamLeft < contentCream) {
					System.out.println("프림이 부족하여 자판기를 이용을 종료합니다.");
					break;
				}

				// 설탕이 부족할 때
				if (sugarLeft < contentSugar) {
					System.out.println("설탕이 부족하여 자판기를 이용을 종료합니다.");
					break;
				}

				// 주문 성공
				coffeeLeft -= contentCoffee;
				creamLeft -= contentCream;
				sugarLeft -= contentSugar;
				coin -= change;
				amount += insertedMoney;

				System.out.printf("거스름돈: %,d원%n", change);
				System.out.println("맛 좋은 커피가 준비되었습니다.");

				// 현재 자판기 정보 출력
				System.out.println();
				System.out.println("====현재 자판기 정보====");
				System.out.printf("커피 보유량 : %d%n", coffeeLeft);
				System.out.printf("프림 보유량 : %d%n", creamLeft);
				System.out.printf("설탕 보유량 : %d%n", sugarLeft);
				System.out.printf("자판기 보유 동전 금액 : %,d원%n", coin);
				System.out.printf("투입한 동전 금액 : %,d원%n", amount);
				System.out.println("========================");
				System.out.println();

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
