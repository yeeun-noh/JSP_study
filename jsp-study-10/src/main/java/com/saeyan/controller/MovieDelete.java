package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/movieDelete.do")
public class MovieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO vo = mDao.getList(code);
		
		request.setAttribute("movie", vo);
		String url = "movie/movieDelete.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		MemberVO vo = new MemberVO();
		MemberDAO mDao = MemberDAO.getInstance();
		
		int code = Integer.parseInt(request.getParameter("code"));
		int result = mDao.deleteMovie(code);
		
		response.sendRedirect("movieList.do");
	}

}
