package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class BancoDadosTeste {

	static void conectar() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		
		if(conn != null) {
			System.out.println("Conexao feita com sucesso");
		}
		else {
			System.out.println("Erro ao conectar");
		}
	}
	
	public static void main(String[] args) {
		try {
			BancoDadosTeste.conectar();
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
