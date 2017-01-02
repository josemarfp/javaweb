package br.com.caelum.mvc.logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class AlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
				
		String tipo = req.getParameter("paramAltera");
		
		switch (tipo) {
			case "altera" : {
				this.altera(req, res);
				return "mvc?logica=ListaContatosLogic";			
			}
			case "popula" : {							
				this.popula(req, res);				
				return "/WEB-INF/jsp/altera-contato.jsp";
			}
			default: {
				return "/WEB-INF/jsp/adiciona-contato.jsp";
			}	
		}
	}

	public void popula(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));

		System.out.println("buscando o contato:" + id);
		
		ContatoDao dao = new ContatoDao();
		contato = dao.consulta(id);
		
		req.setAttribute("id", contato.getId());
		req.setAttribute("nome", contato.getNome());
		req.setAttribute("endereco", contato.getEndereco());
		req.setAttribute("email", contato.getEmail());
		
		// fazendo a conversão da data

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataEmTexto = contato.getDataNascimento().format(formatter);
						
		req.setAttribute("dataNascimento", dataEmTexto);

		System.out.println("buscando o contato:" + contato.getNome());
	}

	public void altera(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
		
		ContatoDao dao = new ContatoDao();
		
		if (id > 0) {			
			contato = dao.consulta(id);
		}
		
		contato.setNome(req.getParameter("nome"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setEmail(req.getParameter("email"));
		
		String dataEmTexto = req.getParameter("dataNascimento");
		LocalDate dataNascimento = null;
		// fazendo a conversão da data

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataNascimento = LocalDate.parse(dataEmTexto, formatter);	

		contato.setDataNascimento(dataNascimento);
		
		if (id > 0) {
			dao.altera(contato);
		} else 
			dao.adiciona(contato);

		System.out.println("Alterando contato... " + contato.getNome());

	}
}
