package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import dto.AlunoDto;
import dto.CursoDto;

public class AlunoDaoTeste {

	public static void cadastrarAlunoTeste() throws SQLException, IOException {
	
		AlunoDto alunoDto = new AlunoDto("Joao", "M" , new Date(), 3, 8.0, 1);

		Connection conn = BancoDados.conectar();
		AlunoDao alunoDao = new AlunoDao(conn);

		int resultado = alunoDao.cadastrar(alunoDto);
		
		if(resultado > 0) {
			System.out.println("Aluno cadastrado com sucesso");
		}
		else {
			System.out.println("Nenhuma linha afetada");
		}
	
	}
	
	public static void main(String[] args) {
		
		try {
			AlunoDaoTeste.cadastrarAlunoTeste();
			
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
