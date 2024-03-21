package kr.s33.jdbc.preparedstatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.*;

public class SelectSearchMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("제목 검색어: ");
			String keyword = br.readLine();

			System.out.println("----------------------------------------");

			//JDBC 1,2단계
			conn = DBUtil.getConnection();

			//SQL문 작성
			sql = "SELECT * FROM test3 WHERE title LIKE '%' || ? || '%'";

			//JDBC 3단계: PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, keyword);

			//JDBC 4단계
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("번호\t작성자\t등록일\t\t제목");

				do {
					System.out.print(rs.getInt("num"));
					System.out.print("\t");
					System.out.print(rs.getString("name"));
					System.out.print("\t");
					System.out.print(rs.getDate("reg_date"));
					System.out.print("\t");
					System.out.println(rs.getString("title"));
				} while (rs.next());

			} else {
				System.out.println("검색된 데이터가 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
				}
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}
