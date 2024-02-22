package kr.s04.array;

import java.util.Scanner;

public class ArrayMain07 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String[] courses = { "국어", "영어", "수학" };
		int[] scores = new int[courses.length]; // 0:국어, 1:영어, 2:수학
		int sum = 0;
		float avg = 0.0f;

		// 반복문을 이용해서 입력 처리
		for (int i = 0; i < scores.length; i++) {
			// 입력값을 0~100 사이로 제한하기 위해 do~while문 사용
			do {
				System.out.printf("%s 성적을 입력하세요> ", courses[i]);
				scores[i] = input.nextInt();
			} while (scores[i] < 0 || scores[i] > 100);
			
			// 총점 구하기
			sum += scores[i];
		}
		
		// 평균 구하기
		avg = sum / (float) courses.length;

		System.out.println();
		
		// 과목 출력하기
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%s = %d점%n", courses[i], scores[i]);
		}
		
		// 총점, 평균 출력하기
		System.out.printf("총점 = %d점%n", sum);
		System.out.printf("평균 = %.2f점%n", avg);
		
		input.close();
	}
}
