<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.magic.dto.EmployeesDAO" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		EmployeesDAO emDao = EmployeesDAO.getInstance();
		Connection conn = emDao.getConnection();
		out.println("DBCP 연동 성공");
	%>
</body>
</html>