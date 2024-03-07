package kr.s27.collection;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreMain {
	/*
	 * [실습]
	 * 메뉴 : 1.성적입력, 2.성적출력, 3.종료
	 * 메서드명 : 메뉴 callMenu()
	 * 		      성적입력 inputScore()
	 * 			  성적출력 printScore()
	 * 입력시 조건 체크 : 성적 입력범위는 0~100
	 */

	//멤버변수
	ArrayList<Score> list = new ArrayList<Score>();
	BufferedReader br;

	//생성자
	public ScoreMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {

				}
			}
		}
	}

	//메뉴
	public void callMenu() throws IOException {
		while (true) {
			System.out.print("메뉴: 1.성적입력, 2.성적출력, 3.종료 > ");
			try {
				int num = Integer.parseInt(br.readLine());
				if (num == 1) {
					inputScore();
				} else if (num == 2) {
					printScore();
				} else if (num == 3) {
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("메뉴를 잘못 입력했습니다");
				}
			} catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자로 입력해주세요");
			}
		}
	}

	//성적입력
	public void inputScore() throws IOException {
		Score s = new Score();
		System.out.print("이름: ");
		s.setName(br.readLine());

		s.setKorean(checkInputData("국어"));
		s.setEnglish(checkInputData("영어"));
		s.setMath(checkInputData("수학"));
		
		list.add(s);
		System.out.println("학생 정보 1건이 등록되었습니다.");
	}

	public int checkInputData(String course) throws IOException {
		System.out.print(course + ": ");
		while (true) {
			try {
				int data = Integer.parseInt(br.readLine());
				if (data < 0 || data > 100) {
					throw new ScoreValueException("0부터 100까지만 입력 가능");
				}
				return data;
			} catch (NumberFormatException e) {
				System.out.println("숫자가 아닙니다");
			} catch (ScoreValueException e) {
				System.out.println(e
						.getMessage());
			}
		}
	}

	//성적출력
	public void printScore() throws IOException {
		System.out.println("총 학생 수 : " + list.size() + "명");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("----------------------------------------------------");
		for (Score s : list) {
			System.out.print(s.getName() + "\t");
			System.out.print(s.getKorean() + "\t");
			System.out.print(s.getEnglish() + "\t");
			System.out.print(s.getMath() + "\t");
			System.out.print(s.makeSum() + "\t");
			System.out.printf("%.2f\t", s.makeAvg());
			System.out.println(s.makeGrade());
		}
	}

	//메인메서드
	public static void main(String[] args) {
		new ScoreMain();
	}
}
