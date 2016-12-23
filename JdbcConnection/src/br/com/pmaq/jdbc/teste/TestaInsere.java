package br.com.pmaq.jdbc.teste;

import java.time.LocalDate;
import java.time.Month;

import br.com.pmaq.jdbc.dao.PacienteDao;
import br.com.pmaq.jdbc.modelo.Paciente;

public class TestaInsere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente paciente = new Paciente();
		
		paciente.setNome("Josemar Figueiredo Pereira");
		paciente.setDataNascimento(LocalDate.of(1979, Month.FEBRUARY, 20));
		
		PacienteDao pmaq = new PacienteDao();
		pmaq.adiciona(paciente);
	}

}
