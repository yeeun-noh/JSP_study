package Jeju.Board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jeju.Board.controller.action.Action;

public class JejuJoinFormAction implements Action {

	@Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //JejuServlet?command=Jeju_check_pass_form&event_index=1
	      String url = "Jeju_Join.jsp";      
	      RequestDispatcher dis = request.getRequestDispatcher(url);
	      dis.forward(request, response);
	}
}