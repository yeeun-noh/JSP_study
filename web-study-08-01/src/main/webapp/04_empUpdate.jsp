<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSP파일 안에서 update하기 -->

<%@ page import="java.sql.*" %>

<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	String sql = "update emp set job = ? where job = 'Dog'";
	
	String job = "Cat";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<% 
 		try {
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 			
 			conn = DriverManager.getConnection(url, uid, pass);
 			
 			pstmt = conn.prepareStatement(sql);
 			
 			pstmt.setString(1, job);
 			
 			int result = pstmt.executeUpdate();
 			System.out.println(result);
 			
 		} catch(Exception e) {
			e.printStackTrace();

 		} finally {
 			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
 		}
 	%> 
</body>
</html>