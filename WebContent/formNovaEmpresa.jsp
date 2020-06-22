<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<%@ page import="br.com.alura.gerenciador.servlet.model.Empresa" %>

<%
	Boolean cadastrar = true;	
	Empresa empresa = new Empresa();
	String nomeEmpresa = (String) request.getAttribute("nomeEmpresa");
	
	if(request.getAttribute("empresa") != null){
		cadastrar = false;
		empresa = (Empresa) request.getAttribute("empresa");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de cadastro de empresas</title>
</head>
	<body>
		<%if(cadastrar){ %>
			<form action="${linkServletNovaEmpresa }" method="post">
				Nome: <input type="text" name="nome">
				<input type="submit" value="Cadastrar">
			</form>
		<%}else{ %>
			<form action="${linkServletNovaEmpresa }" method="post">
				Nome: <input type="text" name="nome" value="<%=empresa.getNome()%>">
				<input type="hidden" name="id" value="<%=empresa.getId()%>">
				<input type="submit" value="Atualizar">
				<input type="hidden" name="_method" value="PUT">
			</form>
		<%} %>
		
		<%if(nomeEmpresa != null){ %>
			<p>Empresa <%=nomeEmpresa %> cadastrada com sucesso</p>
		<%}%>
	</body>
</html>