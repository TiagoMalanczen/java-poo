package application;

import java.sql.Connection;
import java.util.List;

import dao.AccountDao;
import dao.AccountJDaoDBC;
import db.DB;
import db.DBException;
import entities.Account;

public class Program {

    public static void main(String[] args) {

        Connection conn = DB.openConnection();
        AccountDao prog = new AccountJDaoDBC(conn);

        try {
            Account ac1 = new Account(null, "Joaozin", 1500.0);
            System.out.println("Teste insert:");
            prog.insert(ac1);
            System.out.println("Inserido! Novo ID: " + ac1.getId());

            System.out.println("\nTeste update:");
            Account ac2 = new Account(1, "Maria", 5000.0);
            prog.update(ac2);
            System.out.println("Atualizado com sucesso");

            System.out.println("\nTeste findById:");
            Account accFound = prog.findById(1);
            System.out.println(accFound);

            System.out.println("\nTeste findAll:");
            List<Account> list = prog.findAll();
            for (Account acc : list) {
                System.out.println(acc);
            }

            System.out.println("\nTeste transfer:");
            prog.tranfer(2, 1, 300.0);
            System.out.println("Transferencia concluida com sucesso");

        } catch (DBException e) {
            System.err.println("Erro na operacao: " + e.getMessage());
        } finally {
            DB.closeConnection();
        }
    }
}