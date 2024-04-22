package kr.web.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score")
public class ScoreServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 성적 처리
		// 국어,영어,수학,총점,평균,등급 출력

		res.setContentType("text/html;charset=utf-8");

		req.setCharacterEncoding("utf-8");

		int korean = Integer.parseInt(req.getParameter("korean"));
		int english = Integer.parseInt(req.getParameter("english"));
		int math = Integer.parseInt(req.getParameter("math"));

		int sum = korean + english + math;
		double avg = sum / 3.0;

		char grade;
		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80) {
			grade = 'B';
		} else if (avg >= 70) {
			grade = 'C';
		} else if (avg >= 60) {
			grade = 'D';
		} else {
			grade = 'E';
		}
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>성적 출력</title></head>");
		out.println("<body>");
		  
			out.println("<ul>");
				out.println("<li>");
					out.println("국어 : " + korean);	
				out.println("</li>");
				out.println("<li>");
					out.println("영어 : " + english);	
				out.println("</li>");
				out.println("<li>");
					out.println("수학 : " + math);	
				out.println("</li>");
				out.println("<li>");
					out.println("총점 : " + sum);	
				out.println("</li>");
				out.println("<li>");
					out.printf("평균 : %.2f", avg);	
				out.println("</li>");
				out.println("<li>");
					out.println("등급 : " + grade);	
				out.println("</li>");
			out.println("</ul>");
			
		out.println("</body>");
		out.println("</html>");
		    
		out.close();
	}
}
