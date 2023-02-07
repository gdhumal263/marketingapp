<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead</title>
</head>
<body>
<h2>create Lead</h2>
	<form action="saveLead" method="post">
		
			First Name:<input type="text" name="firstName"/>
			Last Name:<input type="text" name="lastName"/>
			Email:<input type="text" name="email"/>
			Mobile:<input type="text" name="mobile"/>
			<input type="submit" value="save">
		
	</form>
	${msg}
</body>
</html>