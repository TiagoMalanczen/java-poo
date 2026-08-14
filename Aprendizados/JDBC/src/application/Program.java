package application;

import java.sql.Connection;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DB.getConnection();
			
			System.out.println("Conexao bem sucedida!");
		}
		catch (Exception e) {
		}
		finally {
			DB.closeConnection();
			System.out.println("Conexao fechada");
		}
	}
}
