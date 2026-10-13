package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.TarefasDto;

public class TarefasDao implements Dao<TarefasDto, Integer>{

	private Connection conn = null;

	public TarefasDao(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Integer cadastrar(TarefasDto entidade) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO TAREFAS (TITULO, DESCRICAO, PRIORIDADE, STATUS) "
					+ "VALUES (?,?,?,?)");
			st.setString(1, entidade.getTitulo());
			st.setString(2, entidade.getDescricao());
			st.setString(3, entidade.getPrioridade());
			st.setString(4, entidade.getStatus());
			
			return st.executeUpdate();
		} 
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public List<TarefasDto> listaTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<TarefasDto> tarefas = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("SELECT * FROM TAREFAS");
			rs = st.executeQuery();
			
			TarefasDto dto = null;
			
 			while(rs.next()) {
				dto = 
						new TarefasDto(rs.getString("TITULO"), 
								rs.getString("DESCRICAO"), 
								rs.getString("PRIORIDADE"),
								rs.getString("STATUS"));
				
				tarefas.add(dto);
			}
			return tarefas;
		} 
		finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public TarefasDto buscarPorChave(Integer chave) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM TAREFAS WHERE ID = ?");
			st.setInt(1, chave);
			
			rs = st.executeQuery();
			TarefasDto dto = null;

			if(rs.next()) {
				dto = 
						new TarefasDto(rs.getString("TITULO"), 
								rs.getString("DESCRICAO"), 
								rs.getString("PRIORIDADE"),
								rs.getString("STATUS"));
				dto.setId(chave);
			}
			return dto;
		} 
		finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public Integer atualizar(TarefasDto entidade, Integer chave) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE TAREFAS SET TITULO = ?,"
					+ "DESCRICAO = ?,"
					+ "PRIORIDADE = ?,"
					+ "STATUS = ?"
					+ "WHERE ID = ?");
			
			st.setString(1, entidade.getTitulo());
			st.setString(2, entidade.getDescricao());
			st.setString(3, entidade.getPrioridade());
			st.setString(4, entidade.getStatus());
			st.setInt(5, chave);
			
			return st.executeUpdate();
		} 
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public Integer deletar(Integer chave) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM TAREFAS WHERE ID = ?");
			st.setInt(1, chave);
		
			return st.executeUpdate();
		} 
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	
}
