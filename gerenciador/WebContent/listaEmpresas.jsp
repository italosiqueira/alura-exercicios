<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.caelum.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta empresas - Curso Servlet Parte 1: Fundamentos da programa��o web Java</title>
</head>
<body>
<ul>
<c:forEach items="${empresas}" var="empresa">
	<li>${empresa.nome}</li>
</c:forEach>
</ul>
</body>
</html>