package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dto.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/movieUpdate.do")
public class MovieUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO vo = mDao.getList(code);
		
		request.setAttribute("movie", vo);
		String url = "movie/movieUpdate.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("images");
		String encType = "utf-8";
		int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy() );
		
		int code = Integer.parseInt(multi.getParameter("code"));
		String title = multi.getParameter("title");
		int price = Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String poster = multi.getFilesystemName("poster");
		String synopsis = multi.getParameter("synopsis");
		
		if(poster == null) {
			poster = multi.getParameter("nonmakeImg");
		}
		
		MemberVO vo = new MemberVO();
		vo.setCode(code);
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setDirector(director);
		vo.setActor(actor);
		vo.setPoster(poster);
		vo.setSynopsis(synopsis);
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMovie(vo);
		response.sendRedirect("movieList.do");
	}
}
