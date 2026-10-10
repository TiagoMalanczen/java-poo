package dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T, K> {
	
	Integer cadastrar(T entidade) throws SQLException;
	List<T> listarTodos() throws SQLException;
	T buscarPorChave(K chave) throws SQLException;
	Integer atulizar(T entidade) throws SQLException;
	Integer excluir(K chave) throws SQLException;

}
