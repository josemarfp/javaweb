package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Tarefa;

public class JdbcTarefaDao {

	// a conex�o com o banco de dados
	private Connection connection;
	
	public JdbcTarefaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public JdbcTarefaDao(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(Tarefa tarefa) {
		String sql = "insert into tarefas " +
		"(descricao,finalizado,datafinalizacao)" +
		" values (?,?,?)";

		try {
			// prepared statement para inser��o
			PreparedStatement stmt = connection.prepareStatement(sql);
	
			// seta os valores																									
			stmt.setString(1, tarefa.getDescricao());              																									        
			stmt.setBoolean(2, tarefa.getFinalizado());        																									         
			stmt.setObject(3, tarefa.getDataFinalizacao());  																									                    
		                      
			//executa
			stmt.execute();
			stmt.close();
		  } catch (SQLException e) {
		  	throw new RuntimeException(e);
		  }
	}
	
	private Tarefa recupera(ResultSet rs, Tarefa tarefa) {
		try {
			tarefa.setId(rs.getLong("id"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));
			
			Date date = rs.getDate("datafinalizacao");
			if (date != null) {
				String strDate = date.toString();
				DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("yyyy-MM-dd");	
				LocalDate newDate = LocalDate.parse(strDate, dtf);
				tarefa.setDataFinalizacao(newDate);
			}
						
			return tarefa;
		} catch (SQLException e) {
			return new Tarefa();			
		}				
	}
	
	public Tarefa consulta(Long id) {
		try {
			PreparedStatement stmt = this.connection.
			prepareStatement("select * from tarefas" +
			" where id=?");			
			
			try {
				stmt.setLong(1, id);
				ResultSet rs = stmt.executeQuery();
				
				rs.next();

				Tarefa tarefa = new Tarefa();
				tarefa = recupera(rs, tarefa);
				
				rs.close();
				stmt.close();
				
				return tarefa;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public List<Tarefa> lista() {
		try {
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas ");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				Tarefa tarefa = new Tarefa();
				tarefa = recupera(rs, tarefa);
				
				// adicionando o objeto � lista
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public void finaliza(Long id) {
		Tarefa tarefa = this.consulta(id);
		
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(LocalDate.now());
		
		this.altera(tarefa);
	}
	
	public void altera(Tarefa tarefa) {
		String sql = "update tarefas set descricao=?, finalizado=?," +
		"dataFinalizacao=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.getFinalizado());
			
			LocalDate newDate = tarefa.getDataFinalizacao();
			Date date = null;
			if (newDate != null) {
				date = Date.valueOf(newDate);
			}
			stmt.setDate(3, date);
			
			stmt.setLong(4, tarefa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public void remove(Tarefa tarefa) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete" +
			" from tarefas where id=?");
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
