package br.com.pmaq.jdbc.teste;

import java.util.List;

import br.com.pmaq.jdbc.dao.PacienteDao;
import br.com.pmaq.jdbc.modelo.Paciente;

public class TestaApaga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacienteDao dao = new PacienteDao();
		
		List<Paciente> pacientes = dao.getLista();
		
		Paciente paciente = pacientes.get(0);
		dao.remove(pacientes.get(0));
		
		System.out.println("Registro exclu�do!" );
		System.out.println("Nome: " + paciente.getNome());
		System.out.println("Data de Nascimento: " +
		paciente.getDataNascimento().toString() + "\n");
	}

}
