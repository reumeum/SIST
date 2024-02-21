package kr.s03.operation;

public class WhileMain02 {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		
		while (i <= 100) {
			sum += i++;
		}
		
		System.out.println("1부터 100까지의 합: " + sum);
	}
}
