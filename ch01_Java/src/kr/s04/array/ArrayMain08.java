package kr.s04.array;

public class ArrayMain08 {
	public static void main(String[] args) {
		// 클래스를 실행할 때 외부에서 데이터 전달

		if (args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				System.out.println(i + ":" + args[i]);
			}
		} else {
			System.out.println("입력한 내용이 없습니다.");
		}
	}
}
