package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;

public class Program {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.openConnection();
			
			st = conn.prepareStatement(""
					+ "UPDATE SELLER "
					+ "SET BASESALARY = BASESALARY + ?"
					+ "WHERE (DEPARTMENTID = ?)");
			st.setDouble(1, 500.0);
			st.setInt(2, 2);
			
			st.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatemetn(st);
			DB.closeConnection();
		}
	}
}
