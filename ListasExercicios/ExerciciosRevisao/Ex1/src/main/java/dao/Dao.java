package dao;

import java.sql.SQLException;
import java.util.List;

import dto.FuncionarioDto;

public interface Dao<T,K> {

	Integer cadastrarFunc(T entidade) throws SQLException;
	List<T> listarTodos() throws SQLException;
	T buscarPorChave(K chave) throws SQLException;
	K atualizar(T entidade, K chave) throws SQLException;
	K deletar(K chave) throws SQLException;
}
