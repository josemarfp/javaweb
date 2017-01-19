<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!-- WEB-INF/tags/localdate.tag para formatar a localdate -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alterar Tarefa</title>
		<link rel="stylesheet" href="resources/css/estilos.css">		
		<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
	    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <script src="resources/js/script.js"></script>
        <script src="resources/js/jquery-3.1.1.js"></script>
        
        <script src="resources/js/jquery-ui.js"></script>
        <link rel="stylesheet" href="resources/css/jquery-ui.css">
        

    </head>
	<body>
		<h3>Alterar tarefa - ${tarefa.id}</h3>
		<form action="alteraTarefa" method="post" accept-charset="UTF-8">
			<input type="hidden" name="id" value="${tarefa.id}" />
			Descrição:<br />
			<textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
			<br />
			Finalizado? 
			<input type="checkbox" 
				name="finalizado"
				value="true" ${tarefa.finalizado? 'checked' : '' }/> <br />
			Data de finalização: <br />

			<input id="datepicker" type="text" name="dataFinalizacao" value="${tarefa.getDataFinalizacaoFormatada()}"/>
			
			<br />
			<input type="submit" value="Alterar"/>
		</form>
	</body>
</html>