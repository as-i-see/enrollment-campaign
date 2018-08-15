<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start page</title>
</head>
<body>
	<h1>List of online accounts:</h1>
	<c:forEach var="acc" items="${onlineAccounts}">
	 <h3>${acc}</h3>
	</c:forEach>
</body>
</html>