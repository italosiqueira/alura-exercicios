<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login - Curso Servlet Parte 1: Fundamentos da programação web Java</title>
</head>
<body>
<c:url value="/entrada" var="linkServletEntrada"/>
<form action="${linkServletEntrada}" method="POST">
		<div id="formLogin" style="align-content: center;">
			<div id="formLoginContent"  style="width: 50%; margin: 0 auto;">
				<input type="hidden" name="acao" value="Login">
			    Login: <input type="text" name="login"><br>
			    Senha: <input type="password" name="senha"><br> 
			    <input type="submit" value="Login">
		    </div>
		</div>
</form>
</body>
</html>