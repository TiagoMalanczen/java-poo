package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ProdutoDto;

public class Produto implements Dao<ProdutoDto, Integer>{

	private Connection conn = null;
	
	
	public Produto(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Integer cadastrar(ProdutoDto entidade) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO PRODUTO(NOME, CATEGORIA, PRECO, QUANTIDADEESTOQUE) "
					+ "VALUES (?,?,?,?)");
			st.setString(1, entidade.getNome());
			st.setString(2, entidade.getCategoria());
			st.setDouble(3, entidade.getPreco());
			st.setInt(4, entidade.getQuantidadeEstoque());
			
			return st.executeUpdate();
			
			
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}

	}

	@Override
	public List<ProdutoDto> buscarTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<ProdutoDto> produtos = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("SELECT * FROM PRODUTO");
			rs = st.executeQuery();
		
			while(rs.next()) {
				
				ProdutoDto dto = 
						new ProdutoDto(rs.getString("Nome"),
						rs.getString("Categoria"),
						rs.getDouble("Preco"),
						rs.getInt("QuantidadeEstoque"));
				
				produtos.add(dto);
				
			}
			
			return produtos;
			
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	@Override
	public ProdutoDto buscarPorChave(Integer chave) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM PRODUTO WHERE numeroIdentificador = ?");
			st.setInt(1, chave);
			rs = st.executeQuery();
		
			ProdutoDto dto = null;
			if(rs.next()) {
				
				 dto = 
						new ProdutoDto(rs.getString("Nome"),
						rs.getString("Categoria"),
						rs.getDouble("Preco"),
						rs.getInt("QuantidadeEstoque"));
				 	dto.setNumeroIdentificador(chave);
				
			}
			
			return dto;
			
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	@Override
	public Integer atualizarDados(ProdutoDto entidade) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update  PRODUTO "
					+ "SET NOME = ?,"
					+ "CATEGORIA = ?,"
					+ "preco =?,"
					+ "quantidadeEstoque = ?");
			
			st.setString(1, entidade.getNome());
			st.setString(2, entidade.getCategoria());
			st.setDouble(3, entidade.getPreco());
			st.setInt(4, entidade.getQuantidadeEstoque());
			
			return st.executeUpdate();
			
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}

	}

	@Override
	public Integer deletarPorCheve(Integer chave) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM PRODUTO WHERE numeroIdentificador  = ?");
			
			st.setInt(1, chave);
			
			return st.executeUpdate();
			
		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}

	}

}
