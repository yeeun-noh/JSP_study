<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	String sql = "select * from emp";
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
			//드라이브로드:
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//데이터베이스 연결:
			conn = DriverManager.getConnection(url, uid, pass);
			
			//데이터베이스 sql문장 쓰기:
			pstmt = conn.prepareStatement(sql);
			
			//데이터베이스 sql문장 실행, 실행결과를 rs가 참조:
			rs = pstmt.executeQuery();
           
			//하나씩 출력:
            while(rs.next()){     
    			out.println(rs.getInt("empno"));
    			out.println(rs.getString("ename"));
    			out.println(rs.getString("job"));
    			out.println(rs.getInt("mgr"));
    			out.println(rs.getString("hiredate"));
    			out.println(rs.getInt("sal"));
    			out.println(rs.getInt("comm"));
    			out.println(rs.getInt("deptno"));
    			out.println("<br>");
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>