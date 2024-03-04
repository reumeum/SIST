package kr.s20.object.lang;

import java.util.Scanner;

public class MathMain03 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 가위바위보 게임
		 * 
		 * [입력 예시]
		 * 가위바위보 입력(0.가위, 1.바위, 2.보):1
		 * 
		 * [출력 예시]
		 * -> 컴퓨터: 가위, 사람 : 바위
		 * 결과 : 사람 승
		 */
		
		String[] item = {"가위", "바위", "보"};
		                 // 0      1       2
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("------------------------------");
			System.out.println("메뉴> 1.게임하기 | 2.종료하기");
			System.out.println("------------------------------");
			System.out.print("메뉴> ");
			
			int menu = input.nextInt();
			
			if (menu==1) {
				System.out.print("가위바위보 입력(0.가위, 1.바위, 2.보)> ");
				int user = input.nextInt();
				
				if (user < 0 || user > 2) {
					System.out.println("잘못 입력했습니다.");
					continue;
				}
		
				int computer = (int) (Math.random() * 3); //0~2
				
				/*
				 *  컴퓨터 - 사용자 = 결과
				 *  0        0      = 0      무승부
				 *  0        1      = -1     사용자 승
				 *  0        2      = -2     컴퓨터 승
				 *  1        0      = 1      컴퓨터 승
				 *  1        1      = 0      무승부
				 *  1        2      = -1     사용자 승 
				 *  2        0      = 2      사용자 승
				 *  2        1      = 1      컴퓨터 승
				 *  2        2      = 0      무승부
				 */
				
				int result = computer - user;
				System.out.println("-> 컴퓨터: " + item[computer] + ", 사람: " + item[user]);
				System.out.print("결과: ");
				if (result == 1 || result == -2) {
					System.out.println("컴퓨터 승");
				} else if (result == -1 || result == 2) {
					System.out.println("사람 승");
				} else {
					System.out.println("무승부");
				}
				
				
			} else if (menu==2) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못 입력했습니다.");
			}
			
		}
		
		
		
		
		input.close();
	}
}
