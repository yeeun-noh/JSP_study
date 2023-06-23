package Jeju.Board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Jeju.Board.controller.action.Action;
import Jeju.user.dao.MemberDAO;
import Jeju.user.dto.MemberVo;

public class JejuLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberVo vo = new MemberVo();

		String url = "Jeju_Login.jsp";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(email, password);

		if (result == 1) {

			MemberVo mVo = mDao.getMember(email);

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			request.setAttribute("message", "로그인 성공");
			url = "Jeju_Main.jsp";

		} else if (result == 0) {
			request.setAttribute("userid", email);
			request.setAttribute("message", "비번 불일치");

		} else {
			request.setAttribute("message", "존재하지 않는 아이디");
		}
		
		System.out.println(result);
		System.out.println(email);
		System.out.println(password);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
