package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public List<LivroDto> listarTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<LivroDto> livros = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("SELECT *FROM LIVROS");
			rs = st.executeQuery();
			
			while(rs.next()) {
				LivroDto livro = new LivroDto(
						rs.getString("Titulo"), 
						rs.getString("Autor"),
						rs.getInt("Ano"),
						rs.getInt("TotalPaginas"));
				
				livros.add(livro);
			}
				
			return livros;
		} 
		finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public LivroDto buscarPorChave(Integer chave) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM LIVROS WHERE 	numeroIdentificador = ?");
			st.setInt(1, chave);
			
			rs = st.executeQuery();
			
			LivroDto livro = null;
			
			if(rs.next()) {
				livro = new LivroDto(rs.getString("Titulo"),
						rs.getString("Autor"),
						rs.getInt("Ano"),
						rs.getInt("totalPaginas"));
			}
			
			return livro;
		} 
		finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
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
