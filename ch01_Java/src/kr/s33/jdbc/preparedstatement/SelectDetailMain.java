package kr.s33.jdbc.preparedstatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.*;

public class SelectDetailMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("번호: ");
			int num = Integer.parseInt(br.readLine());
			System.out.println("--------------------------");
			
			//JDBC 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "SELECT * FROM test3 WHERE num=?";
			
			//JDBC 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			
			//JDBC 4단계 : SQL문을 테이블에 반영하고 결과집합을 ResultSet에 담아서 반환
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("번호: " + rs.getInt("num"));
				System.out.println("제목: " + rs.getString("title"));
				System.out.println("작성자: " + rs.getString("name"));
				System.out.println("내용: " + rs.getString("memo"));
				
				//이메일 null값 처리
				String email = rs.getString("email");
				if (email == null) email = "";
				
				System.out.println("이메일: " + email);
				System.out.println("등록일자: " + rs.getDate("reg_date"));
				
			} else {
				//프라이머리키가 올바르지 않을 때
				System.out.println("검색된 데이터가 없습니다.");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//자원정리
			if (br != null) try {br.close();} catch(IOException e) {}
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}
