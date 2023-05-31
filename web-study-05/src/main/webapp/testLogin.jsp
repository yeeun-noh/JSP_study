<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.net.*" %>

<%
	//실제로는 DB에서 가져와야 하는값:
	String id = "yeeun";
	String pwd = "1234";
	String name = "노예은";
	
	if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))) {
		//id, pwd가 같을때만 쿠키 생성하고 client에 추가:
		//1. Cookie 객체 생성(username에 노예은을 맵핑)
		Cookie c = new Cookie("username", URLEncoder.encode(name, "utf-8"));
		
		//2. 속성 부여:
		c.setMaxAge(365*24*60*60);
		
		//3. 클라이언트에 전송:
		response.addCookie(c);
%>
	<h2>성공적으로 로그인하셨습니다.</h2>
	<p><a href="main.jsp">들어가기</a>

<%
	} else {
%>
	<h2>로그인에 실패하셨습니다.</h2>
	<p><a href="loginForm.jsp">되돌아가기</a>
<%
	}
%>