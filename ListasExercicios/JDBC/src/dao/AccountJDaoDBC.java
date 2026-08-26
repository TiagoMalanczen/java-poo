package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DBException;
import entities.Account;

public class AccountJDaoDBC implements AccountDao {

    private Connection conn;

    public AccountJDaoDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Account obj) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                "INSERT INTO ACCOUNT (HOLDER, BALANCE) VALUES (?, ?)", 
                Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, obj.getName());
            st.setDouble(2, obj.getBalance());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    obj.setId(rs.getInt(1));
                }
            } else {
                throw new DBException("Nenhuma linha foi inserida.");
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatemtn(st);
        }
    }

    @Override
    public void update(Account obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                "UPDATE ACCOUNT SET HOLDER = ?, BALANCE = ? WHERE ID = ?"
            );
            st.setString(1, obj.getName());
            st.setDouble(2, obj.getBalance());
            st.setInt(3, obj.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeStatemtn(st);
        }
    }

    @Override
    public Account findById(int id) {
        PreparedStatement st = null; 
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM ACCOUNT WHERE ID = ?");
            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                return instanceAccount(rs.getInt("ID"), rs.getString("HOLDER"), rs.getDouble("BALANCE"));
            }
            return null;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatemtn(st);
        }
        
    }

    @Override
    public List<Account> findAll() {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM ACCOUNT");

            List<Account> list = new ArrayList<>();
            while (rs.next()) {
                Account acc = instanceAccount(rs.getInt("ID"), rs.getString("HOLDER"), rs.getDouble("BALANCE"));
                list.add(acc);
            }
            return list;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatemtn(st);
        }
    }

    private Account instanceAccount(int id, String holder, double balance) {
        return new Account(id, holder, balance);
    }

    @Override
    public void tranfer(int sourceId, int targetId, double amount) {
        PreparedStatement stDebit = null;
        PreparedStatement stCredit = null;

        try {
            conn.setAutoCommit(false);

            stDebit = conn.prepareStatement(
                "UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE ID = ?"
            );
            stDebit.setDouble(1, amount);
            stDebit.setInt(2, sourceId);
            stDebit.executeUpdate();

            stCredit = conn.prepareStatement(
                "UPDATE ACCOUNT SET BALANCE = BALANCE + ? WHERE ID = ?"
            );
            stCredit.setDouble(1, amount);
            stCredit.setInt(2, targetId);
            stCredit.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
                throw new DBException("Transacao nao concluida: " + e.getMessage());
            } catch (SQLException eRollback) {
                throw new DBException("Erro no rollback: " + eRollback.getMessage());
            }
        } finally {
            DB.closeStatemtn(stDebit);
            DB.closeStatemtn(stCredit);
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                throw new DBException(e.getMessage());
            }
        }
    }
}