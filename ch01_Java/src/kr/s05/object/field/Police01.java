package kr.s05.object.field;

public class Police01 {
	// 멤버 필드(속성) <- 클래스 영역에 만드는 것
	String name;
	int age;
	
	public static void main(String[] args) {
		// 객체 선언 및 생성
		Police01 police = new Police01();
		
		// 객체의 멤버 변수에 값 할당 
		police.name = "김경찰"; 
		police.age = 32; 
		
		// 객체의 멤버 변수에 저장된 값 읽기
		System.out.println("경찰의 이름 : " + police.name);
		System.out.println("경찰의 나이 : " + police.age);
	}
}