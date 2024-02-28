package kr.s16.object.extension;

// 부모클래스
class People extends Object {
	public void eat() {
		System.out.println("식사하다");
	}
}

// 자식클래스
class Student extends People {
	public void study() {
		System.out.println("공부하다");
	}
}

public class ExtensionMain02 {
	public static void main(String[] args) {
		Student student = new Student();
		student.eat();  // People의 메서드를 상속받아서 호출
		student.study();  // Student의 메서드
		System.out.println(student.toString()); // Object의 메서드
	}
}
