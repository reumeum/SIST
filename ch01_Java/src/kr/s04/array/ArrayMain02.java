package kr.s04.array;

public class ArrayMain02 {
	public static void main(String[] args) {
		// 정수형 배열 선언 및 생성
		// 배열을 생성하면 배열의 요소로 기본값이 저장됨
		// 정수형 배열은 0을 기본값으로 배열을 생성
		int[] array = new int[5];

		// 반복문을 이용한 요소의 출력
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "]: " + array[i]);
		}

		System.out.println("---------------------");

		// 배열의 요소 변경
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		// array[5] = 60;
		// 없는 인덱스를 호출하면 컴파일은 되지만 실행 시 오류 발생

		// 반복문을 이용한 요소의 출력
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "]: " + array[i]);
		}
	}
}
