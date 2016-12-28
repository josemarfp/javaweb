
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:import url="cabecalho.jsp"/>
Formulário para alteração de contatos:<br/>
<form action="mvc" method="POST">
    Id:
    <input type="text" name="id" value="${param.id}" readonly/><br/>
    Nome:
    <input type="text" name="nome" value="${param.nome}"/><br/>
    E-mail:
    <input type="text" name="email" value="${param.email}"/><br/>
    Endereço: <input type="text" name="endereco" value="${param.endereco}"/><br/>
    Data de Nascimento: <input type="text" name="dataNascimento" value="${param.dataNascimento}" />
    <input type="hidden" name="logica" value="AlteraContatoLogic"/>
    <input type="submit" value="Enviar"/>
</form>
<c:import url="rodape.jsp" />