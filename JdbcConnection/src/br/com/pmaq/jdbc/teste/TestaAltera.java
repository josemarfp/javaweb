package br.com.pmaq.jdbc.teste;

import java.time.LocalDate;
import java.time.Month;

import br.com.pmaq.jdbc.dao.PacienteDao;
import br.com.pmaq.jdbc.modelo.Paciente;

public class TestaAltera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PacienteDao pmaq = new PacienteDao();
		Paciente paciente = pmaq.consulta((long) 1);
		
		paciente.setNome("Marcelo Figueiredo Pereira");
		paciente.setDataNascimento(LocalDate.of(1983, Month.DECEMBER, 29));
		
		pmaq.altera(paciente);
		
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("Data de Nascimento: " +
		paciente.getDataNascimento().toString() + "\n");
	}

}
