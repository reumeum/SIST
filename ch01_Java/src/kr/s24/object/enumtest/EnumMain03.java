package kr.s24.object.enumtest;

enum Gender {
	MALE, FEMALE;
	// 아래에 메서드가 있는 경우에는 세미콜론 생략 불가

	@Override
	public String toString() {
		switch (this) {
		case MALE:
			return "남자";
		default:
			return "여자";
		}
	}
}

public class EnumMain03 {
	public static void main(String[] args) {
		System.out.println(Gender.MALE);
		System.out.println(Gender.FEMALE);
		System.out.println("-----------------");

		System.out.println(Gender.MALE.toString());
		System.out.println(Gender.FEMALE.toString());
	}
}
