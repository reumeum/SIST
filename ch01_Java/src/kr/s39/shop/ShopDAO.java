package kr.s39.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class ShopDAO {
	//관리자 상품 등록
	public void insertItem(String item_name, int item_price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();

			sql = "INSERT INTO sitem(item_num, item_name, item_price) VALUES(sitem_seq.nextval, ?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_name);
			pstmt.setInt(2, item_price);

			int count = pstmt.executeUpdate();
			System.out.println(count + "개의 상품을 등록했습니다.");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	//관리자/사용자 상품 목록
	public void selectItems() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM sitem";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			System.out.println("-----------------------------------");
			
			if (rs.next()) {
				System.out.println("번호\t상품명\t가격\t등록일");
				do {
					System.out.print(rs.getInt("item_num"));
					System.out.print("\t");
					System.out.print(rs.getString("item_name"));
					System.out.print("\t");
					System.out.printf("%,d", rs.getInt("item_price"));
					System.out.print("\t");
					System.out.println(rs.getDate("item_date"));
				} while(rs.next());
			} else {
				System.out.println("등록된 상품이 없습니다.");
			}
			
			System.out.println("-----------------------------------\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	//관리자 회원 목록
	public void selectCustomers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM customer ORDER BY cust_date DESC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			System.out.println("------------------------------------------------------");
			if (rs.next()) {
				System.out.println("ID\t이름\t가입일\t\t전화번호\t\t주소");
				do {
					System.out.print(rs.getString("cust_id"));
					System.out.print("\t");
					System.out.print(rs.getString("cust_name"));
					System.out.print("\t");
					System.out.print(rs.getDate("cust_date"));
					System.out.print("\t");
					System.out.print(rs.getString("cust_tel"));
					System.out.print("\t\t");
					System.out.println(rs.getString("cust_address"));
				} while(rs.next());
			} else {
				System.out.println("표시할 회원 정보가 없습니다.");
			}
			
			System.out.println("------------------------------------------------------");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	//관리자 구매 목록
	public void selectOrders() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM sorder JOIN sitem USING(item_num) JOIN customer USING(cust_id) "
			    + "ORDER BY order_num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("-------------------------------------------------------------");
			
			if (rs.next()) {
				System.out.println("번호\t주문자ID\t이름\t상품명\t상품가격\t주문일");
				do {
					System.out.print(rs.getInt("order_num"));
					System.out.print("\t");
					System.out.print(rs.getString("cust_id"));
					System.out.print("\t\t");
					System.out.print(rs.getString("cust_name"));
					System.out.print("\t");
					System.out.print(rs.getString("item_name"));
					System.out.print("\t");
					System.out.printf("%,d", rs.getInt("item_price"));
					System.out.print("\t\t");
					System.out.println(rs.getDate("order_date"));
				} while(rs.next());
			} else {
				System.out.println("등록된 주문 정보가 없습니다.");
			}
			
			System.out.println("-------------------------------------------------------------\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	//사용자 회원 등록
	public void insertCustomer(String cust_id, String cust_name, String cust_address, String cust_tel) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "INSERT INTO customer(cust_id, cust_name, cust_address, cust_tel) VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cust_id);
			pstmt.setString(2, cust_name);
			pstmt.setString(3, cust_address);
			pstmt.setString(4, cust_tel);
			
			pstmt.executeUpdate();
			System.out.println("회원가입이 완료되었습니다.");
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	//사용자 회원 상세
	public void selectDatailCustomer(String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM customer WHERE cust_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cust_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("---------------------------------");
				System.out.println("ID: " + rs.getString("cust_id"));
				System.out.println("이름: " + rs.getString("cust_name"));
				System.out.println("주소: " + rs.getString("cust_address"));
				System.out.println("전화번호: " + rs.getString("cust_tel"));
				System.out.println("가입일: " + rs.getDate("cust_date"));
				System.out.println("---------------------------------\n");
			} else {
				System.out.println("검색된 회원정보가 없습니다.");
				System.out.println();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	//사용자 상품 구매
	public void insertOrder(String cust_id, int item_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			
			sql = "INSERT INTO sorder (order_num, cust_id, item_num)" + 
			"VALUES (sorder_seq.nextval, ?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cust_id);
			pstmt.setInt(2, item_num);
			
			int count = pstmt.executeUpdate();
			System.out.println(count +"개의 상품을 구매했습니다.");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	

	//사용자 구매 내역
	public void SelectOrdersById(String cust_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM sitem JOIN sorder USING(item_num) " + 
			      "WHERE cust_id=? ORDER BY order_num DESC";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cust_id);
			
			rs = pstmt.executeQuery();
			
			System.out.println("-----------------------------------------------------");
			System.out.println(cust_id + "님의 구매 내역");
			System.out.println("-----------------------------------------------------");
			System.out.println("주문번호\t상품명\t상품가격\t주문일");
			if (rs.next()) {
				do {
					System.out.print(rs.getInt("order_num"));
					System.out.print("\t\t");
					System.out.print(rs.getString("item_name"));
					System.out.print("\t");
					System.out.printf("%,d", rs.getInt("item_price"));
					System.out.print("\t\t");
					System.out.println(rs.getDate("order_date"));
				} while(rs.next());
			} else {
				System.out.println("등록된 주문 정보가 없습니다.");
			}
			
			System.out.println("-----------------------------------------------------\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}
