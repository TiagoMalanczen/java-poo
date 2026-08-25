package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

public class Program {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.openConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE SELLER SET BASESALARY = 5090 "
					+ "WHERE DEPARTMENTID = 1 ");			
//			int x = 1;
//			if(x < 2) {
//				throw new SQLException("Erro inexperado");
//			}
			int rows2 = st.executeUpdate("UPDATE SELLER SET BASESALARY = 7090 "
					+ "WHERE DEPARTMENTID = 2 ");
	
			conn.commit();
	
		System.out.println(rows1);
		System.out.println(rows2);
		
		}
		catch (SQLException e) {
			try {
				conn.rollback();
				throw new DBException("Transacao nao concluida, " + e.getMessage());
			} 
			catch (SQLException e1) {
				throw new DBException("Erro no rollback, causado por " + e1.getMessage());
			}
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
