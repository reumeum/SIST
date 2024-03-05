package kr.s25.object.inner;

class Inner7 {
	public void disp() {
		System.out.println("부모클래스의 disp");
	}
}

public class AnonymousMain {
	public void make() {
		// 익명 내부클래스
		// Inner7 클래스가 상속된 이름 없는 클래스를 객체 생성
		Inner7 i = new Inner7() {
			@Override
			public void disp() {  //클래스 정의부
				System.out.println("익명 내부클래스의 disp");
			}
		};
		i.disp();
	}

	public static void main(String[] args) {
		AnonymousMain am = new AnonymousMain();
		am.make();
	}
}
