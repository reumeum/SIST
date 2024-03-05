package kr.s24.object.enumtest;

// 열거형 객체
enum Lesson {
	// 열거형 상수
	// 문자열 상수
	JAVA, XML, JSP
}

public class EnumMain02 {
	public static void main(String[] args) {
		System.out.println(Lesson.JAVA);
		System.out.println(Lesson.XML);
		System.out.println(Lesson.JSP);
		System.out.println("--------------------");

		// 모든 객체는 Object 상속 받음
		System.out.println(Lesson.JAVA.toString());
		System.out.println(Lesson.XML.toString());
		System.out.println(Lesson.JSP.toString());
		System.out.println("--------------------");
		
		// 열거 객체의 문자열을 반환
		System.out.println(Lesson.JAVA.name());
		System.out.println(Lesson.XML.name());
		System.out.println(Lesson.JSP.name());
		System.out.println("--------------------");
		
		// 열거 객체의 순번(0부터 시작)을 반환
		System.out.println(Lesson.JAVA.ordinal());
		System.out.println(Lesson.XML.ordinal());
		System.out.println(Lesson.JSP.ordinal());
	}
}
