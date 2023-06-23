package Jeju.Board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Jeju.Board.controller.action.Action;
import Jeju.fruit.DataDAO;
import Jeju.fruit.JejuFruitVO;

public class FruitListAction implements Action  {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Fruit_List.jsp";
		DataDAO ddao = DataDAO.getInstance();
		
		List<JejuFruitVO> FruitList = ddao.JejuFrultselectAll();
		
		request.setAttribute("FruitList", FruitList);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
