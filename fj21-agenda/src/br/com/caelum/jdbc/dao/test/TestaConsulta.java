package br.com.caelum.jdbc.dao.test;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.model.Contato;

public class TestaConsulta {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContatoDao contatoDao = new ContatoDao();
		
		List<Contato> contatos = new ArrayList<Contato>();
		contatos = contatoDao.getLista();		
	
		Contato contato = contatoDao.consulta(contatos.get(0).getId());
		
		System.out.println("Id: " + contato.getId());
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Endereço: " + contato.getEndereco());
		System.out.println("E-mail: " + contato.getEmail());
		System.out.println("Data de Nascimento: " +
		contato.getDataNascimento().toString() + "\n");

	}	

}
