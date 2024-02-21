package kr.s03.operation;

import java.util.*;

public class SwitchMain01 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("정수형 숫자 입력: ");
		int a = input.nextInt();

		// 스위치의 인자값은 long형을 제외한 정수형 (byte, short, int)
		// char, 문자열 사용 가능
		// 인자값과 조건값이 일치하는지 여부를 체크
		switch (a) {
		case 1:
			System.out.println("1.입력");
			break; // 수행문을 실행한 후 switch 블럭을 빠져나감
		case 2:
			System.out.println("2.입력");
			break;
		case 3:
			System.out.println("3.입력");
			break;
		default:
			System.out.println("1,2,3이 아닌 숫자 입력");

		}

		input.close();
	}
}
