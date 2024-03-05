package kr.s25.object.inner;

public class LocalMain02 {
	// 멤버 변수
	int a = 100;
	
	// 멤버 메서드
	public void innerTest() {
		int b = 500;  //지역변수
		
		// 로컬 내부클래스
		class Inner {
			public void getData() {
				//멤버 변수 호출
				System.out.println("변경 전 : " + a);
				a = 200;
				System.out.println("변경 후 : " + a);
				System.out.println("-------------------");
				
				//지역 변수 호출
				System.out.println("지역 변수 변경 전 : " + b);
				// 로컬 내부클래스가 포함된 메서드의 지역 변수를 호출할 때
				// 자동으로 상수화가 진행되어 데이터를 변경할 수 없음
				// b = 1000;
			}
		}
		
		// 내부클래스 객체 생성
		Inner i = new Inner();
		i.getData();
	}
	
	public static void main(String[] args) {
		LocalMain02 lm = new LocalMain02();
		lm.innerTest();
	}
}
