package kr.s38.jdbc.score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreMain {
	private BufferedReader br;
	private ScoreDAO dao;

	//생성자
	public ScoreMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new ScoreDAO();
			callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
		}
	}

	//메뉴
	public void callMenu() throws IOException {
		while (true) {
			System.out.print("1.입력, 2.목록, 3.상세정보, 4.수정, 5.삭제 6.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());

				if (no == 1) { //입력
					System.out.print("이름: ");
					String name = br.readLine();

					int korean = checkScore("국어");
					int english = checkScore("영어");
					int math = checkScore("수학");

					int sum = getSum(korean, english, math);
					int avg = getAvg(sum);
					String grade = getGrade(avg);

					dao.insertScore(name, korean, english, math, sum, avg, grade);

				} else if (no == 2) { //목록
					dao.selectScore();
				} else if (no == 3) { //상세정보
					dao.selectScore();
					System.out.print("확인할 성적 번호: ");
					int num = Integer.parseInt(br.readLine());

					dao.selectDetailScore(num);

				} else if (no == 4) { //수정
					dao.selectScore();
					System.out.print("수정할 성적 번호: ");
					int num = Integer.parseInt(br.readLine());

					dao.selectDetailScore(num);

					System.out.print("이름: ");
					String name = br.readLine();

					int korean = checkScore("국어");
					int english = checkScore("영어");
					int math = checkScore("수학");

					int sum = getSum(korean, english, math);
					int avg = getAvg(sum);
					String grade = getGrade(avg);

					dao.updateScore(num, name, korean, english, math, sum, avg, grade);

				} else if (no == 5) { //삭제
					dao.selectScore();
					System.out.print("삭제할 성적 번호: ");
					int num = Integer.parseInt(br.readLine());

					dao.deleteScore(num);

				} else if (no == 6) { //종료
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("메뉴를 잘못 입력했습니다.");
				}

			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능");
			}
		}
	}

	private int getSum(int korean, int english, int math) {
		return korean + english + math;
	}

	private int getAvg(int sum) {
		return sum / 3;
	}

	private String getGrade(int avg) {
		if (avg >= 90) {
			return "A";
		} else if (avg >= 80) {
			return "B";
		} else if (avg >= 70) {
			return "C";
		} else if (avg >= 60) {
			return "D";
		} else {
			return "E";
		}
	}

	private int checkScore(String courseName) throws IOException {
		int score;

		while (true) {
			try {
				System.out.print(courseName + ": ");
				score = Integer.parseInt(br.readLine());

				if (score < 0 || score > 100) {
					System.out.println("성적은 0~100 사이로 입력해주세요.");
					continue;
				}
				return score;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능");
			}
		}
	}

	public static void main(String[] args) {
		new ScoreMain();
	}
}
