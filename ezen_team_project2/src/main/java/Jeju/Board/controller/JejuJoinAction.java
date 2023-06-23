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

public class JejuJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "Jeju_Join.jsp";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String postcode = request.getParameter("postcode");
		String address = request.getParameter("address");
		String rank = "0";
		
		MemberVo vo = new MemberVo();
		
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setNickname(nickname);
		vo.setPhone(phone);
		vo.setPostcode(postcode);
		vo.setAddress(address);
		vo.setRank(rank);
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMember(vo);
		
		HttpSession session = request.getSession();
		if(result == 1) {
			session.setAttribute("userid", vo.getEmail());
			request.setAttribute("message", "회원가입 성공");
			url = "Jeju_Login.jsp";
		}else {
			request.setAttribute("message", "회원 가입 실패");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		}
}
