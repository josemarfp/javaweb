package br.com.pmaq.jdbc.teste;

import java.util.List;

import br.com.pmaq.jdbc.dao.PacienteDao;
import br.com.pmaq.jdbc.modelo.Paciente;

public class TestaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacienteDao dao = new PacienteDao();
		
		List<Paciente> pacientes = dao.getLista();
		
		for (Paciente paciente : pacientes) {
			System.out.println("Nome: " + paciente.getNome());
			System.out.println("Data de Nascimento: " +
			paciente.getDataNascimento().toString() + "\n");
		}
	}

}
