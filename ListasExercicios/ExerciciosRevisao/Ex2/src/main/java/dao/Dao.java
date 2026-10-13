package dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T, K> {

	K cadastrar(T entidade) throws SQLException;
	List<T> buscarTodos() throws SQLException;
	T buscarPOrChave(K chave)throws SQLException;
	K atualizarDados(T entidade, K chave)throws SQLException;
	K deletar(K chave)throws SQLException;
		
	
}
