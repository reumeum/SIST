package kr.s20.object.lang;

public class WrapperMain01 {
	public static void main(String[] args) {
		boolean b = true; // 기본 자료형
		
		// 예전에는 생성자를 이용해서 작업했음
		Boolean wrap_b = new Boolean(b); // 기본 자료형 데이터 -> 참조 자료형 데이터가 된 것
		// 참조 자료형 데이터 -> 기본 자료형 데이터
		boolean b2 = wrap_b.booleanValue();
		System.out.println(b2);
		System.out.println("-------------------");
		
		// 요즘에 하는 방식
		char c = 'A';
		Character wrap_c = c; // 기본 자료형 데이터 -> 참조 자료형 데이터 (직접 대입)
		                      // auto boxing (자동적으로 기본자료형에서 참조자료형이 됐을 때, 캐스팅이라는 말 쓰지 않음)
		// 참조 자료형 데이터 -> 기본 자료형 데이터
		// auto unboxing
		System.out.println(wrap_c);
		
		
	}
}
