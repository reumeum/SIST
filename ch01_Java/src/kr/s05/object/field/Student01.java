package kr.s05.object.field;

// 속성만 가지고 객체 만들기

public class Student01 {
	// 멤버 필드(속성)
	String name;
	int age;
	
	public static void main(String[] args) {
		// 객체 선언
		Student01 student;
		// 자료형
		
		// 객체 생성(메모리에 생성됨. student 참조변수에 객체의 주소 넣어주기) 
		student = new Student01();
		               // 생성자

		// 객체의 멤버 변수에 값 할당
		student.name = "홍길동";
		student.age = 21; // student 참조변수 안에 객체의 주소가 들어있어서 닷 연산자를 통해 접근

		// 객체의 멤버 변수에 저장된 값을 출력
		System.out.println("학생의 이름: " + student.name);
		System.out.println("학생의 나이: " + student.age);
	}
}
