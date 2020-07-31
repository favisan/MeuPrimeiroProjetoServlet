<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="com.treinamento.moduloweb.Loja"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Lista de Lojas</title>
</head>
<body>
	<br>
	<h3 style="text-align:center">CADASTRO DE FILIAIS</h3>
	<br>
	<table class="table" width="50%">
		<tr>
			<th>
				Código
			</th>
			<th>
				Nome
			</th>
			<th>
				Logomarca
			</th>
			<th>
				Cidade
			</th>
		</tr>
		
		<c:forEach var="loja" items="${lojas}">
				<tr>
					<td><c:out value="${loja.codigo}"></c:out>  </td>
					<td><c:out value="${loja.nome}"></c:out>  </td>
					<td><c:out value="${loja.logomarca}"></c:out>  </td>
					<td><c:out value="${loja.cidade}"></c:out>  </td>
					<td><fmt:formatDate value="${loja.dtInauguracao}" pattern="dd/MM/yyyy"/> </td>
					<td><button class="danger">Editar</button></td>
					<td><button class="danger">Excluir</button></td>
				</tr>
		</c:forEach>
	</table>
	
	<div>
		<button style="align-text:right" class="danger">Novo</button>
	</div>
</body>
</html>