<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de funcionários</title>
</head>
<body>
	<h1>${titulo}</h1>
	<table>
	<% 
		List<String> funcionarios = new ArrayList<String>();
		funcionarios = (List) request.getAttribute("funcionarios");
		for(String funcionario : funcionarios){
		%>
			<tr>
				<td><b><% out.println(funcionario); %></b>
				</td>
			</tr>
		<%
		}
		%>
	
	</table>
</body>
</html>