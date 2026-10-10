package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ProdutoDto;

public class ProdutoDaoTeste {

	static void cadastrar() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		Produto produto = new Produto(conn);
		
		ProdutoDto dto = new ProdutoDto("Teste", "teste1", 100.0, 10);
		
		int linhasAfetadas = produto.cadastrar(dto);
		
		if(linhasAfetadas > 0) {
			System.out.println("Produto cadastrado com sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}

	static void listaTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		Produto produto = new Produto(conn);
		
		List<ProdutoDto> produtos = produto.buscarTodos();

		for(ProdutoDto pd : produtos) {
			System.out.println(pd);
		}
		if(produtos.isEmpty()) {
			System.out.println("Nenhum produto encontrado");
		}
	}
	
	static void buscarPorChave() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		Produto produto = new Produto(conn);
		ProdutoDto pd = produto.buscarPorChave(1);

		if(pd == null) {
			System.out.println("Produto nao encontrado");
		}
		else {
			System.out.println(pd);
		}
	}
	
	static void atualizarDados() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		Produto produto = new Produto(conn);
		
		ProdutoDto dto = new ProdutoDto("Teste3", "teste1", 150.0, 20);
		
		int linhasAfetadas = produto.atualizarDados(dto);
		
		if(linhasAfetadas > 0) {
			System.out.println("Produto atualizado com sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	
	static void deletarPorChave() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		Produto produto = new Produto(conn);
		
		int linhasAfetadas = produto.deletarPorCheve(2);
		
		if(linhasAfetadas > 0) {
			System.out.println("Produto deletado com sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	public static void main(String[] args) {
		try {

			ProdutoDaoTeste.cadastrar();
			ProdutoDaoTeste.listaTodos();
			ProdutoDaoTeste.buscarPorChave();
			ProdutoDaoTeste.atualizarDados();
			ProdutoDaoTeste.deletarPorChave();
			
		} catch (SQLException| IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
