package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dto.AlunoDto;

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
	public List<AlunoDto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
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
