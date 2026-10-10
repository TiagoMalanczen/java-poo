package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
	static void listarTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		LivroDao livroDao = new LivroDao(conn);
		List<LivroDto> livros = livroDao.listarTodos();
		
		if(livros.isEmpty()) {
			System.out.println("Lista vazia");
		}
		for(LivroDto livro : livros) {
			System.out.println(livro);
		}
	}
	static void buscarPorChave() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		LivroDao dao = new LivroDao(conn);
		
		LivroDto livro = dao.buscarPorChave(1);
		
		if(livro != null) {
			System.out.println(livro);
		}
		else {
			System.out.println("Erro");
		}
		
	}
	static void atualizarDados() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		LivroDao dao = new LivroDao(conn);
		LivroDto dto = new LivroDto("Pe grande", "Pedro", 2010, 400);
		
		
		int linhasAfetadas = dao.atulizar(dto);
		
		if(linhasAfetadas > 0) {
			System.out.println("Livro atualizado com sucesso");
		}
		else {
			System.out.println("Erro");
		}	
	}
	static void deletar() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		LivroDao dao = new LivroDao(conn);
	
		int linhasAfetadas = dao.excluir(2);
		
		if(linhasAfetadas > 0) {
			System.out.println("Livro deletado com sucesso");
		}
		else {
			System.out.println("Erro");
		}	
	}
	
	
	
	public static void main(String[] args)  {

		try {
			LivroDaoTeste.cadastrarLivro();
			LivroDaoTeste.listarTodos();
			LivroDaoTeste.buscarPorChave();
			LivroDaoTeste.atualizarDados();
			LivroDaoTeste.deletar();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
