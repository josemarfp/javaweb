package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.model.Contato;

public class ContatoDao {

	// a conex�o com o banco de dados
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public ContatoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos " +
		"(nome,email,endereco,datanascimento)" +
		" values (?,?,?,?)";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);
	
			// seta os valores																									
			stmt.setString(1, contato.getNome());              																									        
			stmt.setString(2, contato.getEmail());             																									         
			stmt.setString(3, contato.getEndereco());          			
			
			// @todo: Como n�o fazer este cast � j� persistir localdate?
			stmt.setDate(4, Date.valueOf(contato.getDataNascimento()));  																									                    
		                      
			//executa
			stmt.execute();
			stmt.close();
		  } catch (SQLException e) {
		  	throw new RuntimeException(e);
		  }
	}
	
	private Contato recupera(ResultSet rs, Contato contato) {
		try {
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			
			// montando a data atrav�s do Calendar
			LocalDate data = rs.getObject("datanascimento", LocalDate.class); 
			contato.setDataNascimento(data);
			
			return contato;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}				
	}
	
	public Contato consulta(Long id) {
		try {
			PreparedStatement stmt = this.connection.
			prepareStatement("select * from contatos" +
			" where id=?");			
			
			try {
				stmt.setLong(1, id);
				ResultSet rs = stmt.executeQuery();
				
				rs.next();

				Contato contato = new Contato();
				contato = recupera(rs, contato);
				
				rs.close();
				stmt.close();
				
				return contato;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				Contato contato = new Contato();
				contato = recupera(rs, contato);
				
				// adicionando o objeto � lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?," +
		"dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setObject(4, contato.getDataNascimento());
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete" +
			" from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
