function finalizaAgora(id) {
	$.get("finalizaTarefa?id=" + id);
}

function datepicker() {
    $( "#datepicker" ).datepicker();
}