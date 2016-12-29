package br.com.caelum.jdbc.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class ConnectionFactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = new ConnectionFactory().getConnection();
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Conexão realizada com sucesso!");
	}

}
