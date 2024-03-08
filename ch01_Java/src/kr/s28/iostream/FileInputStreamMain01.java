package kr.s28.iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamMain01 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		int readbyte;
		byte[] readbyte2;
		try {
			fis = new FileInputStream("file.txt");
			//파일의 정보를 한 문자씩 읽어 들여 아스키 코드로 반환
			//영문 이외의 문자는 crash
			/*
			while ((readbyte = fis.read()) != -1) {
				System.out.print((char) readbyte);
			}
			*/
			
			//영문 이외의 문자도 처리 가능
			readbyte2 = new byte[fis.available()];
			//파일로부터 읽어 들인 데이터를 byte[]에 저장
			fis.read(readbyte2);
							   // byte[] -> String
			System.out.println(new String(readbyte2));
			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//자원정리
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {}
			}
		}
	}
}
