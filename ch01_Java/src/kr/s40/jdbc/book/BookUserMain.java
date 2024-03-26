package kr.s40.jdbc.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookUserMain {
	private BufferedReader br;
	private BookDAO dao;
	private String me_id; //로그인한 회원 아이디
	private boolean login; //로그인 여부(로그인 true, 로그아웃 false)

	public BookUserMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dao = new BookDAO();
			callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
		}
	}

	public void callMenu() throws IOException {
		//로그인 체크
		while (true) {
			System.out.print("1.로그인, 2.회원가입, 3.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());
				if (no == 1) { //로그인
					System.out.print("아이디: ");
					me_id = br.readLine();
					
					System.out.print("비밀번호: ");
					String me_passwd =br.readLine();
					
					login = dao.loginCheck(me_id, me_passwd);
					
					if (login == true) {
						System.out.println("로그인 되었습니다.");
						break;
					} else {
						System.out.println("로그인에 실패했습니다. 다시 시도해주세요.");
					}
				} else if (no == 2) { //회원가입
					System.out.print("아이디: ");
					String me_id = br.readLine();
					//아이디 중복 체크
					int check = dao.checkId(me_id);
					
					if (check >= 1) { //1.중복, 2.오류
						System.out.println("아이디가 중복되었습니다.");
					} else { //미중복
						//비밀번호, 이름, 전화번호 입력
						System.out.print("비밀번호: ");
						String me_passwd = br.readLine();
						System.out.print("전화번호: ");
						String me_phone = br.readLine();
						System.out.print("이름: ");
						String me_name = br.readLine();
						
						dao.insertMember(me_id, me_passwd, me_name, me_phone);	
					}
					
				} else if (no == 3) { //종료
					System.out.println("프로그램 종료");
					break;
				} else {
					System.out.println("잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			}
		}
		//로그인 체크 후 메뉴
		while (login) {
			System.out.print("1.도서 대출, 2.MY 대출 목록, 3.대출 도서 반납, 4.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());
				if (no == 1) { //도서 대출
					dao.selectListBookForUser();
					while (true) {
						System.out.print("대출할 도서 번호: ");
						int bk_num = Integer.parseInt(br.readLine());
						if (dao.isAvailable(bk_num)) {
							dao.insertReservation(bk_num, me_id);
							break;
						} else {
							System.out.println("해당 도서가 이미 대출중입니다.\n");
						}
					}
					
				} else if (no == 2) { //MY 대출 목록
					dao.selectMyList(me_id);
				} else if (no == 3) { //대출 도서 반납
					dao.selectMyList(me_id);
					System.out.print("반납할 도서 대출 번호: ");
					int re_num = Integer.parseInt(br.readLine());
					if (dao.isReturnable(re_num, me_id)) {
						dao.updateReservation(re_num, me_id);
					} else {
						System.out.println("대출중인 도서가 아닙니다.\n");
					}
				} else if (no == 4) { //종료
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
		new BookUserMain();
	}
}
