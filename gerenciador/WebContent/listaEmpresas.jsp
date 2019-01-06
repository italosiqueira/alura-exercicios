<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.caelum.gerenciador.servlet.Empresa"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta empresas - Curso Servlet Parte 1: Fundamentos da programação web Java</title>
</head>
<body>
<%
	List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
%>

<ul>
<%
	for (Empresa empresa : lista) {
%>
	<li><%=empresa.getNome() %></li>
<%
	}
%>
</ul>
</body>
</html>