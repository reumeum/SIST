package kr.s07.object.method;

import java.util.Scanner;

public class MethodMain03 {
	/*
	 * [실습]
	 * 배열의 요소 수를 입력 받아서 배열 x 생성
	 * 입력받은 정수를 배열 x에 저장하고
	 * 배열 x가 가진 모든 요소의 합을 구하는 sumOf(int[] a) 메서드를 작성하시오.
	 * 
	 * [입력 예시]
	 * 요소 수: 5
	 * x[0] = 1
	 * x[1] = 2
	 * x[2] = 3
	 * 
	 * [결과 예시]
	 * 모든 요소의 합은 6입니다.
	 */
	
	public int sumOf(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("요소 수: ");
		int n = input.nextInt();
		
		// n개의 요소를 가지는 배열
		int[] x = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("x[" + i + "]= ");
			x[i] = input.nextInt();
		}
		
		// 객체 선언 및 생성
		MethodMain03 m = new MethodMain03();
		
		int sum = m.sumOf(x);
		
		System.out.println("모든 요소의 합은 " + sum + "입니다.");
		
		input.close();
		
	}
}
