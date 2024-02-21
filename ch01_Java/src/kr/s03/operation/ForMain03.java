package kr.s03.operation;

public class ForMain03 {
	public static void main(String[] args) {
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		
		System.out.println("1부터 100까지의 합: " + sum);
		System.out.println("--------------------------------");
		
		int sumEven = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i%2 == 0) {
				sumEven += i;
			}
		}
		
		System.out.println("1부터 100까지 짝수의 합: " + sumEven);
	}
}
