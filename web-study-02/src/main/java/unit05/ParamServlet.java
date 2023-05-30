package unit05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		String age = request.getParameter("age");
		
		PrintWriter out = response.getWriter();
		out.print("id와 나이 입니다: <br>");
		out.print(id + "<br>");
		out.print(age);

//		자바스크립트로 이전페이지로 이동하는 링크를 만들어줌:
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
	}

}
