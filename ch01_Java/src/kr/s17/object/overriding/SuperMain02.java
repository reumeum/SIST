package kr.s17.object.overriding;

// 부모클래스
class People {
	int a = 100;
	
	public People() {
		super(); // 부모클래스 Object의 기본 생성자 호출
	}
}

// 자식클래스
class Student extends People{
	int b = 200;
	
	// 생성자
	public Student() {
		super(); // 부모클래스의 기본 생성자 호출
	}
}

public class SuperMain02 {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.a);
		System.out.println(s.b);
	}
}
