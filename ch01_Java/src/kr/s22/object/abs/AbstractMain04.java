package kr.s22.object.abs;

// 추상클래스
abstract class AbsEx {
	int a = 100; // 변수
	public int getA() {  // 일반 메서드
		return a;
	}
	
	// 추상메서드
	abstract public int getB();
	abstract public int getC();
}

//추상클래스
abstract class AbsEx2 extends AbsEx {
	//추상클래스를 추상클래스에 상속하면 추상메서드 구현의 의무가 없음
	
}

public class AbstractMain04 {
	public static void main(String[] args) {
		
	}
}
