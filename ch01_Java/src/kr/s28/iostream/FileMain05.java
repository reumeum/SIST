package kr.s28.iostream;

import java.io.File;

public class FileMain05 {
	public static void main(String[] args) {
		//절대경로
		String path = "C:\\javaWork\\javaSample";
		
		File f1 = new File(path);
		
		System.out.println("---디렉토리 생성---");
		//directory 생성할 수 있으면 true 반환
		//directory 생성할 수 없으면 false 반환
		System.out.println(f1.mkdir());
	}
}

 	