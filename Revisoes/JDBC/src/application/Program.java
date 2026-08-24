package application;

import java.sql.Connection;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = DB.openConnection();
		
		System.out.println("Conexao aberta com sucesso");
		
		DB.closeConnection();
		
		System.out.println("Conexao fechada com sucesso");

	}
}
