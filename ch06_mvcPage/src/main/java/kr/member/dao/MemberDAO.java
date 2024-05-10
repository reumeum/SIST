package kr.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.member.vo.MemberVO;

public class MemberDAO {
	//싱글턴 패턴
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {}
	
	//사용자
	//회원 가입
	public void insertMember(MemberVO member) throws Exception {
		
	}
	
	//ID 중복 체크 및 로그인 처리
	public MemberVO checkMemver(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		String sql = null;
		
		return member;
	}
	
	//회원 상세정보
	
	//회원정보 수정
	
	//비밀번호 수정
	
	//프로필 사진 수정
	
	//회원 탈퇴(회원정보 삭제)
	
	
	//관리자
	//전체 내용 개수, 검색 내용 개수
	
	//목록, 검색 목록
	
	
}
