<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="com.treinamento.moduloweb.Loja"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Lojas</title>
</head>
<body>

	<table>
		<th>
			<td>
				Código
			</td>
			<td>
				Nome
			</td>
			<td>
				Logomarca
			</td>
			<td>
				Cidade
			</td>
		</th>
		
		<c:forEach var="loja" items="${lojas}">
				<tr>
					<td><c:out value="${loja.codigo}"></c:out>  </td>
					<td><c:out value="${loja.nome}"></c:out>  </td>
					<td><c:out value="${loja.logomarca}"></c:out>  </td>
					<td><c:out value="${loja.cidade}"></c:out>  </td>
					<td><fmt:formatDate value="${loja.dtInauguracao}" pattern="dd/MM/yyyy"/> </td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>