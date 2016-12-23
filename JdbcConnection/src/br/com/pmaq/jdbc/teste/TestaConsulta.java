package br.com.pmaq.jdbc.teste;

import br.com.pmaq.jdbc.dao.PacienteDao;
import br.com.pmaq.jdbc.modelo.Paciente;

public class TestaConsulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PacienteDao pmaq = new PacienteDao();
		Paciente paciente = pmaq.consulta((long) 1);
		
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("Data de Nascimento: " +
		paciente.getDataNascimento().toString() + "\n");		
	}

}
