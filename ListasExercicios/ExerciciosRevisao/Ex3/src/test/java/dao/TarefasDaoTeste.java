package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dto.TarefasDto;

public class TarefasDaoTeste {
	
	static void cadastrar() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		TarefasDao dao = new TarefasDao(conn);
		
		TarefasDto dto = new TarefasDto("teste", "testando", "prioridade", "status");
		
		int linhasAfetadas = dao.cadastrar(dto);
		
		if(linhasAfetadas > 0) {
			System.out.println("Sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	static void buscarTodos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		TarefasDao dao = new TarefasDao(conn);
		List<TarefasDto> tarefas = dao.listaTodos();
		
		for(TarefasDto tarefa : tarefas) {
			System.out.println(tarefa);
		}
		if(tarefas.isEmpty()) {
			System.out.println("Lista vazia");
		}
	}
	static void buscarPorChave() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		TarefasDao dao = new TarefasDao(conn);
		int chave = 2;
		
		TarefasDto dto = dao.buscarPorChave(chave);
		
		if(dto != null) {
			System.out.println(dto);
		}
		else {
			System.out.println("Erro");
		}
	}
	static void atualizarDados() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		TarefasDao dao = new TarefasDao(conn);
		int chave = 2;
		
		TarefasDto dto = new TarefasDto("teste3", "testando3", "prioridade3", "status3");
		
		int linhasAfetadas = dao.atualizar(dto, chave);
		
		if(linhasAfetadas > 0) {
			System.out.println("Sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	static void deletarDados() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		TarefasDao dao = new TarefasDao(conn);
		int chave = 2;

		int linhasAfetadas = dao.deletar(chave);
		
		if(linhasAfetadas > 0) {
			System.out.println("Sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	
	public static void main(String[] args) {
		try {
			
			TarefasDaoTeste.cadastrar();
			TarefasDaoTeste.buscarPorChave();
			TarefasDaoTeste.buscarTodos();
			TarefasDaoTeste.atualizarDados();
			TarefasDaoTeste.deletarDados();
			
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
