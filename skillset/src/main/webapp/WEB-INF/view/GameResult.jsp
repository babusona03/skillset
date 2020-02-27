<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RPS Game Result</title>
</head>
<body>
	<p align="center">
		<c:out value='${requestScope.gameResultStatus}' default="No Data"></c:out>
		<c:out value='${requestScope.winner}' 	default="No Data." ></c:out>
		<h3><a href=<c:url value="index.jsp" />>Back To Main</a></h3>	
</body>
</html>