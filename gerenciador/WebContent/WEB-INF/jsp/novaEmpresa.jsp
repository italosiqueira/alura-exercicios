<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nova Empresa - Curso Servlet Parte 1: Fundamentos da programação web Java</title>
</head>
<body>

<c:if test="${not empty nomeEmpresa }">
	<p>Empresa ${nomeEmpresa} cadastrada com sucesso!</p>
</c:if>

<c:if test="${empty nomeEmpresa }">
	<p>Nenhuma empresa cadastrada!</p>
</c:if>
</body>
</html>