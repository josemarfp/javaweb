<%@ page import="java.util.*,
br.com.caelum.jdbc.dao.*,
br.com.caelum.jdbc.model.*, java.time.format.DateTimeFormatter" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/estilos.css">		
		<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
    	<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<table>
			<caption>Contatos</caption>
			<tr>
				<th>Nome</th>
				<th>e-mail</th>
				<th>Endere�o</th>
				<th>Data de Nascimento</th>
			</tr>		
			<%
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");			
			
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			for (Contato contato : contatos ) {				
			%>
				<tr>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getEmail() %></td>
					<td><%=contato.getEndereco() %></td>
					<td><%=contato.getDataNascimento().format(formatter) %></td>
				</tr>
			<%
			}
			%>
		</table>
	</body>
</html>