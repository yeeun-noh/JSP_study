<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] movieList = {"타이타닉", "시네마천국", "혹성탈출", "킹콩"};
		pageContext.setAttribute("movieList", movieList);
	%>
	<table border="1" style="width:100%; text-align:center;">
		<tr>
			<th> index </th> <th> count </th> <th> title </th> 
		</tr>
		
		<c:forEach var="movie" items="${movieList}" varStatus="status">
			<tr>
				<td> ${status.index} </td> <!-- 현재 반복중인 항목의 index를 알려줌(0부터시작) -->
				<td> ${status.count} </td> <!-- 몇번째 반복 중인지 알려줌(1부터시작) -->
				<td> ${movie} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>