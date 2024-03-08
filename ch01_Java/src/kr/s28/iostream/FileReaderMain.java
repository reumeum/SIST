package kr.s28.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {
	public static void main(String[] args) {
		FileReader fr = null;
		int readChar;
		try {
			fr = new FileReader("file.txt");
			//파일로부터 데이터를 한 문자씩 읽어들여 유니코드로 반환
			while ((readChar = fr.read()) != -1) {
				System.out.print((char) readChar);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
