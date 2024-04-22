package kr.web.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/travel")
public class TravelServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");

		req.setCharacterEncoding("utf-8");

		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>여행지</title></head>");
		out.println("<body>");
		out.print("<p>" + req.getParameter("name") +"님이 가고싶은 여행지는 ");

		String[] values = req.getParameterValues("city");

		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				out.print(values[i]);
				if (i != values.length -1) {
					out.print(", ");
				}
			}
		} else {
			out.print("방콕");
		}
		
		out.println("입니다.</p>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
	}
}
