package br.com.caelum.jdbc.test;

import java.sql.Connection;

import br.com.caelum.jdbc.ConnectionFactory;

public class ConnectionFactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão realizada com sucesso!");
	}

}
