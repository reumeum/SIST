package kr.board.dao;

public class BoardDAO {
	//싱글턴 패턴
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	private BoardDAO() {}
	
	//글 등록
	
	
	//총 글의 개수, 검색 개수
	//글 목록, 검색 글 목록
	//글 상세
	//조회수 증가
	//파일 삭제
	//글 수정
	//글 삭제
}
