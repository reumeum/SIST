package kr.s28.iostream;

import java.io.IOException;

public class InputStreamMain01 {
	public static void main(String[] args) {
		System.out.print("영문자 1개 입력: ");
		try {
			int a = System.in.read();
			System.out.println(a + ", " + (char) a);
			
			System.in.read(); //enter 처리(입력받고 사용하지 않기) \r 13
			System.in.read(); //enter 처리(입력받고 사용하지 않기) \n 10
			
			System.out.print("숫자 1개 입력: ");
			int b = System.in.read() - 48; //아스키코드로 반환된 것을 10진수로 변환
			System.out.println(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
