package kr.s26.exception;

import java.util.Scanner;

// 사용자 정의 예외클래스
class NegativeNumberUseException extends Exception {
	public NegativeNumberUseException(String str) {
		super(str);
	}
}

public class ExceptionMain08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("0 이상의 정수 입력: ");
		try {
			int num = input.nextInt();
			if (num >= 0) {
				System.out.println("입력한 숫자 : " + num);
			} else {  // 음수 입력
				// 사용자 정의 예외 클래스에 예외 문구를 저장해서 객체로 생성해서 예외를 발생시킴
				throw new NegativeNumberUseException("음수를 사용할 수 없습니다.");
			}
		} catch (NegativeNumberUseException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("알 수 없는 예외 발생!");
		} finally {
			if (input != null) {
				input.close();
			}
		}

	}
}
