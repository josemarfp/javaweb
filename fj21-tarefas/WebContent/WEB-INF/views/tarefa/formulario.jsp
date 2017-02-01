<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="resources/css/estilos.css">
		
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  		<link rel="stylesheet" href="/resources/demos/style.css">
  		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  		
		<title>Adicionar Tarefa</title>
	</head>
	<body>
		<h3>Adicionar tarefas</h3>
		<form:errors path="tarefa.descricao"/>
		<form action="adicionaTarefa" method="post">
			Descrição: <br />
			<textarea name="descricao" rows="5" cols="100"></textarea><br />
			<input type="submit" value="Adicionar">
		</form>
	</body>
</html>