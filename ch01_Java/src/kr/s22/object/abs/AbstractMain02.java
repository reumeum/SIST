package kr.s22.object.abs;

abstract class A2 {
	private int x;
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	//추상메서드
	public abstract void make(); // 중괄호가 없음 -> 형식만 존재하고 내용이 없음
}

//자식클래스
class B2 extends A2 {
	// 부모클래스의 추상메서드를 구현
	@Override
	public void make() {
		System.out.println("make!");
	}
}

public class AbstractMain02 {
	public static void main(String[] args) {
		B2 bp = new B2();
		bp.make();
	}
}
