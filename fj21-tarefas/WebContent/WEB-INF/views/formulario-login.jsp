<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" href="resources/css/estilos.css">		
		<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
	    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<h2>Página de Login das Tarefas</h2>
		<form action="efetuaLogin" method="post">
			Login: <input type="text" name="login" /> <br />
			Senha: <input type="password" name="senha" /> <br />
			<input type="submit" value="Entrar nas tarefas" />
		</form>
	</body>
</html>