package kr.web.ch02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/num")
public class NumServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * [실습] 전송된 정수 값이 짝수이면 짝수입니다 출력, 홀수이면 홀수입니다 출력
		 */

		response.setContentType("text/html;charset=utf-8");

		int num = Integer.parseInt(request.getParameter("num"));

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>홀수/짝수 구하기</title><head>");
		out.println("<body>");
		out.println("<p>" + evenOrOdd(num) + "</p>");
		out.println("</body></html>");
		out.close();

	}

	String evenOrOdd(int number) {
		if (number % 2 == 0) {
			return "짝수입니다";
		} else {
			return "홀수입니다";
		}
	}
}
