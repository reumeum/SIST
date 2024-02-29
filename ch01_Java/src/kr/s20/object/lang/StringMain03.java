package kr.s20.object.lang;

public class StringMain03 {
	public static void main(String[] args) {
		String s1 = "  aBa  ";
		String s2 = "abc";
		int a = 100;
		String msg = null;
		
		msg = s1.toUpperCase();
		System.out.println("msg: " + msg); // 대문자 처리
		
		msg = s1.toLowerCase();
		System.out.println("msg: " + msg); // 소문자 처리
		
		msg = s1.replace("aB", "b");
		System.out.println("msg: " + msg); // old 문자를 new 문자로 대체
		
		msg = s1.trim();
		System.out.println("msg: " + msg); // 앞뒤 공백 제거
		
		// 문자열 중에 메서드의 인자로 전달된 문자열이 포함되어 있는지 검증
		boolean f = s1.contains("aB");
		System.out.println("f = " + f);
		
		// 메서드의 인자로 전달된 문자열로 시작하는지 검증
		f = s2.startsWith("ab");
		System.out.println("f = " + f);
		
		// 메서드의 인자로 전달된 문자열로 끝나는지 검증
		f = s2.endsWith("bc");
		System.out.println("f = " + f);
		
		// int -> String
		msg = String.valueOf(a);
		msg = a + "";
	}
}
