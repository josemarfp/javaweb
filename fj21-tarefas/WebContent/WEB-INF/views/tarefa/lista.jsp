<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!-- WEB-INF/tags/localdate.tag para formatar a localdate -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de tarefas</title>
		<link rel="stylesheet" href="resources/css/estilos.css">		
		<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
	    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        
    </head>
	<body>
		<c:import url="cabecalho.jsp" />
		
		<a href="novaTarefa">Criar nova tarefa</a>
		<br /> <br />		
		<table>
			<tr>
				<th>Id</th>
				<th>Descri��o</th>
				<th>Finalizado?</th>
				<th>Data de finaliza��o</th>
			</tr>
			
			<c:forEach var="tarefa" items="${tarefas}" >
				<tr>
					<td><c:out value="${tarefa.id}"/></td>
					<td><c:out value="${tarefa.descricao}"/></td>
					<c:if test="${tarefa.finalizado eq false}">
						<td>N�o finalizado</td>
					</c:if>
					<c:if test="${tarefa.finalizado eq true}">
						<td>Finalizado</td>
					</c:if>
					<td><c:out value="${tarefa.dataFinalizacao}"/></td>
	        		<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
	        		<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>					
				</tr>
			</c:forEach>			 
		</table>
		
		<c:import url="rodape.jsp" />
	</body>
</html>