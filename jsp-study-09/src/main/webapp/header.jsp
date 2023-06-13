<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td {
		border: 1px solid black;
		width : 250px;
		text-align: center;
	}
</style>
</head>
<body>
	<table class="mainmenu" align="center">
		<c:if test="${empty loginUser}">
			<tr>
				<td></td><td></td>
				<td class="login"><a name="login" href="login.do" style="text-decoration:none;">로그인</a>
				<td> 사원등록<br>
					<span style="color:red">(관리자로 로그인 후 사용가능)</span>
				</td>
				<td>마이페이지<br>
					<span style="color:red">(로그인 후 사용가능)</span>
				</td>
			</tr>
		</c:if>
	
		<c:if test="${!empty loginUser}">
			<tr>
				<td>${loginUser.name}님 반갑습니다.</td>
				<td>레벨 : ${loginUser.lev}</td>
				<td class="login"><a href="logout.do" style="text-decoration:none;">로그아웃</a>
				
				<c:choose>
					<c:when test="${result==2}">
						<td><a href="custom.do" style="text-decoration:none;">사원등록</a></td>
					</c:when>
					
					<c:when test="${result==3}">
						<td>사원등록<br>
							<span style="color:red">(관리자로 로그인 후 사용가능)</span>
						</td>
					</c:when>
				</c:choose>
			
				<td>
					<a href="mypage.do" style="text-decoration:none;">마이페이지</a>
				</td>
			</tr>
		</c:if>
	
	</table>
</body>
</html>