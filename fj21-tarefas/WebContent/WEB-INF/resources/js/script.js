function finalizaAgora(id) {
	$.post("finalizaTarefa", {'id' : id}, function(resposta) {
		$("#tarefa_"+id).html(resposta);
	});
}

function datepicker() {
    $("#datepicker").datepicker();
}