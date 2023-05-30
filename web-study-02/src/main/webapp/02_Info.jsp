<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src=Info.js></script>
</head>
<body>
	<form name="frm" method="get" action="InfoServlet">
		이름 : <input type="text" name="name"><br>
		주소 : <input type="text" name="address"><br>
		<input type="submit" name="전송" onclick="return check()">
	</form>
	<br>
	<form name="frm2" method="post" action="InfoServlet">
		이름 : <input type="text" name="name"><br>
		주소 : <input type="text" name="address"><br>
		<input type="submit" name="전송" onclick="return check2()">
	</form>
</body>
</html>