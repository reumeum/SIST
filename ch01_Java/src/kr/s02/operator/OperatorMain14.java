package kr.s02.operator;

import java.util.Scanner;

public class OperatorMain14 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * A전자대리점에서는 그날 물건 판매액의 15%를 할인해주기로 했다.
		 * 판매한 상품명과 상품의 단가와 수량을 입력해서 지불 금액을 출력하는 프로그램을 작성하시오.
		 * (단, 출력 시 소수점 이하는 절삭하시오.)
		 * 
		 * [입력 및 출력 예시]
		 * 상품명 입력: 냉장고
		 * 단가 입력: 500000
		 * 판매 수량 입력: 3
		 * 냉장고 3대의 가격은 1,275,000원입니다.
		 */
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("상품명 입력: ");
		String item = input.nextLine();
		
		System.out.println();
		
		input.close();
	}
}
