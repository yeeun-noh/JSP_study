package unit05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String items[] = request.getParameterValues("item");
		
		PrintWriter out = response.getWriter();
		if(items == null) {
			out.print("선택하신 항목이 없습니다.");
		} else {
			out.print("당신이 선택한 정보입니다: <br>");
			for(String item : items) {
				out.print(item + " ");
			}
		}
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		doGet(request, response);
//	}

}
