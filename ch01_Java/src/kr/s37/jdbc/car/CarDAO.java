package kr.s37.jdbc.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.*;

public class CarDAO {
	//자동차 정보 등록
	public void insertCar(String name, String cnumber, String color, String maker, int price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "INSERT INTO car(num, name, cnumber, color, maker, price, reg_date) " + 
			      "VALUES(car_seq.nextval, ?,?,?,?,?, SYSDATE)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, cnumber);
			pstmt.setString(3, color);
			pstmt.setString(4, maker);
			pstmt.setInt(5, price);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 행을 입력했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//목록 보기
	public void selectCar() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM car ORDER BY num DESC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			System.out.println("-----------------------------------------------------------");
			if (rs.next()) {
				System.out.println("번호\t이름\t제조사\t가격\t\t등록일자");
				do {
					System.out.print(rs.getInt("num"));
					System.out.print("\t");
					System.out.print(rs.getString("name"));
					System.out.print("\t");
					System.out.print(rs.getString("maker"));
					System.out.print("\t");
					System.out.printf("%,d원", rs.getInt("price"));
					System.out.print("\t");
					System.out.println(rs.getDate("reg_date"));
				} while(rs.next());
			} else {
				System.out.println("등록된 차량이 없습니다.");
			}
			System.out.println("-----------------------------------------------------------\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//자동차 상세 보기
	public void selectDetailCar(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM car WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("번호: " + rs.getInt("num"));
				System.out.println("차량명: " + rs.getString("name"));
				System.out.println("차량번호: " + rs.getString("cnumber"));
				System.out.println("색상: " + rs.getString("color"));
				System.out.println("제조사: " + rs.getString("maker"));
				System.out.printf("가격: %,d원\n", rs.getInt("price"));
				System.out.println("등록일자: " + rs.getDate("reg_date"));
				System.out.println();
			} else {
				System.out.println("표시할 데이터가 없습니다.\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	
	//자동차 정보 수정
	public void updateCar(int num, String name, String cnumber, String color, String maker, int price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "UPDATE car SET name=?, cnumber=?, color=?, maker=?, price=? WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, cnumber);
			pstmt.setString(3, color);
			pstmt.setString(4, maker);
			pstmt.setInt(5, price);
			pstmt.setInt(6, num);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행의 데이터를 수정했습니다.\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//자동차 정보 삭제
	public void deleteCar(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "DELETE FROM car WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			int count = pstmt.executeUpdate();
			System.out.println(count +"개 행의 데이터를 삭제했습니다.\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
