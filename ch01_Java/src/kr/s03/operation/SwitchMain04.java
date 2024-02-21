package kr.s03.operation;

import java.util.*;

public class SwitchMain04 {
	public static void main(String[] args) {
		/*
		 * [실습] 두 개의 정수와 연산자를 입력한 후 연산의 결과를 출력하시오.
		 * 
		 * [입력 예시] 첫번째 수: 10 연산자: + 두번째 수: 20
		 * 
		 * [출력 예시] 10 + 20 = 30
		 */

		Scanner input = new Scanner(System.in);

		System.out.print("첫번째 수: ");
		int a = input.nextInt();

		System.out.print("연산자: ");
		String operator = input.next();

		System.out.print("두번째 수: ");
		int b = input.nextInt();

		int result = 0;

		switch (operator) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "*":
			result = a * b;
			break;
		case "/":
			if (b == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				System.exit(0);
			}
			result = a / b;
			break;
		case "%":
			if (b == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				System.exit(0);
			}
			result = a % b;
			break;
		default:
			System.out.print("연산자는 +, -, *, /, %만 입력 가능합니다.");
			System.exit(0);
		}

		System.out.println();
		System.out.printf("%d %s %d = %d", a, operator, b, result);

		input.close();
	}
}
