package kr.s07.object.method;

import java.util.Scanner;

public class MethodMain04 {
	/*
	 * [실습]
	 * 배열 요소 수(사람 수)를 입력받아서 배열 weight를 생성.
	 * 입력받은 정수를 배열 weight에 저장하고 배열 weight가 가진
	 * 모든 요소의 수 중 최소값을 구하는 minOf 메서드를 작성하시오.
	 * 
	 * [입력 예시]
	 * 사람 수: 3
	 * 1번의 몸무게: 90
	 * 2번의 몸무게: 88
	 * 3번의 몸무게: 91
	 * 
	 * [출력 예시]
	 * 가장 무게가 적게 나가는 사람의 몸무게는 88kg입니다.
	 */

	public int minOf(int[] x) {
		int min = x[0];
		for (int i = 1; i < x.length; i++) {
			if (x[i] < min) {
				min = x[i];
			}
			
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// 입력 받기
		System.out.print("사람 수: ");
		int n = input.nextInt();

		int[] weight = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print((i + 1) + "번의 몸무게: ");
			weight[i] = input.nextInt();
		}

		// 객체 선언 및 생성
		MethodMain04 m = new MethodMain04();

		int min = m.minOf(weight);

		System.out.println("가장 무게가 적게 나가는 사람의 몸무게는 " + min + "kg입니다.");

		input.close();
		
	}
}
