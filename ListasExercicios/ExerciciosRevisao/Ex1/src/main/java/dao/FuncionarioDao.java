package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.FuncionarioDto;

public class FuncionarioDao implements Dao<FuncionarioDto, Integer>{

	private Connection conn =  null;
	
	public FuncionarioDao(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Integer cadastrarFunc(FuncionarioDto entidade) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO  funcionario(NOME, CARGO, SALARIO, CPF) "
					+ "VALUES (?,?,?,?)");
			
			st.setString(1, entidade.getNome());
			st.setString(2, entidade.getCargo());
			st.setDouble(3, entidade.getSalario());
			st.setString(4, entidade.getCpf());
			
			return st.executeUpdate();
		}
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public List<FuncionarioDto> listarTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = conn.prepareStatement("SELECT * FROM FUNCIONARIO");
			rs = st.executeQuery();
			
			FuncionarioDto dto = null;
			List<FuncionarioDto> funcionarios = new ArrayList<>();
			
			while(rs.next()) {
				 dto = new FuncionarioDto(rs.getString("Nome"),
								rs.getString("Cargo"),
								rs.getDouble("Salario"),
								rs.getString("CPF"));
				
				funcionarios.add(dto);
			}
			
			return funcionarios;
		}
		finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public FuncionarioDto buscarPorChave(Integer chave) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<FuncionarioDto> funcionarios = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT *FROM FUNCIONARIO WHERE ID = ?");
			st.setInt(1, chave);
			
			rs = st.executeQuery();
			
			FuncionarioDto dto = null;
			
			if(rs.next()) {
				 dto = new FuncionarioDto(rs.getString("Nome"),
								rs.getString("Cargo"),
								rs.getDouble("Salario"),
								rs.getString("CPF"));
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
	public Integer atualizar(FuncionarioDto entidade, Integer chave) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE funcionario SET NOME = ?, CARGO = ?, SALARIO = ?, CPF = ? WHERE ID = ?");
			
			st.setInt(5, chave);
			
			st.setString(1, entidade.getNome());
			st.setString(2, entidade.getCargo());
			st.setDouble(3, entidade.getSalario());
			st.setString(4, entidade.getCpf());
			
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
			st = conn.prepareStatement("DELETE FROM FUNCIONARIO WHERE ID = ?");
	
			st.setInt(1, chave);
			
			return st.executeUpdate();
		}
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	
}
