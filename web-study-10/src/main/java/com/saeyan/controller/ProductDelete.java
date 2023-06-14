package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dto.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productDelete.do")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO vo = pDao.getList(code);

		request.setAttribute("product", vo);
		String url = "product/productDelete.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ProductVO vo = new ProductVO();
		ProductDAO pDao = ProductDAO.getInstance();
		
		int code = Integer.parseInt(request.getParameter("code"));
		int result = pDao.DeleteProduct(code);
				
		if(result==1) {
			response.sendRedirect("productList.do");
		}
	}

}
