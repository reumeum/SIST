package kr.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.employee.vo.EmployeeVO;
import kr.member.vo.MemberVO;
import kr.util.DBUtil;

public class EmployeeDAO {
	// 싱글톤 패턴
	private static EmployeeDAO instance = new EmployeeDAO();

	public static EmployeeDAO getInstance() {
		return instance;
	}

	private EmployeeDAO() {
	}

	// 사원 등록
	public void insertEmployee(EmployeeVO vo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DBUtil.getConnection();
			sql = "INSERT INTO semployee(num,id,name,passwd,salary,job) VALUES(semployee_seq.nextval," + "?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setInt(4, vo.getSalary());
			pstmt.setString(5, vo.getJob());

			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}

	// 사원 상세정보
	public EmployeeVO getEmployee(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		EmployeeVO vo = null;

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM semployee WHERE num=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new EmployeeVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setSalary(rs.getInt("salary"));
				vo.setJob(rs.getString("job"));
				vo.setReg_date(rs.getDate("reg_date"));
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return vo;
	}

	// 아이디 중복 체크, 로그인 체크
	public EmployeeVO checkEmployee(String id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO vo = null;
		String sql = null;

		try {
			// 커넥션풀로부터 커넥션을 할당
			conn = DBUtil.getConnection();
			// SQL문 작성
			sql = "SELECT * FROM semployee WHERE id=?";
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// ?에 데이터 바인딩
			pstmt.setString(1, id);
			// SQL문 실행
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new EmployeeVO();
				vo.setId(rs.getString("id"));
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setSalary(rs.getInt("salary"));
				vo.setJob(rs.getString("job"));
				vo.setReg_date(rs.getDate("reg_date"));
			}

		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			// 자원 정리
			DBUtil.executeClose(rs, pstmt, conn);
		}

		return vo;
	}

	// 사원정보 수정
	public void updateEmployee(EmployeeVO vo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "UPDATE semployee SET name=?,passwd=?,salary=?,job=? WHERE num=?";
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//여기부터 다시 하면 됨. update.jsp 작성.

	// 사원정보 삭제
	public void deleteEmployee(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "DELETE FROM semployee WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
}
