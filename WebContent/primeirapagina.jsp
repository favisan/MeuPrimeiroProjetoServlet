<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Minha primeira pagina</title>
</head>

<body>
	
	<h1> ${mensagem} </h1>
	<%
		for(int i=1;i<=10;i++){
			out.println(i);
		}
	%>

</body>
</html>