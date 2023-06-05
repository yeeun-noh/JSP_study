<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<%! 
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pwd = "tiger";
	String sql = "select * from item";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>입력 완료된 정보</h3>
	<table border="1">
		<tr>
			<th>상품제목</th>
			<th>가격</th>
			<th>상품설명</th>
		</tr>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, pwd);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
	
		while(rs.next()) {
			out.println("<tr>");
			out.println("<td>" + rs.getString("name") + "</td>");
			out.println("<td>" + rs.getInt("price") + "</td>");
			out.println("<td>" + rs.getString("description") + "<br>" + "</td>");
			out.println("</tr>");
		}
	%>
	</table>
</body>
</html>