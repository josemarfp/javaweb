package br.com.pmaq.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.pmaq.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conex�o aberta!");
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
