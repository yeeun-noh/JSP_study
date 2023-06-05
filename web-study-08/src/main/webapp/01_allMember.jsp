<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>

<%! 
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pwd = "tiger";
	String sql = "select * from member";
//	String sql = "insert into member values('강현승', 'liver', '1234', 'liver@naver.com', '010-1111-2222', 0)";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");	//jdbc 드라이버 로드
		conn = DriverManager.getConnection(url, uid, pwd);	//연결
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
	//	int num = stmt.executeUpdate(sql);	
	
		while(rs.next()) {
			out.println(rs.getString("name"));
			out.println(rs.getString("userid"));
			out.println(rs.getString("pwd"));
			out.println(rs.getString("email"));
			out.println(rs.getString("phone"));
			out.println(rs.getInt("admin") + "<br>");
		}
		
	//	out.println("num: " + num);
		out.println("출력 완료");
	%>
</body>
</html>