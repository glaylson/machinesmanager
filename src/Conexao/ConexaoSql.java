package Conexao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import com.mysql.jdbc.Connection;

public class ConexaoSql {
	
	private String url = "jdbc:mysql://127.0.0.1/machinesmanager";
	private String use = "root";
	private String pass = "131045";

	public Connection getConnection(){
		try {
			return (Connection) DriverManager.getConnection(url, use, pass);
		} catch (Exception e) {
			throw new  RuntimeException(e);
		}
	}
	
}

/*
//A��o do bot�o salvar
try {
	//procura por uma classe no projeto
	Class.forName("com.mysql.jdbc.Driver");
	//vari�vel de conex�o
	Connection con;
	//pega uma conex�o com o banco
	con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdrarezza", "root", "3081");
	
	//Cria string para inserir no banco
	//String query = "DELETE FROM BOLSAS WHERE IDBOLSAS = 1";
	String query = "INSERT INTO BOLSAS (REF,VALOR) VALUES (123,100)";
	//DELETE FROM EMPREGADOS WHERE CODIGO = 125
	
	//Cria comando
	PreparedStatement stmt = con.prepareStatement(query);
	
	stmt.executeUpdate();
	//fecha comando e conex�o
	stmt.close();
	con.close();
*/