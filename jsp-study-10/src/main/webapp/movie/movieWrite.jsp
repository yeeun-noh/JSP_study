<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/movie.css"> 
</head>
<body>
	<div id="wrap" align="center">
		<h1>정보 등록</h1>
		<form method="post" enctype="multipart/form-data" name="frm">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" size="80"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price">원</td>
				</tr>
				<tr>
					<th>감독</th>
					<td><input type="text" name="director" size="80"></td>
				</tr>
				<tr>
					<th>배우</th>
					<td><input type="text" name="actor" size="80"></td>
				</tr>
				<tr>
					<th>설명</th>
					<td><textarea cols="100" rows="10" name="synopsis"></textarea></td>
				</tr>
				<tr>
					<th>사진</th>
					<td>
						<input type="file" name="poster"><br>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="확인" onclick="return movieCheck()">
			<input type="reset" value="취소">
			<input type="button" value="목록" onclick="location.href='movieList.do'">
			
		</form>  
	</div>
</body>
</html>