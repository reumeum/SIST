package kr.s04.array;

public class ArrayMain05 {
	public static void main(String[] args) {
		int[] scores = { 79, 88, 91, 33, 100, 55, 95 };
		int max = scores[0]; // 최대값이 저장되는 변수
		int min = scores[0]; // 최소값이 저장되는 변수

		for (int i = 1; i < scores.length; i++) {
			if (max < scores[i]) {
				max = scores[i];
			}
			if (min > scores[i]) {
				min = scores[i];
			}
		} // end of for

		// 최대값, 최소값 출력
		System.out.printf("최대값: %d%n", max);
		System.out.printf("최소값: %d%n", min);
	} // end of main
}
