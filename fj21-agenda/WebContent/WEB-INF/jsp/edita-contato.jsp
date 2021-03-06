<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!-- WEB-INF/tags/localdate.tag para formatar a localdate -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- https://www.apache.org/dist/tomcat/taglibs/taglibs-standard-1.2.5/README_bin.txt -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edita contato</title>
		<link rel="stylesheet" href="css/estilos.css">		
		<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
	    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
		
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
		<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
	</head>
	<body>
		<c:import url="cabecalho.jsp" />
		
		<form>
			Nome: <input type="text" name="nome" /><br />
			E-mail: <input type="text" name="email" /><br />
			Endere�o: <input type="text" name="endereco" /><br />
			Data de Nascimento: <tags:campodata id="dataNascimento" /><br />
			<input type="submit" value="Gravar"/>
		</form>
		
		<c:import url="rodape.jsp" />
	</body>
</html>




