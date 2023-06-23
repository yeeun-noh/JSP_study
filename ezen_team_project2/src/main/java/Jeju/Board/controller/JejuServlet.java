package Jeju.Board.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jeju.Board.controller.action.Action;

@WebServlet("/Servlet")
public class JejuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     //노출되어도 되니까 select , insert나 delete 아님   값을 조회 할 때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String command = request.getParameter("command");
//		System.out.println("command : " + command);
	
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command); // new JejuListAction();
	
	if(action !=null) {
		action.execute(request, response); //자기가 받은 요청을 request에 저장, response로 실행
	}	
	} //insert , delete 등은 post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
