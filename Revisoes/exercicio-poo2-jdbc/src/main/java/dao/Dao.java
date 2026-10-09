package dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T, K> {

	Integer cadastrar(T entidade) throws SQLException;
	List<T> buscarTodos() throws SQLException;
	T buscarPorChave(K chave) throws SQLException;
	Integer atualizar(T entidade);
	Integer excluir(K chave);
	
}
