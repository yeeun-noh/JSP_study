<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSP파일 안에서 insert하기 -->

<%@ page import="java.sql.*" %>

<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
	
	int empno = 1112;
	String ename = "Roy";
	String job = "Dog";
	int mgr = 0000;
	String hiredate = "23/06/05";
	int sal = 1000;
	int comm = 100;
	int deptno = 20;
	
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
 			
 			pstmt.setInt(1, empno);
 			pstmt.setString(2, ename);
 			pstmt.setString(3, job);
 			pstmt.setInt(4, mgr);
 			pstmt.setString(5,hiredate);
 			pstmt.setInt(6, sal);
 			pstmt.setInt(7, comm);
 			pstmt.setInt(8, deptno);
 			
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