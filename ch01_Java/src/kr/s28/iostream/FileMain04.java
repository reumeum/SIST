package kr.s28.iostream;

import java.io.File;

public class FileMain04 {
	public static void main(String[] args) {
		//상대경로
		String path = "example.txt";
		
		File f1 = new File(path);
		System.out.println("---파일 삭제---");
		
		//delete(): 삭제할 수 있으면 삭제하고 true를 반환,
		//삭제가 불가능하면 false를 반환
		if (f1.delete()) {
			System.out.println(f1.getName() + " 파일 삭제");
		} else {
			System.out.println("파일을 삭제하지 못했습니다.");
		}
	}
}
