<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário Editar Empresa - Curso Servlet Parte 1: Fundamentos da programação web Java</title>
</head>
<body>
<c:url value="/alteraEmpresa" var="linkServletAlteraEmpresa"/>
<form action="${linkServletAlteraEmpresa}" method="post">
<input type="hidden" name="id" value="${empresa.id}">
Nome: <input type="text" name="nome" value="${empresa.nome}">
Data Abertura: <input type="text" name="dataAbertura" value="<f:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" type="date"/>">
<input type="submit" value="Alterar">
</form>
</body>
</html>