package kr.s03.operation;

import java.util.Scanner;

public class ScoreTestMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int korean, english, math, sum;
		char grade;
		float avg;

		while (true) {
			System.out.print("국어: ");
			korean = input.nextInt();

			if (korean < 0 || korean > 100) {
				continue;
			}

			System.out.println("국어 점수: " + korean);
			break;
		}

		input.close();
	}
}
