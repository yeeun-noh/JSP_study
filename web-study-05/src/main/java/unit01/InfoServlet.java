package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
//	doGet메서드에는 "UTF-8"가 포함되어있음!
//	=>쓸필요x: request.setCharacterEncoding("UTF-8");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		PrintWriter out = response.getWriter();
		out.print("당신이 입력한 정보입니다: <br>");
		out.print("이름 : " + name + "<br>");
		out.print("주소 : " + address);
		
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
