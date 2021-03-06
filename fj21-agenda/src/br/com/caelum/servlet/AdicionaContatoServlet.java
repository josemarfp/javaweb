package br.com.caelum.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1785348253243492990L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
	}
	
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}	
	
	protected void service(HttpServletRequest request,
	HttpServletResponse response)
	throws IOException, ServletException {
		
		// pegando os par�metros do request
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		LocalDate dataNascimento = null;
		// fazendo a convers�o da data

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataNascimento = LocalDate.parse(dataEmTexto, formatter);			
		
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		// salva o contato
		// � necess�rio copiar o driver jdbc para a pasta lib do tomcat
		// al�m disso, web.xml precisa ser configurado tamb�m.
		//<resource-ref>
		// <description>postgreSQL Datasource example</description>
		// <res-ref-name>jdbc/postgres</res-ref-name>
		// <res-type>javax.sql.DataSource</res-type>
		// <res-auth>Container</res-auth>
		//</resource-ref>
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		// imprime o nome do contato que foi adicionado
		//out.println("<html>");
		//out.println("<body>");
		//out.println("Contato " + contato.getNome() +
		//" adicionado com sucesso");
		//out.println("</body>");
		//out.println("</html>");
		
		RequestDispatcher rd = request
			.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
	}
}