package dao;

import java.util.List;

import entities.Account;

public interface AccountDao {

	public void insert(Account obj);
	public void update(Account obj);
	public Account findById(int id);
	public List<Account> findAll();
	public void tranfer(int sourceId, int targetId, double amount);
}
