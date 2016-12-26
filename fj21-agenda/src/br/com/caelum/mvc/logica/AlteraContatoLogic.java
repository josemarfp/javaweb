package br.com.caelum.mvc.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class AlteraContatoLogic implements Logica {
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
}
