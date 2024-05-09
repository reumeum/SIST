package kr.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.news.dao.NewsDAO;
import kr.news.vo.NewsVO;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		NewsDAO dao = NewsDAO.getInstance();
		NewsVO db_vo = dao.getNews(num);
		
		boolean check = false;
		if (db_vo != null) {
			check = db_vo.isCheckedPassword(request.getParameter("passwd"));
		}
		
		if (check) {
			dao.deleteNews(num);
			request.setAttribute("check", check);
		}
		
		
		
		return "/WEB-INF/views/delete.jsp";
	}

}
