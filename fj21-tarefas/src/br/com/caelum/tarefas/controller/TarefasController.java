package br.com.caelum.tarefas.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.caelum.jdbc.dao.JdbcTarefaDao;
import br.com.caelum.jdbc.modelo.Tarefa;

@Controller
public class TarefasController {
	
	private final JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		this.dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		
		List<Tarefa> tarefas = this.dao.lista();
		model.addAttribute("tarefas", tarefas);
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		
		this.dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) throws IOException {
		
		this.dao.finaliza(id);
		Tarefa tarefa = dao.consulta(id);
		model.addAttribute("tarefa", tarefa);
		
		return "tarefa/finalizada";
	}	
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		
		model.addAttribute("tarefa", this.dao.consulta(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		
		this.dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
}