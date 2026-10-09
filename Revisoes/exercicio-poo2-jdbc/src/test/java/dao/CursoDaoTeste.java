package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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

	public static void main(String[] args) {
		 try {
			CursoDaoTeste.cadastrarCursoTeste();
			 
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
