package kr.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.news.dao.NewsDAO;
import kr.news.vo.NewsVO;

public class DetailAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NewsDAO dao = NewsDAO.getInstance();
		NewsVO vo = dao.getNews(Integer.parseInt(request.getParameter("num")));
		
		request.setAttribute("vo", vo);
		
		return "/WEB-INF/views/detail.jsp";
	}

}
