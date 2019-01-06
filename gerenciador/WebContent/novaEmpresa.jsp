<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nova Empresa - Curso Servlet Parte 1: Fundamentos da programação web Java</title>
</head>
<body>
<% 
	String nome = (String) request.getAttribute("nomeEmpresa");
%>

<p>Empresa <%=nome %> cadastrada com sucesso!</p>
</body>
</html>