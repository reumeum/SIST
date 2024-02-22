package kr.s03.operation;

import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int korean, english, math, sum;
		char grade;
		float avg;

		do {
			System.out.print("국어: ");
			korean = input.nextInt();
		} while (korean < 0 || korean > 100);

		do {
			System.out.print("영어: ");
			english = input.nextInt();
		} while (english < 0 || english > 100);

		do {
			System.out.print("수학: ");
			math = input.nextInt();
		} while (math < 0 || math > 100);

		// 총점 구하기
		sum = korean + english + math;
		
		// 평균 구하기
		avg = sum / 3.0f;
		
		// 등급 구하기
		switch((int) (avg/10)) {
		case 10:
		case 9:
			grade = 'A'; break;
		case 8:
			grade = 'B'; break;
		case 7:
			grade = 'C'; break;
		case 6:
			grade = 'D'; break;
		default:
			grade = 'F'; break;
		}
		
		System.out.print("\n");
		System.out.printf("총점 = %d%n", sum);
		System.out.printf("평균 = %.2f%n", avg);
		System.out.printf("등급 = %c학점%n", grade);
		

		input.close();
	}
}
