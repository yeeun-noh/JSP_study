<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean" />
	<hr>
	자바빈 객체 생성후 저장된 정보 출력 <br>

	이름 : <jsp:getProperty property="name" name="member" /> <br>
	아이디 : <jsp:getProperty property="userid" name="member" /> <br>

	자바빈 변경후 변경된 내용 출력 <br>
	<jsp:setProperty property="name" name="member" value="노예은" />
	<jsp:setProperty property="userid" name="member" value="yeeun" />
	
	이름 : <jsp:getProperty property="name" name="member" /> <br>
	아이디 : <jsp:getProperty property="userid" name="member" /> <br>

</body>
</html>