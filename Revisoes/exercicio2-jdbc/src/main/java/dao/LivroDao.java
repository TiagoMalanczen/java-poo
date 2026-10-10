package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dto.LivroDto;

public class LivroDao implements Dao<LivroDto, Integer>{
	
	private Connection conn; 
	
	
	public LivroDao(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Integer cadastrar(LivroDto entidade) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO LIVROS(Titulo, Autor ,ano ,totalPaginas) "
					+ "VALUES (?,?,?,?)");
			
			st.setString(1, entidade.getTitulo());
			st.setString(2, entidade.getAutorPrincipal());
			st.setInt(3, entidade.getAnoPublicacao());
			st.setInt(4, entidade.getNumeroPaginas());
			
			return st.executeUpdate();
		} 
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
		
	}

	@Override
	public List<LivroDto> listarTodos() {
		return null;
	}

	@Override
	public LivroDto buscarPorChave(Integer chave) {
		return null;
	}

	@Override
	public Integer atulizar(LivroDto entidade) {
		return null;
	}

	@Override
	public Integer excluir(Integer chave) {
		return null;
	}

	
}
