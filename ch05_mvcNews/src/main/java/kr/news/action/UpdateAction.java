package kr.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.controller.Action;
import kr.news.dao.NewsDAO;
import kr.news.vo.NewsVO;
import kr.util.FileUtil;

public class UpdateAction implements Action {

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
			NewsVO vo = new NewsVO();
			vo.setNum(num);
			vo.setTitle(request.getParameter("title"));
			vo.setWriter(request.getParameter("writer"));
			vo.setEmail(request.getParameter("email"));
			vo.setArticle(request.getParameter("article"));
			
			Part part = request.getPart("filename");
			
			if (part == null || part.getSize() == 0) {
				vo.setFilename(db_vo.getFilename());
			} else {
				vo.setFilename(FileUtil.createFile(request, "filename"));
				FileUtil.removeFile(request, db_vo.getFilename());
			}
			
			dao.updateNews(vo);
			request.setAttribute("check", check);
			request.setAttribute("num", num);
		}
		
		
		return "/WEB-INF/views/update.jsp";
	}

}
