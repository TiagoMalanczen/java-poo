package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Veiculo;

public class VeiculoDao implements Dao<Veiculo, Integer> {
	
	private Connection conn = null;

	public VeiculoDao(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Integer cadastrar(Veiculo entidade) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO VEICULO(PLACA, MODELO, ANO, QUILOMETRAGEM) "
					+ "VALUES(?,?,?,?)");
			
			st.setString(1, entidade.getPlaca());
			st.setString(2, entidade.getModelo());
			st.setInt(3, entidade.getAno());
			st.setInt(4, entidade.getQuilometragem());
			
			return st.executeUpdate();
		} 
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public List<Veiculo> buscarTodos() throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<Veiculo> veiculos = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("SELECT * FROM VEICULO");
			rs = st.executeQuery();
			Veiculo veiculo = null;
			
			while(rs.next()) {
				veiculo = 
				new Veiculo(rs.getString("Placa"),
						rs.getString("MODELO"),
						rs.getInt("ANO"),
						rs.getInt("QUILOMETRAGEM"));
				veiculos.add(veiculo);
			}
			
			return veiculos;
		} 
		finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public Veiculo buscarPOrChave(Integer chave) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM VEICULO  WHERE ID = ?");
			st.setInt(1, chave);

			rs = st.executeQuery();
			Veiculo veiculo = null;
			
			if(rs.next()) {
				veiculo = 
				new Veiculo(rs.getString("Placa"),
						rs.getString("MODELO"),
						rs.getInt("ANO"),
						rs.getInt("QUILOMETRAGEM"));
			}
			
			return veiculo;
		} 
		finally {
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	@Override
	public Integer atualizarDados(Veiculo entidade, Integer chave) throws SQLException {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("UPDATE VEICULO "
					+ "SET PLACA = ?,"
					+ "MODELO = ?,"
					+ "ANO = ?, "
					+ "quilometragem = ? "
					+ "WHERE ID = ?");
			
			st.setString(1, entidade.getPlaca());
			st.setString(2, entidade.getModelo());
			st.setInt(3, entidade.getAno());
			st.setInt(4, entidade.getQuilometragem());
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
			st = conn.prepareStatement("DELETE FROM VEICULO WHERE ID = ?");
		
			st.setInt(1, chave);
			
			return st.executeUpdate();
		} 
		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}
