<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
- 선언(declaration): 변수와 메서드를 선언함 => <%! %>
--%>
<%!
	String str = "안녕하세요";
	int a = 5, b = -5;
	
	public int abs(int n) {
		return n>0 ? n : -n;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
- 스크립트릿(scriptlet)	: 자바코드를 기술함 => <% %>
--%>
	<%
		out.print(str + "<br>");
		out.print(a + "절대값: " + abs(a) + "<br>");
		out.print(b + "절대값: " + abs(b) + "<br>");
	%>
<%--
- 표현식(expression): 계산식이나 함수를 호출한 결과를 문자열 형태로 출력함 => <%= %>
--%>
	<%= str %><br>
	<%= a %> 절대값 : <%= abs(a) %><br>
	<%= b %> 절대값 : <%= abs(b) %><br>
</body>
</html>