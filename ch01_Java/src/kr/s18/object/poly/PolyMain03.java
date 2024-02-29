package kr.s18.object.poly;

// 부모클래스
class Parent2 {
	public void make() {
		System.out.println("부모클래스의 make");
	}
}

// 자식클래스
class Child2 extends Parent2 {
	//메서드 재정의
	@Override
	public void make() {
		System.out.println("자식클래스의 make");
	}
}

public class PolyMain03 {
	/*
	 * 다형성(Polymorphism)
	 * 객체지향에서 다형성이란 '여러 가지 형태를 가질 수 있는 능력'을 의미하며,
	 * 자바에서는 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함으로써 다형성을 프로그래밍적으로 구현
	 * 부모클래스타입의 참조변수로 자식클래스의 인스턴스를 참조할 수 있도록 하였음
	 */
	public static void main(String[] args) {
		Child2 ch = new Child2();
		ch.make();
		
		Parent2 p = ch;  // 자식클래스타입 -> 부모클래스타입 형변환
		                 // 업캐스팅, 자동적으로 형변환
		p.make();   // 재정의된 자식클래스의 make()가 호출됨
	}
}
