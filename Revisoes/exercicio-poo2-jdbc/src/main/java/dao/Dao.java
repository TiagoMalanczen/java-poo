package dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T, K> {

	Integer cadastrar(T entidade) throws SQLException;
	List<T> buscarTodos();
	T buscarPorChave(K chave);
	Integer atualizar(T entidade);
	Integer excluir(K chave);
	
}
