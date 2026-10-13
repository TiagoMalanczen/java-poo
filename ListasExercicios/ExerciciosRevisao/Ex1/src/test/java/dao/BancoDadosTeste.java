package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDados;

public class BancoDadosTeste {

	static void abrirConexao() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		
		if(conn != null) {
			System.out.println("Conexao feita com sucesso");
		}
		else {
			System.out.println("Erro");
		}
		
	}
	public static void main(String[] args) {
		try {
			BancoDadosTeste.abrirConexao();
			
		} catch (SQLException |IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
