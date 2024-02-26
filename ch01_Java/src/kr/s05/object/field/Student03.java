package kr.s05.object.field;

public class Student03 {
	// 멤버 필드(속성)
	String name;
	int age;
	String hobby;
	String job;

	public static void main(String[] args) {
		Student03 student = new Student03();

		// 객체의 멤버 변수에 값할당
		student.name = "홍길동";
		student.age = 20;
		student.hobby = "축구";
		student.job = "대학생";

		// 객체의 멤버 변수의 값 출력
		System.out.println(student.name + ", " + student.age + ", " + student.hobby + ", " + student.job);
		System.out.println("---------------------------");

		Student03 student2 = new Student03();

		student2.name = "박문수";
		student2.age = 39;
		student2.hobby = "야구";
		student2.job = "대학원생";
		
		System.out.println(student2.name + ", " + student2.age + ", " + student2.hobby + ", " + student2.job);

		
	}
}
