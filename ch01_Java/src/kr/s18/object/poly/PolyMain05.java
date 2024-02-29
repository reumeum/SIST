package kr.s18.object.poly;

// 부모클래스
class Parent3 {
	// Object의 toString 재정의
	@Override
	public String toString() {
		return "Parent3 클래스";
	}
}

// 자식클래스
class Child3 extends Parent3 {
	@Override
	public String toString() {
		return "Child3 클래스";
	}
}

public class PolyMain05 {
	public static void main(String[] args) {
		Parent3 p = new Parent3();
		
		// 컴파일 시 오류는 없지만 실행 시 오류 발생
//		Child3 ch = (Child3) p;
		
		// instanceof 연산자는 상속관계일 때 사용
		// 좌측에 지정한 객체가 우측에 지정한 타입을 사용할 수 있는지 검증하는 연산자
		// 사용 가능하면 true, 사용 불가능하면 false
		// 객체           타입
		if (p instanceof Child3) {
			Child3 ch2 = (Child3) p;
			System.out.println(ch2);
			System.out.println("-----------------");
		} else {
			System.out.println(p);
			System.out.println("+++++++++++++++++");
		}
	}
}
