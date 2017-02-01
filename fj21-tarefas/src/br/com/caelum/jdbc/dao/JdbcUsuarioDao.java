package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Usuario;

@Repository
public class JdbcUsuarioDao {
	
	// a conex�o com o banco de dados
	private Connection connection;
	
	/*public JdbcUsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}*/
	
	@Autowired
	public JdbcUsuarioDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private Usuario recupera(ResultSet rs, Usuario usuario) {
		try {
			usuario.setId(rs.getLong("id"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			
			return usuario;
		} catch (SQLException e) {
			return new Usuario();			
		}				
	}
	
	public boolean existeUsuario(Usuario usuario) {
		try {
			PreparedStatement stmt = this.connection.
			prepareStatement("select * from usuarios" +
			" where login=?");			
			
			try {
				stmt.setString(1, usuario.getLogin());
				ResultSet rs = stmt.executeQuery();
				
				rs.next();

				Usuario usuarioRecuperado = new Usuario();
				usuarioRecuperado = recupera(rs, usuario);
				
				rs.close();
				stmt.close();
				
				return (usuarioRecuperado.getLogin() == usuario.getLogin());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	

}
