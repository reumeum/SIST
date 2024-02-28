package kr.s17.object.overriding;

// 부모클래스
class GrandParent {
	public String getCar() {
		return "구형 자동차";
	}
}

// 자식클래스
class Father extends GrandParent {
	// Methbod Overriding (메서드 재정의)
	// 상속 관계에서 자식클래스에 메서드 재정의를 하면 부모클래스의 메서드가
	// 호출되는 것이 아니라 자식클래스의 메서드가 호출됨
	// @Override 어노테이션은 메서드 재정의 문법에 맞게 재정의가 되었는지를 검증하는 역할 수행
	// 문법에 맞게 재정의 되지 않으면 컴파일 오류가 발생
	
	@Override
	public String getCar() {
		return "신형 자동차";
	}
}

class Uncle extends GrandParent {

}

public class OverridingMain01 {
	public static void main(String[] args) {
		Father ft = new Father();
		System.out.println("아버지는 " + ft.getCar() + "를 좋아해요!!");
	
		Uncle un = new Uncle();
		System.out.println("삼촌은 " + un.getCar() + "를 좋아해요~~");
	}
}
