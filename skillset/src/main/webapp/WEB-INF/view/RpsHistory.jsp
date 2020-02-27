<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
   
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rock Paper Scissor Game History</title>
</head>
<body>
<h1>Result from RPS Database</h1>
<br/><br/>
<h3><a href=<c:url value="index.jsp" />>Back To Main</a></h3>

<table>
		<tr>
			<th><h3>SERIAL</h3></th><th><h3>UserChoice</h3></th><th><h3>SystemChoice</h3></th><th><h3>Winner</h3></th><th><h3>TimeStamp</h3></th>
		</tr>

	
		<c:forEach var="listItem" items="${result}" >
			
			<tr>
			<td><c:out value='${listItem.serial 	}' 	default="No Data." ></c:out></td>
			<td><c:out value='${listItem.userChoice	}'	default="No Data." ></c:out></td>
			<td><c:out value='${listItem.systemChoice }' 	default="No Data." ></c:out></td>
			<td><c:out value='${listItem.winner	}'	default="No Data." ></c:out></td>
			<td><c:out value='${listItem.timeStamp	}'	default="No Data." ></c:out></td>
			</tr>		
		</c:forEach>		
	</table>
</body>
</html>