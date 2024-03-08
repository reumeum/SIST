package kr.s28.iostream;

import java.io.File;

public class FileMain05 {
	public static void main(String[] args) {
		//절대경로
		String path = "C:\\javaWork\\javaSample";
		
		File f1 = new File(path);
		
		System.out.println("---디렉토리 생성---");
		System.out.println(f1.mkdir());
	}
}

 	