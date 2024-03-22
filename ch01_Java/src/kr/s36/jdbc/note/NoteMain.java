package kr.s36.jdbc.note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoteMain {
	private BufferedReader br;
	private NoteDAO note;
	
	//생성자
	public NoteMain() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			note = new NoteDAO();
			//메뉴 호출
			callMenu();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
		} 
	}
	
	//메뉴
	public void callMenu() throws IOException {
		while(true) {
			System.out.print("1.글쓰기, 2.목록 보기, 3.상세글 보기, 4.글수정, 5.글삭제, 6.종료> ");
			try {
				int no = Integer.parseInt(br.readLine());
				if (no == 1) { //글쓰기
					System.out.print("이름: ");
					String name = br.readLine();
					System.out.print("비밀번호: ");
					String passwd = br.readLine();
					System.out.print("제목: ");
					String subject = br.readLine();
					System.out.print("내용: ");
					String content = br.readLine();
					System.out.print("이메일: ");
					String email = br.readLine();
					
					note.insertInfo(name, passwd, subject, content, email);
					
				} else if (no == 2) { //목록 보기
					note.selectInfo();
					
				} else if (no == 3) { //상세글 보기
					note.selectInfo(); //글번호 먼저 확인하기
					System.out.print("선택한 글의 번호: ");
					int num = Integer.parseInt(br.readLine());
					note.selectDetailInfo(num);
					
				} else if (no == 4) { //글수정
					note.selectInfo();
					System.out.print("수정할 글의 번호: ");
					int num = Integer.parseInt(br.readLine());
					note.selectDetailInfo(num);
					
					System.out.print("이름: ");
					String name = br.readLine();
					System.out.print("비밀번호: ");
					String passwd = br.readLine();
					System.out.print("제목: ");
					String subject = br.readLine();
					System.out.print("내용: ");
					String content = br.readLine();
					System.out.print("이메일: ");
					String email = br.readLine();
					
					note.updateInfo(num, name, passwd, subject, content, email);
					
				} else if (no == 5) { //글삭제
					note.selectInfo();
					System.out.print("삭제할 글의 번호: ");
					int num = Integer.parseInt(br.readLine());
					note.deleteInfo(num);
		
				} else if (no == 6) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.out.println("메뉴를 잘못 입력했습니다. 다시 입력해주세요.");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능!");
			}
		} 
	}
	
	//메인
	public static void main(String[] args) {
		new NoteMain();
	}
}
