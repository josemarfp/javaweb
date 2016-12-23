package br.com.caelum.jdbc.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class TestaRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContatoDao contatoDao = new ContatoDao();
		
		List<Contato> contatos = new ArrayList<Contato>();
		contatos = contatoDao.getLista();
		
		Contato contato = contatos.get(0);

		contatoDao.remove(contato);
		
		System.out.println("Contato removido com sucesso! " + " \n " + contato);
	}

}
