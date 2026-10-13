package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class BancoDadosTeste {

	static void conectar() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		if(conn != null) {
			System.out.println("Sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	
	public static void main(String[] args) {
		try {
			BancoDadosTeste.conectar();
		} 
		catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
