package com.treinamento.moduloweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySqlDAO {

	private String url = "jdbc:mysql://dev.crurmnllvgn6.us-east-2.rds.amazonaws.com/dev";
	private String usuario = "java";
	private String senha = "1234";
	
	public Connection obterConexao() throws SQLException {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =  DriverManager.getConnection(url, usuario, senha);
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return conn;
	}
	
}
