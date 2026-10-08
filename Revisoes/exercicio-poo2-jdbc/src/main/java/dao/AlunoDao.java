package dao;

import java.sql.Connection;
import java.util.List;

public class AlunoDao implements Dao<AlunoDao, Integer>{

	private Connection connection;

	
	public AlunoDao(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public Integer cadastrar(AlunoDao entidade) {
		return null;
	}

	@Override
	public List<AlunoDao> buscarTodos() {
		return null;
	}

	@Override
	public AlunoDao buscarPorChave(Integer chave) {
		return null;
	}

	@Override
	public Integer atualizar(AlunoDao entidade) {
		return null;
	}

	@Override
	public Integer excluir(Integer chave) {
		return null;
	}
}
