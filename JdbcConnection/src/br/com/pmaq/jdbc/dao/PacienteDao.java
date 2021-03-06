package br.com.pmaq.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.pmaq.jdbc.ConnectionFactory;
import br.com.pmaq.jdbc.modelo.Paciente;

public class PacienteDao {
	// a conex�o com o banco de dados
	private Connection connection;
	
	public PacienteDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Paciente paciente) {
		String sql = "insert into paciente " +
		"(nome, data_nascimento)" +
		" values (?,?)";
		
		// prepared statement para inser��o
		PreparedStatement stmt = null;
		
		try {	
			stmt = connection.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, paciente.getNome());
			stmt.setObject(2, paciente.getDataNascimento());
			
			// executa
			stmt.execute();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public Paciente consulta(Long id) {
		String sql = "select * from paciente " +
		" where id_paciente=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			// criando o objeto Paciente
			Paciente paciente = new Paciente();
			paciente.setId(rs.getLong("id_paciente"));
			paciente.setNome(rs.getString("nome"));
				
			// montando a data atrav�s do LocalDate
			paciente.setDataNascimento(rs.getObject("data_nascimento", LocalDate.class));
			
			stmt.close();
			
			// adicionando o objeto � lista
			return paciente;	
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Paciente> getLista() {
		try {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		PreparedStatement stmt = this.connection.
		prepareStatement("select * from paciente");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			// criando o objeto Paciente
			Paciente paciente = new Paciente();
			paciente.setId(rs.getLong("id_paciente"));
			paciente.setNome(rs.getString("nome"));
	
			
			// montando a data atrav�s do LocalDate
			paciente.setDataNascimento(rs.getObject("data_nascimento", LocalDate.class));
			
			// adicionando o objeto � lista
			pacientes.add(paciente);
		}
		
		rs.close();
		stmt.close();
		return pacientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Paciente paciente) {
		String sql = "update paciente set nome=?, " +
		"data_Nascimento=? where id_paciente=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, paciente.getNome());
			stmt.setObject(2, paciente.getDataNascimento());
			stmt.setLong(3, paciente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Paciente paciente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete" +
			" from paciente where id_paciente=?");
			stmt.setLong(1, paciente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}