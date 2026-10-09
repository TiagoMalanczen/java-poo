package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dto.CursoDto;

public class CursoDao implements Dao<CursoDto, Integer>{

	private Connection conn;

	public CursoDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	@Override
	public Integer cadastrar(CursoDto entidade) throws SQLException {

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO CURSO(NOME, PERIODO, DURACAO) "
					+ " VALUES (?,?,?)");
			st.setString(1, entidade.getNome());
			st.setInt(2, entidade.getPeriodo());
			st.setInt(3, entidade.getDuracao());
			
			return st.executeUpdate();
			
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
		
		
	}
	@Override
	public List<CursoDto> buscarTodos() {
		return null;
	}
	@Override
	public CursoDto buscarPorChave(Integer chave) {
		return null;
	}
	@Override
	public Integer atualizar(CursoDto entidade) {
		return null;
	}
	@Override
	public Integer excluir(Integer chave) {
		return null;
	}
	
}
