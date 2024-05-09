package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;

public class ModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//전송된 데이터 인코딩 타입 지정
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		//자바빈(VO) 생성
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(num);
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setName(request.getParameter("name"));
		boardVO.setPasswd(request.getParameter("passwd"));
		boardVO.setEmail(request.getParameter("email"));
		boardVO.setContent(request.getParameter("content"));
		boardVO.setIp(request.getRemoteAddr());
		
		BoardDAO dao = BoardDAO.getInstance();
		//비밀번호 인증을 위해 한 건의 레코드를 자바빈(VO)에 담아서 반환
		BoardVO db_board = dao.getBoard(num);
		
		//비밀번호 일치여부 체크
		boolean check = false;
		if (db_board != null) {
			check = db_board.isCheckedPassword(boardVO.getPasswd());
		}
		
		if (check) { //비밀번호 일치
			dao.update(boardVO);
			//상세페이지로 이동하기 위해 글번호 저장
			request.setAttribute("num", num);
		}
		
		request.setAttribute("check", check);

		//JSP 경로 반환
		return "/WEB-INF/views/modify.jsp";
	}

}
