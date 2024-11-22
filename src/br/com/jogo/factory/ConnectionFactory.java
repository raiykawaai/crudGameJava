package br.com.jogo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		//Registrar o driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Obter uma conexão com o banco de dados (string conexão, usuario, senha)
		Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl","RM86818","240192");
		
		return conexao;
	}

}
