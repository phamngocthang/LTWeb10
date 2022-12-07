package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import dao.DaoProduct;
import dao.DaoAccount;
import entity.Account;

public class AccountService {
	DaoProduct daoProduct = new DaoProduct();
	DaoAccount daoAccount = new DaoAccount();
	public int getCountQuery() {
		String HQL = "select count(A) From Account A Where A.isAdmin=0";
		return daoProduct.getCountQuery(HQL);
	}
	
	public List<Account> getAllAccount() {
	    List<Account> list = new ArrayList<>();
	    String HQL = "From Account";
	    list = daoAccount.getAllAccount(HQL);
	    return list;
	  }
	
	public Account getAccountByUsername(String username) {
	    Account acc = new Account();
	    String HQL = "From Account Where userName = :username";
	    acc = daoAccount.getAccountByUsername(HQL, username);
	    return acc;
	  }
}
