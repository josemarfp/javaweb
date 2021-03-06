<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!-- WEB-INF/tags/localdate.tag para formatar a localdate -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- https://www.apache.org/dist/tomcat/taglibs/taglibs-standard-1.2.5/README_bin.txt -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar contatos - TagLib</title>
		<link rel="stylesheet" href="css/estilos.css">		
		<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
	    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		
		<!-- A linha comentada serve pra lembrar como foi feita da primeira vez -->
		<!-- cria o DAO -->
		<!-- jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"/-->
		<a href="mvc?logica=AlteraContatoLogic&id=0&paramAltera=novo">Adicionar</a>
		<table>
			<caption>Contatos</caption>
			<tr>
				<th>Nome</th>
				<th>e-mail</th>
				<th>Endere�o</th>
				<th>Data de Nascimento</th>
				<th>A��o</th>
			</tr>	
			<!-- percorre contatos montando as linhas da tabela -->
			<c:forEach var="contato" items="${contatos}">
			
			<!-- A linha comentada serve pra lembrar como foi feita da primeira vez -->
			<!--c:forEach var="contato" items="${dao.lista}" -->
				<tr>
					<td>${contato.nome}</td>
					<td>
						<!-- tratamento especial para o campo e-mail -->
						<c:choose>
							<c:when test="${not empty contato.email}">
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:when>
							<c:otherwise>
								E-mail n�o informado
							</c:otherwise>
						</c:choose>
					</td>
					<td>${contato.endereco}</td>
					<td><tags:localdate date="${contato.dataNascimento}" pattern="dd/MM/yyyy"/></td>
					<td>						
						<a href="mvc?logica=AlteraContatoLogic&id=${contato.id}&paramAltera=popula">Alterar</a>
						<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
					</td>
					
				</tr>
			</c:forEach>
		</table>
		<c:import url="rodape.jsp" />
	</body>
</html>