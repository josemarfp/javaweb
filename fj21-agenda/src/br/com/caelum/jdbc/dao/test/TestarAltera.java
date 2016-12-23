package br.com.caelum.jdbc.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class TestarAltera {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContatoDao contatoDao = new ContatoDao();
		
		List<Contato> contatos = new ArrayList<Contato>();
		contatos = contatoDao.getLista();
		
		Contato contato = contatos.get(0);
		contato.setNome("Marcelo Figueiredo Pereira");

		contatoDao.adiciona(contato);
		
		System.out.println("Contato alterado com sucesso! " + " \n " + contato);
	}

}
