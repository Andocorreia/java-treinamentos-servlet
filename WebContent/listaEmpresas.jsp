<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.servlet.model.Empresa,br.com.alura.gerenciador.servlet.model.Banco" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/removeEmpresa" var="linkServletRemoveEmpresa"/>
<c:url value="/alteraEmpresa" var="linkServletAlteraEmpresa"/>
<% List<Empresa> empresas = new Banco().getEmpresas();%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresas cadastradas</title>
</head>
<body>
	<ul>
	<%for(int i = 0; i < empresas.size(); i++){
		Empresa empresa = empresas.get(i);
	%>	
		<li>
			Nome: <%=empresa.getNome()%> Cadastro: <%=empresa.getDataCadastro()%> 
			<a href="${linkServletAlteraEmpresa}?id=<%=empresa.getId()%>">Alterar</a>.
			<a href="${linkServletRemoveEmpresa}?id=<%=empresa.getId()%>">Remover</a>.
		</li>	
	<%}%>
	</ul>
</body>
</html>