<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.model.Empresa,br.com.alura.gerenciador.model.Banco" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?parametro=RemoveEmpresa" var="linkServletRemoveEmpresa"/>
<c:url value="/entrada?parametro=AlteraEmpresa" var="linkServletAlteraEmpresa"/>
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
			Nome: <%=empresa.getNome()%> Cadastro: <%=empresa.getDataCadastro()%> Status: <%=empresa.getStatus()%>
			<a href="${linkServletAlteraEmpresa}&id=<%=empresa.getId()%>">Alterar</a>.
			<a href="${linkServletRemoveEmpresa}&id=<%=empresa.getId()%>">Remover</a>.
		</li>	
	<%}%>
	</ul>
</body>
</html>