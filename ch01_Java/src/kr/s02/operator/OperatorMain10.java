package kr.s02.operator;

public class OperatorMain10 {
	public static void main(String[] args) {
		System.out.println("===조건 (삼항) 연산자===");
		int a = 5, b =10;
		int max, min;
		
		// 최대값 구하기
		max = a > b ? a : b;
		// 최소값 구하기
		min = a < b ? a : b;
		
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		

	}
}
