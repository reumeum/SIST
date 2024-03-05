package kr.s26.exception;

import java.security.cert.CertPathBuilderException;

import javax.naming.PartialResultException;

public class ExceptionMain03 {
	public static void main(String[] args) {
		int var = 50;
		//예외처리
		//다중 catch문
		//예외가 발생하면 예외객체가 전달되는 catch블럭으로 이동해서 수행문을 실행함
		try {
			int data = Integer.parseInt(args[0]);  //String -> int 변환
			System.out.println(var/data);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("입력한 데이터가 없습니다.");
		} catch (NumberFormatException e) {
			System.out.println("숫자가 아닙니다.");
		}

		System.out.println("프로그램 종료");
	}
}
