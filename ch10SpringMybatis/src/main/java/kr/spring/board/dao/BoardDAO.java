package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import kr.spring.board.vo.BoardVO;

public interface BoardDAO {
	public void insertBoard(BoardVO board);
	public int selectBoardCount();
	//sqlSessionTemplate 사용하는 mybatis에서는 Map으로 묶어서 보냄(어노테이션 사용할 때는 분리 가능)
	public List<BoardVO> selectBoardList (Map<String, Integer> map);
	public BoardVO selectBoard(int num);
	public void updateBoard(BoardVO board);
	public void deleteBoard(int num);
}
