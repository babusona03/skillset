<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rock Paper Scissors</title>
</head>
<body>
	<h1>Enter your Choice!</h1>
	
	<form action="gamecontrol.do" method="post">
	<table border="1">
	
		<tr>	<th>Select Choice</th>			<th>Legend</th>	</tr>
		<tr>	<td align="right">Rock		</td>		<td><input type="radio" name="radio" value="rock" checked>	</td>		</tr>
		<tr>	<td align="right">Paper		</td>		<td><input type="radio" name="radio" value="paper">			</td>		</tr>
		<tr>	<td align="right">Scissors	</td>		<td><input type="radio" name="radio" value="scissors">		</td>		</tr>
		<tr>	<td align="center"><input type="submit" value="Fight"></td>		<td align="center"><input type="reset" value="Reset"></td>	</tr>
		</table>
	</form>
	<form action="index.jsp" method="get">
	<table border="1">		
		<tr>		<td align="right"><input type="submit" value="Back"></td>	</tr>
		
	</table>
	</form>	
	
		<form action="gamedata.do" method="post">
		<table border="1">		
			<tr>	<td align="right"><input type="submit" value="Hstr"></td></tr>		
		</table>
		</form>
	
</body>
</html>