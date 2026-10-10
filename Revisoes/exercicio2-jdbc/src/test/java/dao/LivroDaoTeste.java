package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dto.LivroDto;

public class LivroDaoTeste {

	static void cadastrarLivro() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		LivroDao dao = new LivroDao(conn);
		LivroDto dto = new LivroDto("Branca de Neve", "Joao", 2007, 500);
		
		int linhasAfetadas = dao.cadastrar(dto);
		
		if(linhasAfetadas > 0) {
			System.out.println("Livro adicionado com sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	
	
	public static void main(String[] args) throws SQLException, IOException {
		
		LivroDaoTeste.cadastrarLivro();
		
	}
}
