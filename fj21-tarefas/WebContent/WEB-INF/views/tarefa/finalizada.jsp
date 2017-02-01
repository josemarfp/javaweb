<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tr id="tarefa_${tarefa.id}">
	<td><c:out value="${tarefa.id}"/></td>
	<td><c:out value="${tarefa.descricao}"/></td>
	<c:if test="${tarefa.finalizado eq false}">
		<td><a href="#" onclick="finalizaAgora(${tarefa.id})">Finalizar agora</a></td>						
	</c:if>
	<c:if test="${tarefa.finalizado eq true}">
		<td>Finalizado</td>
	</c:if>
	<td>${tarefa.getDataFinalizacaoFormatada()}</td>
	<td>
		<a href="mostraTarefa?id=${tarefa.id}">Alterar</a>
		<a href="removeTarefa?id=${tarefa.id}">Remover</a>
	</td>
</tr>					
				

