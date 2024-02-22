package kr.s03.operation;

public class DoWhileMain {
	public static void main(String[] args) {
		int su = 0;
		String str = "Hello World!";
				
		// 선 처리, 후 비교
		do {
			System.out.println(str);
		} while(su++ < 5);
		System.out.println("---------------------");
		
		
		int su2 = 0;
		
		// 선 비교, 후 처리
		while(su2++ < 5) {
			System.out.println(str);
		}
		System.out.println("---------------------");
	}
}
