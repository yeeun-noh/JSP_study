<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" name="frm">
		<br><br>
		<table align="center" width="550">
			<tr>
				<td colspan="2">마이페이지</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value="${loginUser.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" value="${loginUser.pass}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${loginUser.name}"></td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<select name="lev">
						<c:choose>
							<c:when test="${result==2}">
								<option value="A" selected="selected">운영자</option>
								<option value="B">일반회원</option>
							</c:when>
							<c:when test="${result==3}">
								<option value="A">운영자</option>
								<option value="B" selected="selected">일반회원</option>
							</c:when>
						</c:choose>
					</select>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<select name="gender">
						<c:choose>
							<c:when test="${loginUser.gender==1}">
								<option value="1" selected="selected">남자</option>
								<option value="2">여자</option>
							</c:when>
							<c:when test="${loginUser.gender==2}">
								<option value="1">남자</option>
								<option value="2" selected="selected">여자</option>
							</c:when>
						</c:choose>
					</select>
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input tyep="text" name="phone" value="${loginUser.phone}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" >&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>