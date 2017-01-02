package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class ListaContatosLogic implements Logica {
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Connection connection = (Connection) req.getAttribute("conexao");
		
		// passe a conex�o no construtor
		ContatoDao dao = new ContatoDao(connection);	
		
		// Monta a lista de contatos
		List<Contato> contatos = dao.getLista();
		
		// Guarda a lista no request
		req.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}
}