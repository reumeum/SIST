package kr.s40.jdbc.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookAdminMain {
	//메뉴 : 1.도서 등록, 2.도서 목록, 3.회원 목록, 4.대출 목록, 5.종료
	
	private BufferedReader br;
	private BookDAO dao;
	
	public BookAdminMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new BookDAO();
			callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
		}
	}
	
	public void callMenu() throws IOException {
		while(true) {
			System.out.print("1.도서 등록, 2.도서 목록, 3.회원 목록, 4.대출 목록, 5.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());
				if (no == 1) { //도서 등록
					System.out.print("도서명: ");
					String bk_name = br.readLine();
					System.out.print("카테고리: ");
					String bk_category = br.readLine();
					
					dao.insertBook(bk_name, bk_category);
				} else if (no== 2) { //도서 목록
					dao.selectListBook();
				} else if (no==3) { //회원 목록
					dao.selectListMember();
				} else if (no==4) { //대출 목록
					dao.selectListReservation();
				} else if (no ==5) { //종료
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			}
		}
	}
	
	public static void main(String[] args) {
		new BookAdminMain();
	}
}
