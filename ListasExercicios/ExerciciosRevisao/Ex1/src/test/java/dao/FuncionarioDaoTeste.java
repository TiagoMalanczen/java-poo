package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import dto.FuncionarioDto;

public class FuncionarioDaoTeste {

	static void cadastrar() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		FuncionarioDao dao = new FuncionarioDao(conn);
		
		FuncionarioDto dto = new FuncionarioDto("Pedro", "Operario", 1500.00, "123456789");
		
		int linhasAfetadas = dao.cadastrarFunc(dto);
		
		if(linhasAfetadas > 0) {
			System.out.println("Cadastrado com sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	static void listarTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		FuncionarioDao dao = new FuncionarioDao(conn);
		
		List<FuncionarioDto> funcionario = dao.listarTodos();
		
		for(FuncionarioDto func : funcionario) {
			System.out.println(func);
		}
		if(funcionario.isEmpty()) {
			System.out.println("Lista vazia");
		}
		
	}
	static void buscarPorChave() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		FuncionarioDao dao = new FuncionarioDao(conn);
		
		FuncionarioDto dto = dao.buscarPorChave(2);

		if(dto != null) {
			System.out.println(dto);
		}
		else {
			System.out.println("Nao encontrado");
		}
	}
	static void atualizarDados() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		FuncionarioDao dao = new FuncionarioDao(conn);
		
		FuncionarioDto dto = new FuncionarioDto("Pedro", "Operario", 3000.00, "123456789");

		dao.atualizar(dto, 2);
		
		System.out.println(dto);
	}
	static void deletar() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		FuncionarioDao dao = new FuncionarioDao(conn);
		int linhasAfetadas = dao.deletar(3);
		
		if(linhasAfetadas > 0) {
			System.out.println("Deletado com sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	
	public static void main(String[] args) {
		try {
			FuncionarioDaoTeste.cadastrar();
			FuncionarioDaoTeste.listarTodos();
			FuncionarioDaoTeste.buscarPorChave();
			FuncionarioDaoTeste.atualizarDados(); 
			FuncionarioDaoTeste.deletar();
		} catch (SQLException |IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
