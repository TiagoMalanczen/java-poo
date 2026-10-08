package dao;

import java.util.List;

public interface Dao<T, K> {

	Integer cadastrar(T entidade);
	List<T> buscarTodos();
	T buscarPorChave(K chave);
	Integer atualizar(T entidade);
	Integer excluir(K chave);
	
}
