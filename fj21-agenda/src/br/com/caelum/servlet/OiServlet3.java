package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	name = "OiServlet3",
	urlPatterns = {"/ola"},
	initParams = {
		@WebInitParam(name = "param1", value = "value1"),
		@WebInitParam(name = "param2", value = "value2")
	}
)
public class OiServlet3 extends HttpServlet {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3079581412255295469L;
	// c�digo omitido
	private String parametro1;
	private String parametro2;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.parametro1 = config.getInitParameter("param1");
		this.parametro2 = config.getInitParameter("param2");
	}
	
	protected void service (HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// escreve o texto
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeira Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Oi mundo Servlet!</h1>");
		out.println(parametro1);
		out.println(parametro2);		
		out.println("</body>");
		out.println("</html>");
	}
}

