package kr.s05.object.field;

public class Student05 {
	String name;
	int korean;
	int english;
	int math;
	int sum;
	double average;
	
	public static void main(String[] args) {
		// 객체 선언 및 생성
		Student05 s1 = new Student05();
		s1.name = "홍길동";
		s1.korean = 98;
		s1.english = 97;
		s1.math = 95;
		// 총점 구하기
		s1.sum = s1.korean + s1.english + s1.math;
		// 평균 구하기
		s1.average = s1.sum / 3.0;
		
		// 객체의 멤버 변수의 값 출력
		System.out.println("이름: " + s1.name);
		System.out.println("국어: " + s1.korean);
		System.out.println("영어: " + s1.english);
		System.out.println("수학: " + s1.math);
		System.out.println("총점: " + s1.sum);
		System.out.printf("평균: %.2f", s1.average);
	}
}
