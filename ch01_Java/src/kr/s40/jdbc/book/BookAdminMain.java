package kr.s40.jdbc.book;

import java.io.BufferedReader;
import java.io.IOException;

public class BookAdminMain {
	//메뉴 : 1.도서 등록, 2.도서 목록, 3.회원 목록, 4.대출 목록, 5.종료
	
	private BufferedReader br;
	private BookDAO dao;
	
	public BookAdminMain() {
		
	}
	
	public void callmenu() throws IOException {
		
	}
	
	public static void main(String[] args) {
		new BookAdminMain();
	}
}
