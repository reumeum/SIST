package kr.s20.object.lang;

public class StringMain05 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 아래 문자열의 대문자->소문자, 소문자->대문자
		 */

		// 아스키코드와 String 클래스의 메서드 이용한 방법
		String str = "abcMDye-4W?EWzz";
		String result = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				result += String.valueOf(c).toLowerCase();
			} else if (c >= 'a' && c <= 'z') {
				result += String.valueOf(c).toUpperCase();
			} else {
				result += c;
			}
		}

		System.out.println(result);

		System.out.println("--------------------");

		
		// 다른 방법: Character wrapper class 이용
		String result2 = "";

		for (char c : str.toCharArray()) {

			if (Character.isUpperCase(c)) {  // 대문자이면 true 반환
				result2 += Character.toLowerCase(c);
			} else if (Character.isLowerCase(c)) {  // 소문자이면 true 반환
				result2 += Character.toUpperCase(c);
			} else {
				result2 += c;
			}
		}

		System.out.println(result2);

		System.out.println("--------------------");

		
		// 다른 방법: 아스키 코드만 이용
		String result3 = "";
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c >= 'A' && c <= 'Z') {
				result3 += (char)(c + 32);  // char로 형변환하지 않으면 아스키코드 형태로 표현됨
			} else if (c >= 'a' && c <= 'z') {
				result3 += (char)(c - 32);
			} else {
				result3 += c;
			}
		}
		
		System.out.println(result3);

		System.out.println("--------------------");
	}
}
