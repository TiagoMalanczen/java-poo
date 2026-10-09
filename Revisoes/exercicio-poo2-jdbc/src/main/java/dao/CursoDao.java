package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public List<CursoDto> buscarTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<CursoDto> listaCursos = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("SELECT *FROM CURSO");
			rs = st.executeQuery();
			
			while(rs.next()) {
				CursoDto cursoDto = new CursoDto(rs.getString("Nome"),
						rs.getInt("Periodo"), 
						rs.getInt(rs.getInt("Duracao")));
				cursoDto.setCodigo(rs.getInt("Codigo"));
				
				listaCursos.add(cursoDto);
			}
			return listaCursos;
			
		} finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		} 
	}
	@Override
	public CursoDto buscarPorChave(Integer chave) throws SQLException {
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
