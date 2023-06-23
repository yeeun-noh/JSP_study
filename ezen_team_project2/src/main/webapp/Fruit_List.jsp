<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">

</head>
<body>
   <div id="wrap" align="center">
      <h1>게시글 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right">
         </tr>
         <tr>
            <th>번호</th>
            <th>사진</th>
            <th>설명</th>
            <th>가격</th>
         </tr>
         <c:forEach var="fruit" items="${FruitList}">
            <tr class="record">
               <td>${fruit.no}</td>
               <td><${fruit.poster} </a></td>
               <td>${fruit.description}</td>
               <td>${fruit.price}</td>
            </tr>
         </c:forEach>
      </table>
   </div>
</body>
</html>