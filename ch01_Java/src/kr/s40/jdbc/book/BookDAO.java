package kr.s40.jdbc.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.*;

public class BookDAO {
	//관리자 도서 등록
	public void insertBook(String bk_name, String bk_category) {
		
	}
	
	//관리자 도서 목록 보기
	public void selectListBook() {
		
	}
	
	//관리자 회원 목록 보기
	public void selectListMember() {
		
	}
	
	//관리자 대출 목록 보기(대출 및 반납의 모든 데이터 표시)
	public void selectListReservation() {
		
	}
	
	//사용자 아이디 중복 체크(count가 0이면 미중복, count가 1이면 중목)
	public int checkId(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT me_id FROM member WHERE me_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = 1;
			}
			
		} catch (Exception e) {
			count = 2; //오류 발생
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;
	}
	
	//사용자 회원 가입
	public void insertMember(String me_id, String me_passwd, String me_name, String me_phone) {
		
	}
	
	//사용자 로그인 체크
	public boolean loginCheck(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT me_id FROM member WHERE me_id=? AND me_passwd=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return flag;
	}
	
	//사용자 도서 대출 여부 확인(도서번호(bk_num)으로 검색해서 re_status의 값이 0이면 대출 가능, 1이면 대출 불가능)
	
	//사용자 도서 대출 등록
	public void insertReservation (int bk_num, String me_id) {
		
	}
	
	//사용자 MY대출 목록 보기(현재 대출한 목록만 표시)
	public void selectMyList(String me_id) {
		
	}
	
	//사용자 반납 가능 여부(대출번호(re_num)와 회원아이디(me_id)를 함께 조회해서 re_status가 1인 것은 반납 가능
	//re_status가 0이면 반납 불가)
	
	//반납 처리
	public void updateReservation(int re_num) {
		
	}
}
