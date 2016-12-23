package br.com.caelum.jdbc.dao.test;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class TestaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContatoDao contatoDao = new ContatoDao();
		
		List<Contato> contatos = contatoDao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Id: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("E-mail: " + contato.getEmail());
			System.out.println("Data de Nascimento: " +
			contato.getDataNascimento().toString() + "\n");
		}
	}

}
