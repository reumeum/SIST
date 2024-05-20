package kr.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.board.vo.BoardFavVO;
import kr.board.vo.BoardVO;
import kr.util.DBUtil;
import kr.util.StringUtil;

public class BoardDAO {
	//싱글턴 패턴
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	private BoardDAO() {}
	
	//글 등록
	public void insertBoard(BoardVO board) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "INSERT INTO zboard (board_num, title, content, filename, ip, mem_num) VALUES (zboard_seq.nextval,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getFilename());
			pstmt.setString(4, board.getIp());
			pstmt.setInt(5, board.getMem_num());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//총 글의 개수, 검색 개수
	public int getBoardCount(String keyfield, String keyword) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sub_sql = "";
		int count = 0;
		
		try {
			conn = DBUtil.getConnection();
			
			if (keyword != null && !keyword.equals("")) {
				if (keyfield.equals("1")) sub_sql += "WHERE title LIKE '%' || ? || '%'";
				else if (keyfield.equals("2")) sub_sql += "WHERE id LIKE '%' || ? || '%'";
				else if (keyfield.equals("3")) sub_sql += "WHERE content LIKE '%' || ? || '%'";
			}
			
			sql = "SELECT COUNT(*) FROM zboard JOIN zmember USING(mem_num) " + sub_sql;
			pstmt = conn.prepareStatement(sql);
			
			if (keyword != null && !keyword.equals("")) {
				pstmt.setString(1, keyword);
			}
			
			//sql문 실행
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			throw new Exception();
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return count;
	}
	
	
	//글 목록, 검색 글 목록
	public List<BoardVO> getListBoard(int start, int end, String keyfield, String keyword) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();
			
			if (keyword != null && !keyword.equals("")) {
				if (keyfield.equals("1")) sub_sql += "WHERE title LIKE '%' || ? || '%'";
				else if (keyfield.equals("2")) sub_sql += "WHERE id LIKE '%' || ? || '%'";
				else if (keyfield.equals("3")) sub_sql += "WHERE content LIKE '%' || ? || '%'";
			}
			
			sql = "SELECT * FROM (SELECT a.*, rownum rnum FROM (SELECT * FROM zboard JOIN zmember USING(mem_num) " +sub_sql+
					" ORDER BY board_num DESC)a) WHERE rnum >= ? AND rnum <= ?";
			
			pstmt = conn.prepareStatement(sql);
			
			if (keyword != null && !keyword.equals("")) {
				pstmt.setString(++cnt, keyword);
			}
			
			pstmt.setInt(++cnt, start);
			pstmt.setInt(++cnt, end);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<BoardVO>();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoard_num(rs.getInt("board_num"));
				board.setTitle(StringUtil.useNoHTML(rs.getString("title"))); //HTML 태그를 허용하지 않음
				board.setHit(rs.getInt("hit"));
				board.setReg_date(rs.getDate("reg_date"));
				board.setId(rs.getString("id"));
				
				list.add(board);
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//글 상세
	public BoardVO getBoard(int board_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO board = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			//sql문 작성
			//(주의) 회원 탈퇴하면 zmember_detail의 레코드를 지우기 때문에 조인시 데이터 누락방지를 위해
			//OUTER JOIN을 사용함
			sql = "SELECT * FROM zboard JOIN zmember USING(mem_num) LEFT OUTER JOIN zmember_detail USING(mem_num)"
					+ "WHERE board_num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				board = new BoardVO();
				board.setBoard_num(rs.getInt("board_num"));
				//수정폼에서도 동일 코드를 사용하기 때문에 StringUtil을 명시하지 않음(모델클래스에서 명시)
				board.setTitle(rs.getString("title"));
				//수정폼에서도 동일 코드를 사용하기 때문에 StringUtil을 명시하지 않음(모델클래스에서 명시)
				board.setContent(rs.getString("content"));
				board.setHit(rs.getInt("hit"));
				board.setReg_date(rs.getDate("reg_date"));
				board.setModify_date(rs.getDate("modify_date"));
				board.setFilename(rs.getString("filename"));
				//로그인한 회원번호와 조건 체크를 해야하기 때문에 mem_num이 필요함
				board.setMem_num(rs.getInt("mem_num"));
				board.setId(rs.getString("id"));
				board.setPhoto(rs.getString("photo"));
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return board;
	}
	
	
	//조회수 증가
	public void updateReadCount(int board_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "UPDATE zboard SET hit=hit+1 WHERE board_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//파일 삭제
	public void deleteFile(int board_num) throws Exception {
		Connection conn= null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "UPDATE zboard SET filename='' WHERE board_num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//글 수정
	public void updateBoard(BoardVO board) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		String sub_sql = "";
		int cnt = 0;
		
		try {
			//커넥션풀로부터 커넥션 할당
		 	conn = DBUtil.getConnection();
		 	
		 	//파일 업로드를 했을 때만 update
		 	if (board.getFilename() != null && !"".equals(board.getFilename())) {
		 		sub_sql += ",filename=?";
		 	}
		 	
		 	sql = "UPDATE zboard SET title=?,content=?,modify_date=SYSDATE,ip=?"
		 			+ sub_sql + " WHERE board_num=?";
		 	
		 	pstmt = conn.prepareStatement(sql);
		 	
		 	pstmt.setString(++cnt, board.getTitle());
		 	pstmt.setString(++cnt, board.getContent());
		 	pstmt.setString(++cnt, board.getIp());
		 	if (board.getFilename() != null && !"".equals(board.getFilename())) {
		 		pstmt.setString(++cnt, board.getFilename());		 		
		 	}
		 	pstmt.setInt(++cnt, board.getBoard_num());
		 	
		 	pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//글 삭제
	public void deleteBoard(int board_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			
			//좋아요 삭제
			//댓글 삭제
			
			//부모글 삭제
			sql = "DELETE FROM zboard WHERE board_num=?";
			
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.setInt(1, board_num);
			
			pstmt3.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(null, pstmt3, null);
			DBUtil.executeClose(null, pstmt2, null);
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
	//좋아요 등록
	//좋아요 개수
	public int SelectFavCount(int board_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECE COUNT(*) FROM zboard_fav WHERE board_num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
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
	
	//회원번호와 게시물 번호를 이용한 좋아요 정보
	//(회원이 게시물을 호출했을 때 좋아요 선택 여부를 표시)
	public BoardFavVO selectFav(BoardFavVO favVO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardFavVO fav = null;
		String sql = null;
		
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM zboard_fav WHERE board_num=? AND mem_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, favVO.getBoard_num());
			pstmt.setInt(2, favVO.getMem_num());
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				fav = new BoardFavVO();
				fav.setBoard_num(rs.getInt("board_num"));
				fav.setMem_num(rs.getInt("mem_num"));
				
			}
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
		return fav;
	}
	
	//좋아요 삭제
	//내가 선택한 좋아요 목록
	
	
	
	
	
	
	
	
	
	
	
}
