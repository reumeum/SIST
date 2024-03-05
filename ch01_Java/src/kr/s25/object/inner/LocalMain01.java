package kr.s25.object.inner;

public class LocalMain01 {
	public void innerTest() {
		// 로컬 내부클래스 : 메서드 내에 클래스를 정의
		class Inner {
			public void getData() {
				System.out.println("Local 내부클래스");
			}
		}
		
		// 내부클래스 객체 생성
		Inner in = new Inner();
		in.getData();
	}
	
	public static void main(String[] args) {
		LocalMain01 local = new LocalMain01();
		local.innerTest();
	}
}
