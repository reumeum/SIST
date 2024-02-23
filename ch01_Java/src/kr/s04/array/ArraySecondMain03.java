package kr.s04.array;

import java.util.Scanner;

public class ArraySecondMain03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// 과목명
		String[] course = { "국어", "영어", "수학" };

		// 인원수
		System.out.print("학생 수> ");
		int n = input.nextInt();

		int[][] score = new int[n][course.length];

		// 총점을 저장하는 배열
		int[] sum = new int[n];

		// 평균을 저장하는 배열
		float[] avg = new float[n];

		// 성적을 입력받고 총점과 평균 구하기
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				// 성적을 입력 받음
				do {
					// 과목명 출력
					System.out.print(course[j] + " 점수> ");
					score[i][j] = input.nextInt();
				} while (score[i][j] < 0 || score[i][j] > 100);

				// 총점 구하기
				sum[i] += score[i][j];
			}
			
			// 평균 구하기
			avg[i] += sum[i] / (float) course.length;
			System.out.println();
		}
		
		// 총점과 평균 출력
		for (int i = 0; i < n; i++) {
			System.out.println("[학생" + (i + 1) + "]");
			System.out.printf("총점 = %d%n", sum[i]);
			System.out.printf("평균 = %.2f%n", avg[i]);
			System.out.println();
		}

		input.close();
	}
}
