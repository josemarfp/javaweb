package br.com.caelum.jdbc.dao.test;

import java.time.LocalDate;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class TestaAdiciona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContatoDao contatoDao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setNome("Josemar Figueiredo Pereira");
		contato.setEmail("josemarfp@gmail.com");
		contato.setEndereco("Av. Barbacena, 1200");

		// Diferencia os registros de teste
		contato.setDataNascimento(LocalDate.now()); 
		
		contatoDao.adiciona(contato);
		
		System.out.println("Contato inserido com sucesso! " + " \n " + contato);

	}

}
