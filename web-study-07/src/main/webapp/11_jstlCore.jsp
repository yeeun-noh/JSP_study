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
	<c:set var="msg" value="Hello"></c:set>
	\${msg} = ${msg} <br>
	
	<c:set var="age">30</c:set>
	\${age} = ${age} <hr>
	
	<c:set var="member" value="<%= new com.saeyan.javabeans.MemberBean() %>"></c:set>
	<c:set target="${member}" property="name" value="노예은"></c:set>
	<c:set target="${member}" property="userid">yeeun1</c:set>
	\${member} = ${member} <br>
	\${member.name} = ${member.name} <br>
	\${member.userid} = ${member.userid} <br>
	\${member.email} = ${member.email} <hr>
	
	<c:set var="add" value="${10 + 5}"></c:set>
	\${add} = ${add} <br>
	
	<c:set var="flag">${10 > 5}</c:set>
	\${flag} = ${flag} <br>
	
</body>
</html>