package kr.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.news.dao.NewsDAO;
import kr.news.vo.NewsVO;

public class UpdateFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		NewsDAO dao = NewsDAO.getInstance();
		NewsVO vo = dao.getNews(num);
		
		request.setAttribute("vo", vo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}

}
