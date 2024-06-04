package kr.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.order.vo.OrderDetailVO;
import kr.order.vo.OrderVO;
import kr.util.DBUtil;

public class OrderDAO {
	private static OrderDAO instance = new OrderDAO();

	public static OrderDAO getInstance() {
		return instance;
	}

	private OrderDAO() {
	};

	// 주문 등록
	public void insertOrder(OrderVO order, List<OrderDetailVO> orderDetailList) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		ResultSet rs = null;
		String sql = null;
		int order_num = 0;

		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);

			// order_num 구하기
			sql = "SELECT zorder_seq.nextval FROM dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				order_num = rs.getInt(1);
			}

			// 주문정보 처리
			sql = "INSERT INTO zorder(order_num,order_total,payment,receive_name,receive_post,"
					+ "receive_address1,receive_address2,receive_phone,notice,mem_num) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, order_num);
			pstmt2.setInt(2, order.getOrder_total());
			pstmt2.setInt(3, order.getPayment());
			pstmt2.setString(4, order.getReceive_name());
			pstmt2.setString(5, order.getReceive_post());
			pstmt2.setString(6, order.getReceive_address1());
			pstmt2.setString(7, order.getReceive_address2());
			pstmt2.setString(8, order.getReceive_phone());
			pstmt2.setString(9, order.getNotice());
			pstmt2.setInt(10, order.getMem_num());
			pstmt2.executeQuery();

			// 주문 상세정보 처리
			sql = "INSERT INTO zorder_detail(detail_num,item_num,item_name,item_price,item_total,order_quantity,"
					+ "order_num) VALUES(zorder_detail_seq.nextval,?,?,?,?,?,?)";

			pstmt3 = conn.prepareStatement(sql);

			for (int i = 0; i < orderDetailList.size(); i++) {
				OrderDetailVO orderDetail = orderDetailList.get(i);
				pstmt3.setInt(1, orderDetail.getItem_num());
				pstmt3.setString(2, orderDetail.getItem_name());
				pstmt3.setInt(3, orderDetail.getItem_price());
				pstmt3.setInt(4, orderDetail.getItem_total());
				pstmt3.setInt(5, orderDetail.getOrder_quantity());
				pstmt3.setInt(6, order_num);
				pstmt3.addBatch(); // 쿼리를 메모리에 올림(매번 db에 올리는 것이 아니라 메모리에서 한번에 모아서 올림)

				// 계속 추가하면 outOfMemory 발생, 1000개 단위로 executeBatch()
				if (i % 1000 == 0) {
					pstmt3.executeBatch();
				}
			}
			pstmt3.executeBatch(); // 쿼리를 전송

			// 상품의 재고수 차감
			sql = "UPDATE zitem SET quantity=quantity-? WHERE item_num=?";
			pstmt4 = conn.prepareStatement(sql);

			for (int i = 0; i < orderDetailList.size(); i++) {
				OrderDetailVO orderDetail = orderDetailList.get(i);
				pstmt4.setInt(1, orderDetail.getOrder_quantity());
				pstmt4.setInt(2, orderDetail.getItem_num());
				pstmt4.addBatch(); // 쿼리를 메모리에 올림

				if (i % 1000 == 0) {
					pstmt4.executeBatch();
				}
			}
			pstmt4.executeBatch();

			// 장바구니에서 주문상품 삭제
			sql = "DELETE FROM zcart WHERE mem_num=?";
			pstmt5 = conn.prepareStatement(sql);
			pstmt5.setInt(1, order.getMem_num());
			pstmt5.executeUpdate();

			// 모든 SQL문이 정상 수행
			conn.commit();

		} catch (Exception e) {
			// SQL문이 하나라도 실패
			conn.rollback();
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, pstmt5, null);
			DBUtil.executeClose(null, pstmt4, null);
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

	// 관리자 - 전체 주문 개수/검색 주문 개수
	// 관리자 - 전체 주문 목록/전체 주문 목록
	// 사용자 - 전체 주문 개수/검색 주문 개수
	public int getOrderCountByMem_num(String keyfield, String keyword, int mem_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		int count = 0;

		try {
			conn = DBUtil.getConnection();

			if (keyword != null && "".equals(keyword)) {
				// 검색글 개수
				if (keyfield.equals("1"))
					sub_sql += "AND item_name LIKE '%' || ? || '%'";
				if (keyfield.equals("2"))
					sub_sql += "AND order_num=?";
			}

			sql = "SELECT COUNT(*) FROM zorder JOIN (SELECT order_num, LISTAGG(item_name,',') "
					+ "WITHIN GROUP (ORDER BY item_name) item_name FROM zorder_detail GROUP BY order_num) "
					+ "USING(order_num) WHERE mem_num=? " + sub_sql;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			if (keyword != null && "".equals(keyword)) {
				pstmt.setString(2, keyword);
			}

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return count;
	}

	// 사용자 - 전체 주문 목록/검색 주문 목록
	public List<OrderVO> getListOrderByMem_num(int start, 
			int end, String keyfield, String keyword, int mem_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderVO> list = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();

			if (keyword != null && "".equals(keyword)) {
				// 검색글 개수
				if (keyfield.equals("1"))
					sub_sql += "AND item_name LIKE '%' || ? || '%'";
				if (keyfield.equals("2"))
					sub_sql += "AND order_num=?";
			}

				sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM ("
					+ "SELECT * FROM zorder JOIN (SELECT order_num, LISTAGG(item_name,',') "
					+ "WITHIN GROUP (ORDER BY item_name) item_name FROM zorder_detail GROUP BY order_num) "
					+ "USING(order_num) WHERE mem_num=? " + sub_sql
					+ " ORDER BY order_num DESC)a) WHERE rnum >= ? AND rnum <= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++cnt, mem_num);
			if (keyword != null && "".equals(keyword)) {
				pstmt.setString(++cnt, keyword);
			}
			
			pstmt.setInt(++cnt, start);
			pstmt.setInt(++cnt, end);

			rs = pstmt.executeQuery();
			
			list = new ArrayList<OrderVO>();
			while (rs.next()) {
				OrderVO order = new OrderVO();
				order.setOrder_num(rs.getInt("order_num"));
				order.setOrder_total(rs.getInt("order_total"));
				order.setItem_name(rs.getString("item_name"));
				order.setStatus(rs.getInt("status"));
				order.setReg_date(rs.getDate("reg_date"));
				
				list.add(order);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return list;
		
	}

	// 개별 상품 목록
	public List<OrderDetailVO> getListOrderDetail (int order_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<OrderDetailVO> list = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM zorder_detail WHERE order_num=? ORDER BY item_num DESC";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<OrderDetailVO>();
			while (rs.next()) {
				OrderDetailVO detail = new OrderDetailVO();
				detail.setItem_num(rs.getInt("item_num"));
				detail.setItem_name(rs.getString("item_name"));
				detail.setItem_price(rs.getInt("item_price"));
				detail.setItem_total(rs.getInt("item_total"));
				detail.setOrder_quantity(rs.getInt("order_quantity"));
				detail.setOrder_num(rs.getInt("order_num"));
				
				list.add(detail);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	// 주문 삭제(삭제시 재고를 원상 복귀시키지 않음, 주문 취소일때 재고 수량 원상 복귀)
	// 관리자/사용자 - 주문 상세
	public OrderVO getOrder(int order_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		OrderVO order = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM zorder WHERE order_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				order = new OrderVO();
				order.setOrder_num(rs.getInt("order_num"));
				order.setOrder_total(rs.getInt("order_total"));
				order.setPayment(rs.getInt("payment"));
				order.setStatus(rs.getInt("status"));
				order.setReceive_name(rs.getString("receive_name"));
				order.setReceive_post(rs.getString("receive_post"));
				order.setReceive_address1(rs.getString("receive_address1"));
				order.setReceive_address2(rs.getString("receive_address2"));
				order.setReceive_phone(rs.getString("receive_phone"));
				order.setNotice(rs.getString("notice"));
				order.setReg_date(rs.getDate("reg_date"));
				order.setMem_num(rs.getInt("mem_num"));
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return order;
	}
	
	// 관리자/사용자 - 배송지 정보 수정
	// 관리자 - 배송상태 수정
	// 사용자 - 주문 취소

}
