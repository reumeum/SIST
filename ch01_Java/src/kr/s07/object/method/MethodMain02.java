package kr.s07.object.method;

import java.util.Scanner;

public class MethodMain02 {
	/*
	 * [실습]
	 * 입력한 int형 정수값이 음수이면 -1을, 0이면 0을, 양수이면 1을 반환하는
	 * signOf 메서드를 작성하시오.
	 */

	public int signOf(int x) {
		//		int result;
		//		if (x < 0) {
		//			result = -1;
		//		} else if (x > 0) {
		//			result = 1;
		//		} else {
		//			result =  0;
		//		}

		//		int result = (x < 0) ? -1 : (x > 0) ? 1 : 0;
		//		return result;

		int sign = 0;   // 초기값을 0으로 설정함으로써 else 라인을 생략 가능
		if (x > 0) {
			sign = 1;
		} else if (x < 0) {
			sign = -1;
		}

		return sign;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("정수 x 입력: ");
		int num = input.nextInt();
		
		MethodMain02 m1 = new MethodMain02();

		int sign = m1.signOf(num);
		System.out.println("signOf(x)는 " + sign + "입니다.");
		
		input.close();
		
	}

}
