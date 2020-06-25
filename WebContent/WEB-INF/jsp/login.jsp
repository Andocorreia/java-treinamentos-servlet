<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkLogin"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkLogin }" method="post">
		Usuario: <input type="text" name="usuario">
		Senha: <input type="password" name="senha">
		<input type="hidden" name="parametro" value="Login">
		<input type="submit" value="Login">
	</form>

</body>
</html>