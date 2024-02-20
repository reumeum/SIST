package kr.s02.operator;

public class OperatorMain11 {
	public static void main(String[] args) {
		char ch = 'z';
//		String isUppercase = ch >= 65 && ch <= 90 ? "대문자입니다." : "대문자가 아닙니다.";
		String isUppercase = ch >= 'A' && ch <= 'Z' ? "대문자입니다." : "대문자가 아닙니다.";

		System.out.println(ch + "는 " + isUppercase);
	}
}
