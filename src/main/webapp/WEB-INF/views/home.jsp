<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="./qna/qnaList">Qna List</a>

<c:choose>
	<c:when test="${not empty member}">
		<h3><spring:message code="login.message" arguments="${member.id},myHome" argumentSeparator=","/></h3>
		<a href="./member/memberLogout">logout</a>
		<a href="./cart/cartList">Cart LIst</a>
		
		<c:if test="${member.grade eq '0'}">
			<a href="./member/memberAdmin">Admin Page</a>
			
		</c:if>
	</c:when>
	<c:otherwise>
		<a href="./member/memberJoin">Join</a>
		<a href="./member/memberLogin">Login</a>
	</c:otherwise>
</c:choose>

<a href="./mall/productWrite">Product Write</a>
<a href="./mall/productList">Product List</a>

</body>
</html>
