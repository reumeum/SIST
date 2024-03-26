package kr.s40.jdbc.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.*;

public class BookDAO {
	//관리자 도서 등록
	public void insertBook(String bk_name, String bk_category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "INSERT INTO sbook(bk_num, bk_name, bk_category) VALUES(sbook_seq.nextval, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bk_name);
			pstmt.setString(2, bk_category);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "건의 책이 등록되었습니다.");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//관리자 도서 목록 보기
	public void selectListBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM sbook ORDER BY bk_num DESC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("-----------------------------------------------------");
			if (rs.next()) {
				System.out.println("번호\t도서명\t\t카테고리\t등록일자");
				do {
					System.out.print(rs.getInt("bk_num"));
					System.out.print("\t");
					System.out.print(rs.getString("bk_name"));
					System.out.print("\t\t");
					System.out.print(rs.getString("bk_category"));
					System.out.print("\t\t");
					System.out.println(rs.getDate("bk_regdate"));
				} while (rs.next());
			} else {
				System.out.println("등록된 도서가 없습니다.");
			}
			System.out.println("-----------------------------------------------------\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//관리자 회원 목록 보기
	public void selectListMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM member ORDER BY me_regdate DESC";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("--------------------------------------------");
			if (rs.next()) {
				System.out.println("ID\t이름\t전화번호\t가입일자");
				do {
					System.out.print(rs.getString("me_id"));
					System.out.print("\t");
					System.out.print(rs.getString("me_name"));
					System.out.print("\t");
					System.out.print(rs.getString("me_phone"));
					System.out.print("\t");
					System.out.println(rs.getDate("me_regdate"));
				} while(rs.next());
			} else {
				System.out.println("등록된 회원 정보가 없습니다.");
			}
			System.out.println("--------------------------------------------\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
	}
	
	//관리자 대출 목록 보기(대출 및 반납의 모든 데이터 표시)
	public void selectListReservation() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_num, bk_name, me_name, re_status, re_regdate, NVL(to_char(re_modifydate), ' ') modidate " +
			      "FROM reservation JOIN member USING(me_id) JOIN sbook USING(bk_num) ORDER BY re_num DESC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			System.out.println("-------------------------------------------------------------------------------");
			if (rs.next()) {
				System.out.println("대출번호\t도서명\t\t대출자\t대출상태\t대출일자\t반납일자");
				do {
					System.out.print(rs.getInt("re_num"));
					System.out.print("\t\t");
					System.out.print(rs.getString("bk_name"));
					System.out.print("\t\t");
					System.out.print(rs.getString("me_name"));
					System.out.print("\t");
					System.out.print(rs.getInt("re_status"));
					System.out.print("\t\t");
					System.out.print(rs.getDate("re_regdate"));
					System.out.print("\t");
					System.out.println(rs.getString("modidate"));
				} while(rs.next());
				
			} else {
				System.out.println("대출중인 도서가 없습니다.");
			}
			System.out.println("-------------------------------------------------------------------------------\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//사용자 아이디 중복 체크(count가 0이면 미중복, count가 1이면 중복)
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "INSERT INTO member(me_id, me_passwd, me_name, me_phone) VALUES(?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			pstmt.setString(3, me_name);
			pstmt.setString(4, me_phone);
			
			pstmt.executeUpdate();
			System.out.println("회원가입이 완료되었습니다.");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
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
	
	//사용자 도서 목록 보기
	public void selectListBookForUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT bk_num, b.bk_name, b.bk_category, r.re_status, b.bk_regdate FROM sbook b JOIN reservation r USING(bk_num) ORDER BY bk_num DESC";
			
			sql문 고치기
			
			
			
			
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("-----------------------------------------------------");
			if (rs.next()) {
				System.out.println("번호\t도서명\t\t카테고리\t대출여부\t등록일자");
				do {
					System.out.print(rs.getInt("bk_num"));
					System.out.print("\t");
					System.out.print(rs.getString("bk_name"));
					System.out.print("\t\t");
					System.out.print(rs.getString("bk_category"));
					System.out.print("\t\t");
					
					String isAvailable = rs.getInt("re_status") == 0? "대출가능" : "대출중";
					System.out.print(isAvailable);
					System.out.print("\t");
					
					System.out.println(rs.getDate("bk_regdate"));
				} while (rs.next());
			} else {
				System.out.println("등록된 도서가 없습니다.");
			}
			System.out.println("-----------------------------------------------------\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//사용자 도서 대출 여부 확인(도서번호(bk_num)으로 검색해서 re_status의 값이 0이면 대출 가능, 1이면 대출 불가능)
	public boolean isAvailable(int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean isAvailable = true;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT re_status FROM reservation WHERE bk_num=?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bk_num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isAvailable = rs.getInt("re_status") == 0 ? true : false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return isAvailable;
	}
	
	
	//사용자 도서 대출 등록
	public void insertReservation (int bk_num, String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "INSERT INTO reservation(re_num, re_status, bk_num, me_id) VALUES(reservation_seq.nextval,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, bk_num);
			pstmt.setString(3, me_id);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "권의 도서를 대출했습니다.\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//사용자 MY대출 목록 보기(현재 대출한 목록만 표시)
	public void selectMyList(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM reservation JOIN sbook USING(bk_num) WHERE re_status=1 AND me_id=? ORDER BY re_num DESC";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);
			
			rs = pstmt.executeQuery();
			
			System.out.println("----------------------------------------------");
			if (rs.next()) {
				System.out.println("대출번호\t도서명\t\t대출일자");
				do {
					System.out.print(rs.getInt("re_num"));
					System.out.print("\t\t");
					System.out.print(rs.getString("bk_name"));
					System.out.print("\t\t");
					System.out.println(rs.getDate("re_regdate"));
				} while(rs.next());
				
			} else {
				System.out.println("대출중인 도서가 없습니다.");
			}
			System.out.println("----------------------------------------------\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//사용자 반납 가능 여부(대출번호(re_num)와 회원아이디(me_id)를 함께 조회해서 re_status가 1인 것은 반납 가능
	//re_status가 0이면 반납 불가)
	public boolean isReturnable(int re_num, String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean isReturnable = false;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM reservation WHERE me_id=? AND re_num=? AND re_status=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);
			pstmt.setInt(2, re_num);
			pstmt.setInt(3, 1);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isReturnable = true;
			} else {
				isReturnable = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return isReturnable;
	}
	
	
	//반납 처리
	public void updateReservation(int re_num, String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "UPDATE reservation SET re_status=0, re_modifydate=SYSDATE WHERE re_num=? AND me_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_num);
			pstmt.setString(2, me_id);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "권의 도서가 반납 처리 되었습니다.\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
		
	}
}
















