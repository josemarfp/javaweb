<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html xmlns:th="http://www.thymeleaf.org">

<html>
	<body>
		<a href="novaTarefa">Criar nova tarefa</a>
		<br /> <br />
		<table>
			<tr>
				<th>Id</th>
				<th>Descri��o</th>
				<th>Finalizado?</th>
				<th>Data de finaliza��o</th>
			</tr>
			<!-- 
			<th:each="tarefa: ${tarefas}">
				<tr>
					<td>${{tarefa.id}}</td>
					<td>${{tarefa.descricao}}</td>

				</tr>
			</th:each>
			 -->
		</table>
	</body>
</html>