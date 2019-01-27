<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário Nova Empresa - Curso Servlet Parte 1: Fundamentos da programação web Java</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
<c:url value="/entrada" var="linkServletEntrada"/>
<form action="${linkServletEntrada}" method="POST">
	<input type="hidden" name="acao" value="NovaEmpresa">
    Nome: <input type="text" name="nome"><br>
    Data de Abertura: <input type="text" name="data"><br> 
    <input type="submit" value="Criar">
</form>
</body>
</html>