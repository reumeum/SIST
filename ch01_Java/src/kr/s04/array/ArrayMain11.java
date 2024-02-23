package kr.s04.array;

import java.util.Scanner;

public class ArrayMain11 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * double형인 배열의 모든 요소의 합과 평균을 구하는 프로그램을 작성하시오.
		 * 
		 * [입력 예시]
		 * 요소의 수> 3
		 * a[0] = 2.2
		 * a[1] = 2.2
		 * a[3] = 3.3
		 * 
		 * [출력 예시]
		 * 모든 요소의 합은 7.7입니다. (System.out.println 사용)
		 * 모든 요소의 평균은 2.57입니다. (System.out.printf로 소수점 둘째 자리까지 출력)
		 */
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("요소의 수> ");
		int n = input.nextInt();
		
		double[] a = new double[n];
		
		double sum = 0.0;
		double avg = 0.0;
		
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = input.nextDouble();
			sum += a[i];
		}
		
		avg = sum / n;
		
		System.out.println();
		System.out.println("모든 요소의 합은 " + sum + "입니다.");
		System.out.printf("모든 요소의 평균은 %.2f입니다.%n", avg);
		
		input.close();
	}
}
