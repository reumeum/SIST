package kr.s23.object.inter;

//인터페이스 : 형식만 있고 내용이 없음
interface A2{
	//추상메서드
	public abstract void abc();//원형
	void def();
}

class B2 implements A2{
	//인터페이스의 추상메서드를 구현
	@Override
	public void abc() {
		System.out.println("abc 메서드");
	}
	@Override
	public void def() {
		System.out.println("def 메서드");
	}
}

public class InterfaceMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.abc();
		bp.def();
	}
}



