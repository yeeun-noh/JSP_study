package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/method01")
public class method01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
	
//		(1) survlet을 통해서만 출력:
//		PrintWriter out = response.getWriter();
//		out.print("이름: " + name + "<br>");
//		out.print("나이: " + age + "<br>");
//		out.close();

//		(2) jsp를 통해서 출력:
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		
		RequestDispatcher dis = request.getRequestDispatcher("method.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
