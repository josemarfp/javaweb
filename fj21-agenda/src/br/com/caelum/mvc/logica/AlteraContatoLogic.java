package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class AlteraContatoLogic implements Logica {
	/*
	public String executa(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		
		ContatoDao dao = new ContatoDao();
		Contato contato = new Contato();
		contato = dao.consulta(id);
		
		RequestDispatcher rd = req
				.getRequestDispatcher("/edita-contato.jsp");
			rd.forward(req, res);		
	
		dao.altera(contato);
		System.out.println("Alterando contato... ");
		
		return "mvc?logica=ListaContatosLogic";
		//return "lista-contatos.jsp";
	}
	*/
	
	
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String tipo = req.getParameter("paramAltera");
		if (tipo.equals("altera")) {
			this.altera(req, res);

		} else {

			this.popula(req, res);
		}
		
		return "mvc?logica=ListaContatosLogic";
	}

	public void popula(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
		// contato.setId(id);

		System.out.println("buscando o contato:" + id);
		
		ContatoDao dao = new ContatoDao();
		contato = dao.consulta(id);

		req.setAttribute("nome", contato.getNome());
		req.setAttribute("endereco", contato.getEndereco());
		req.setAttribute("email", contato.getEmail());
		
		// fazendo a convers�o da data

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataNascimento = LocalDate.parse(contato.getDataNascimento().toString(), formatter);	
		
		req.setAttribute("dataNascimento", dataNascimento);

		RequestDispatcher rd = req.getRequestDispatcher("/altera-contato.jsp");
		rd.forward(req, resp);

		System.out.println("buscando o contato:" + contato.getNome());
	}

	public void altera(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		Contato contato = new Contato();
		long id = Long.parseLong(req.getParameter("id"));
		contato.setId(id);
		contato.setNome(req.getParameter("nome"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setEmail(req.getParameter("email"));
		
		String dataEmTexto = req.getParameter("dataNascimento");
		LocalDate dataNascimento = null;
		// fazendo a convers�o da data

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataNascimento = LocalDate.parse(dataEmTexto, formatter);	

		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		dao.altera(contato);

		System.out.println("Alterando contato... " + contato.getNome());

	}
}
