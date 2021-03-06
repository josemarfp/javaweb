package br.com.pmaq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	/**
	 *  Factory de conex�es JDBC
	 *  Para configurar o driver no eclipse v� em:
	 *  Project -> Properties -> Java Build Path -> Libraries -> Add a Library
	 *  Connectivity Driver Definition -> Next -> New Driver Definition
	 *  
	 *  @return Connection
	 */
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/pmaq", "postgres", "postgres");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
