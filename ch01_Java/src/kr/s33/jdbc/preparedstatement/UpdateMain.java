package kr.s33.jdbc.preparedstatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.util.*;

public class UpdateMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("번호: ");
			int num = Integer.parseInt(br.readLine());
			System.out.print("제목: ");
			String title = br.readLine();
			System.out.print("이름: ");
			String name = br.readLine();
			System.out.print("메모: ");
			String memo = br.readLine();
			System.out.print("이메일: ");
			String email = br.readLine();
			
			System.out.println("-------------------------------");
			
			//JDBC 수행 1,2단계
			conn = DBUtil.getConnection();
			
			//SQL문 작성
			sql = "UPDATE test3 SET title=?, name=?, memo=?, email=? WHERE num=?";
			
			//JDBC 수행 3단계 : PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, memo);
			pstmt.setString(4, email);
			pstmt.setInt(5, num);
			
			//JDBC 수행 4단계 : SQL문을 실행해서 하나의 행 정보 수정
			int count = pstmt.executeUpdate();
			
			System.out.println(count + "개 행이 수정되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch (IOException e) {}
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
