package kr.s01.basic;

public class VariableMain02 {

	public static void main(String[] args) {
		/*
		 * [실습]
		 * 정수를 담을 수 있는 변수를 3개 지정한다.
		 * 변수명은 각각 a, b, c로 지정하고 원하는 정수로 초기화한다.
		 * a + b 연산 후 출력할 때  
		 * 
		 * [출력 예시]
		 * 결과 = 50 형식으로 출력한다.
		 * 
		 * c에 저장된 데이터를 80으로 변경해서
		 * 
		 * c = 80 형식으로 출력한다.
		 */
		
		int a = 10, b = 20, c = 30;
		int result = a + b + c;
		
		
		System.out.println("결과 = " + result);
		System.out.println("----------------------");
		
		c = 80;
				
		System.out.println("c = " + c);		
	}

}
