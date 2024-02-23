package kr.s04.array;

public class ArrayMain09 {
	public static void main(String[] args) {
		// (테스트 조건) main에 전달할 데이터는 두 개의 정수
		
		// main의 인자로 데이터를 전달하면 전달한 데이터의 자료형은 모두 String으로 인식
		// + 연산이 되지 않고 문자열 연결이 됨
		System.out.println(args[0] + args[1]);
		System.out.println("-------------------");
		
		
		// String -> int
		int num = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println("합계 : " + (num + num2));
		
	}
}
