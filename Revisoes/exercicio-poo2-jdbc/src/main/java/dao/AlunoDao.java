package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AlunoDto;
import dto.CursoDto;

public class AlunoDao implements Dao<AlunoDto, Integer>{

	private Connection connection;

	
	public AlunoDao(Connection connection) {
		super();
		this.connection = connection;
	}


	@Override
	public Integer cadastrar(AlunoDto entidade) throws SQLException {
		
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement("INSERT INTO ALUNO "
					+ "(nome, sexo, data_ingresso, periodo, coeficiente, codigo_curso) "
					+ "VALUES (?,?,?,?,?,?)");
			
			st.setString(1, entidade.getNome());
			st.setString(2, entidade.getSexo());
			st.setDate(3, new java.sql.Date(entidade.getDataIngresso().getTime()));
			st.setInt(4, entidade.getPeriodo());
			st.setDouble(5, entidade.getCoeficiente());
			st.setInt(6, entidade.getCodigoCurso());
			
			return st.executeUpdate();
			
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}


	@Override
	public List<AlunoDto> buscarTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement("SELECT * FROM ALUNO");
			rs = st.executeQuery();
			
			List<AlunoDto> listaCursos = new ArrayList<>();
			
			while(rs.next()) {
				AlunoDto alunoDto = new AlunoDto(
						rs.getString("Nome"),
						rs.getString("Sexo"),
						rs.getDate("Data_ingresso"),
						rs.getInt("Periodo"), 
						rs.getDouble("Coeficiente"), 
						rs.getInt("Codigo_curso"));
				alunoDto.setRegistroAcademico(rs.getInt("registro_academico"));
				alunoDto.setCodigoCurso(rs.getInt("codigo_curso"));
				listaCursos.add(alunoDto);
			}
			
			return listaCursos;	
			
		}
		finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}


	@Override
	public AlunoDto buscarPorChave(Integer chave) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer atualizar(AlunoDto entidade) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer excluir(Integer chave) {
		// TODO Auto-generated method stub
		return null;
	}


}
