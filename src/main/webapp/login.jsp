<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div style="text-align: center">
   		<h1>Login</h1>
		<p style="color: red;">
		<% if(request.getParameter("message") != null){ %>
			<%= request.getParameter("message") %>
		<% } %>
		</p>
		
   		<form action="login" method="post">
         		<label>Username: </label>
         		<input type="text" name="username"><br><br>

         		<label>Password: </label>
         		<input type="password" name="password"><br><br>
         		
   			<input type="submit" value="Submit"/>
   			<input type="reset" value="Reset"/>
   		</form>
	</div>
</body>
</html>