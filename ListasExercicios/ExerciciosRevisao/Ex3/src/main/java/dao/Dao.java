package dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T, K> {

	K cadastrar(T entidade) throws SQLException;
	List<T> listaTodos()throws SQLException;
	T buscarPorChave(K chave)throws SQLException;
	K atualizar(T entidade, K chave)throws SQLException;
	K deletar(K chave)throws SQLException;
	
}
