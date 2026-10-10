package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class BancoDadosTestes {

	public static void conectarBanco() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		
		if(conn != null) {
			System.out.println("Conectado com sucesso");
		}
		
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		BancoDadosTestes.conectarBanco();
	}
}
