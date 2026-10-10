package dao;

import java.beans.Customizer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dto.CursoDto;

public class CursoDaoTeste {

	public static void cadastrarCursoTeste() throws SQLException, IOException {
		CursoDto cursoDto = new CursoDto("BCC", 2, 3);
		Connection conn = BancoDados.conectar();
		
		CursoDao cursoDao = new CursoDao(conn);
				
		int resultado = cursoDao.cadastrar(cursoDto);
		
		if(resultado > 0) {
			System.out.println("Curso cadastrado com sucesso");
		}
		else {
			System.out.println("Nenhum curso cadastrado");
		}
	}

	public static void listarCursos() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		CursoDao cursoDao = new CursoDao(conn);
		
		List<CursoDto> cursos = cursoDao.buscarTodos();
		
		for(CursoDto cursoDto: cursos) {
			System.out.println(cursoDto);
		}
		
	}
	
	public static void buscarPorChave() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		CursoDao cursoDao = new CursoDao(conn);
		
		CursoDto curso = cursoDao.buscarPorChave(1);
		
		if(curso != null) {
			System.out.println(curso);
		}
		else {
			System.out.println("Curso nao encontrado");
		}
		
	}
	
	public static void atualizarDados() throws SQLException, IOException {
		Connection conn = BancoDados.conectar();
		CursoDao cursoDao = new CursoDao(conn);
		
		CursoDto cursoDto = new CursoDto("Automacao", 4, 2);
		int rowsAffects = cursoDao.atualizar(cursoDto);
		
		if(rowsAffects > 0) {
			System.out.println("Dados atualizados com sucesso");
		}
		else {
			System.out.println("Erro ao atualizar");
		}
	}
	
	public static void main(String[] args) {
		 try {
//			CursoDaoTeste.cadastrarCursoTeste();
//			CursoDaoTeste.buscarPorChave();
			CursoDaoTeste.atualizarDados();
			CursoDaoTeste.listarCursos();

		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
