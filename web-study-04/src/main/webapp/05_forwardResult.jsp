<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String age = request.getParameter("age");
	String name = (String)request.getAttribute("name");
	String address = (String)request.getAttribute("addr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor=pink>
	forward 방식으로 이동된 페이지 <br>
	나이 : <%=age %>
	<br>
	이름 : <%=name %>
	<br>
	주소 : <%=address %>
</body>
</html>