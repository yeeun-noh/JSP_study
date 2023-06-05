<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EMP 테이블 FORM</h2>
	<form method="post" action="02_02_empInsert.jsp">
		<table>
			<tr>
				<td>empno: </td>
				<td><input type="text" name="empno" size="20"></td>
			</tr>
			<tr>
				<td>ename: </td>
				<td><input type="text" name="ename" size="20"></td>
			</tr>
			<tr>
				<td>job: </td>
				<td><input type="text" name="job" size="20"></td>
			</tr>
			<tr>
				<td>mgr: </td>
				<td><input type="text" name="mgr" size="20"></td>
			</tr>
			<tr>
				<td>hiredate: </td>
				<td><input type="text" name="hiredate" size="20"></td>
			</tr>
			<tr>
				<td>sal: </td>
				<td><input type="text" name="sal" size="20"></td>
			</tr>
			<tr>
				<td>comm: </td>
				<td><input type="text" name="comm" size="20"></td>
			</tr>
			<tr>
				<td>deptno: </td>
				<td><input type="text" name="deptno" size="20"></td>
			</tr>
			<tr>
				<td><input type="submit" value="전송"></td>
				<td><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>