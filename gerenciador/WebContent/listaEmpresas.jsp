<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.caelum.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta empresas - Curso Servlet Parte 1: Fundamentos da programação web Java</title>
</head>
<body>
<c:url value="/removeEmpresa" var="linkServletRemoveEmpresa"/>
<c:url value="/mostraEmpresa" var="linkServletMostraEmpresa"/>

<c:if test="${not empty nomeEmpresa }">
	<p>Empresa ${nomeEmpresa} cadastrada com sucesso!</p>
</c:if>
<p>Lista de empresas:</p>
<ul>
<c:forEach items="${empresas}" var="empresa">
	<li>${empresa.nome} - <f:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
	<a href="${linkServletMostraEmpresa}?id=${empresa.id}">Altera</a>
	<a href="${linkServletRemoveEmpresa}?id=${empresa.id}">Remove</a>
	</li>
</c:forEach>
</ul>
</body>
</html>