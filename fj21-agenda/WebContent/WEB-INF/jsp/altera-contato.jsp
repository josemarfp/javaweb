
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:import url="cabecalho.jsp"/>
Formul�rio para altera��o de contatos:<br/>

<!-- mvc � o nome da servlet que controla este form -->
<!-- requestScope.xxx l� um atributo do formul�rio, o qual � diferente de um parametro} -->
<form action="mvc" method="POST">
    Id:
    <input type="text" name="id" value="${requestScope.id}" readonly/><br/>
    Nome:
    <input type="text" name="nome" value="${requestScope.nome}"/><br/>
    E-mail:
    <input type="text" name="email" value="${requestScope.email}"/><br/>
    Endere�o: <input type="text" name="endereco" value="${requestScope.endereco}"/><br/>
    Data de Nascimento: <input type="text" name="dataNascimento" value="${requestScope.dataNascimento}" />
    
    <!-- monta a url de chamada da logica que processa o form -->
    <input type="hidden" name="logica" value="AlteraContatoLogic"/>
    <input type="hidden" name="paramAltera" value="altera"/><br>
    <input type="submit" value="Enviar"/>
</form>
<c:import url="rodape.jsp" />