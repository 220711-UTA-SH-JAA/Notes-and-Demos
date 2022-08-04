package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Account;
import com.example.utils.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{
	
	ConnectionUtil conUtil = ConnectionUtil.getInstance();

	@Override
	public void createAccount(Account a) {
		try {
			
			Connection c = conUtil.getConnection("bankdb");
			
			String sql = "INSERT INTO account(account_type, account_balance, account_owner) VALUES (?,?,?)";
			
			PreparedStatement p = c.prepareStatement(sql);
			
			p.setString(1, a.getAccountType());
			p.setDouble(2, a.getAccountBalance());
			p.setInt(3,  a.getAccountHolder());
			
			p.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Account> readAllAcounts() {
		
		List<Account> accounts = new ArrayList<>();
		
		try {
			
			Connection c = conUtil.getConnection("bankdb");
			
			String sql = "SELECT * FROM account";
			
			Statement s = c.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				//accounts is an arraylist that is initially empty
				//The resultset (rs) will returns rows that look like this:
					//1	 Checking 100	1
				//The above cannot be directly mapped to a java object, so we must create new objects for each row in the resultset
				//For each row in the result set, we create a new account object in java, and add it to the list
				accounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	public void updateAccount(Account a) {
		
		try {
			
			Connection c = conUtil.getConnection("bankdb");
			
			String sql = "UPDATE account SET account_balance= ? WHERE account_id = ?";
			
			PreparedStatement p = c.prepareStatement(sql);
			
			p.setDouble(1, a.getAccountBalance());
			p.setInt(2,  a.getAccountId());
			
			p.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAccount(int id) {
		try {
			
			Connection c = conUtil.getConnection("bankdb");
			
			String sql = "DELETE FROM account WHERE account_id = ?";
			
			PreparedStatement p = c.prepareStatement(sql);
			
			p.setInt(1,  id);
			
			p.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
