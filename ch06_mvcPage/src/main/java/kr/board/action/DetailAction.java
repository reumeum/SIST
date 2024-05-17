package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.StringUtil;

public class DetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		BoardDAO dao = BoardDAO.getInstance();
		//조회수 증가
		dao.updateReadCount(board_num);
		
		BoardVO board = dao.getBoard(board_num);
		//HTML을 허용하지 않음
		board.setTitle(StringUtil.useNoHTML(board.getTitle()));
		//HTML을 허용하지 않으면서 줄바꿈
		board.setContent(StringUtil.useBrNoHTML(board.getContent()));
		
		request.setAttribute("board", board);
		
		//JSP 경로 반환
		return "/WEB-INF/views/board/detail.jsp";
	}

}
