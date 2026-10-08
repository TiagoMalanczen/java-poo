package dao;

import java.sql.Connection;
import java.util.List;

import dto.CursoDto;

public class CursoDao implements Dao<CursoDto, Integer>{

	private Connection conn;

	public CursoDao(Connection conn) {
		super();
		this.conn = conn;
	}
	@Override
	public Integer cadastrar(CursoDto entidade) {
		return null;
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
