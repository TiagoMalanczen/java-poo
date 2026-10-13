package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dto.Veiculo;

public class VeiculoDaoTeste {
	static void cadastrar() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		VeiculoDao dao = new VeiculoDao(conn);
		Veiculo veiculo = new Veiculo("123sa", "FiatUno", 2010, 550);
		
		int linhasAfetadas = dao.cadastrar(veiculo);
		if(linhasAfetadas > 0 ) {
			System.out.println("Sucesso");
		}
		else {
			System.out.println("Erro");
		}
	}
	
	static void listarTodos() throws SQLException, IOException {
			Connection conn = BancoDados.conectar();
			VeiculoDao dao = new VeiculoDao(conn);
			List<Veiculo> veiculos = dao.buscarTodos();
			
			for(Veiculo veiculo : veiculos) {
				System.out.println(veiculo);
			}
			
			if(veiculos.isEmpty()) {
				System.out.println("Lista vazia");
			}
	}
	static void buscarPorChave() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		VeiculoDao dao = new VeiculoDao(conn);
		Veiculo veiculo = dao.buscarPOrChave(1);
		
		if(veiculo != null) {
			System.out.println(veiculo);
		}
		else {
			System.out.println("Erro");
		}
	}
	static void atualizarDaos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		VeiculoDao dao = new VeiculoDao(conn);
		
		Veiculo veiculo = new Veiculo("123sa", "FiatUno", 2010, 4000);
	
		int linhasAfetadas = dao.atualizarDados(veiculo, 1);
		
		if(linhasAfetadas > 0 ) {
			System.out.println("Sucesso");
		}
		else {
			System.out.println("Erro");
		}
		
	}
	static void deletar() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		VeiculoDao dao = new VeiculoDao(conn);
		
		int linhasAfetadas = dao.deletar(1);
		
		if(linhasAfetadas > 0 ) {
			System.out.println("Sucesso");
		}
		else {
			System.out.println("Erro");
		}
		
	}
	
	public static void main(String[] args) {
		try {
//			VeiculoDaoTeste.cadastrar();
//			VeiculoDaoTeste.listarTodos();
//			VeiculoDaoTeste.buscarPorChave();
//			VeiculoDaoTeste.atualizarDaos();
			VeiculoDaoTeste.deletar();
			
			
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
