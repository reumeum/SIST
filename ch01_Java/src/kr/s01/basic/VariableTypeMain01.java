package kr.s01.basic;

public class VariableTypeMain01 {
	public static void main(String[] args) {
		System.out.println("=========논리형=========");
		// 논리형(true, false)
		boolean b = true;
		System.out.println("b = " + b);

		System.out.println("=========문자형=========");
		// 문자형, 크기 : 2Byte(16bit), 표현범위 : 0 ~ 65,535
		// 다국어 처리를 위한 유니코드 (unicode) 방식
		char c1 = 'A'; // 내부적으로 아스키코드값 65가 2Byte로 변수 c1에 담김
		System.out.println("c1 = " + c1);
		char c2 = 65; // A에 해당되는 아스키코득값 65를 직접 대입
		System.out.println("c2 = " + c2);
		char c3 = '\u0041'; // A를 의미하는 유니코드
		System.out.println("c3 = " + c3);
		char c4 = '자';
		System.out.println("c4 = " + c4);
		char c5 = '\uc790'; // 자를 의미하는 유니코드
		System.out.println("c5 = " + c5);

		System.out.println("=========정수형=========");
		// byte, 크기 : 1Byte, 표현범위 : -128 ~ 127
		byte b1 = 127;
		System.out.println("b1 = " + b1);
		// short, 크기 : 2Byte, 표현범위 : -32,768 ~ 32,767
		short s1 = 32767;
		System.out.println("s1 = " + s1);
		// int, 크기 : 4Byte, 표현범위 : -2,147,483,648 ~ 2,147,483,647 (-20억대 ~ 20억대)
		int in = 1234;
		System.out.println("in = " + in);
		// long, 크기 : 8Byte
		long lg = 1234L; // L은 long형 데이터라는 것을 의미 (자바 시스템한테 알려주는 것)
		System.out.println("lg = " + lg);

		System.out.println("=========실수형=========");
		// float, 크기 : 4Byte
		float f1 = 9.1f; // f는 float형 데이터라는 것을 의미
		System.out.println("f1 = " + f1);
		// double, 크기 : 8Byte
		double du = 9.8;
		System.out.println("du = " + du);
		
		System.out.println("=========문자열 표시=========");
		// 문자열 표시 (기본자료형이 아님, 참조자료형)
		String str = "Hello world!";
		System.out.println("str = " + str);
		

		
	}
}
