<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<sql:query var="rs" dataSource="jdbc/enrollmentDB">
    SELECT * FROM subject
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start page</title>
</head>
<body>
	<h1>List of subjects:</h1>
    <c:forEach var="row" items="${rs.rows}">
        ${row.name}
    </c:forEach>
</body>
</html>