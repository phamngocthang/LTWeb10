package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import context.HibernateUtil;
import dao.DaoProduct;
import dao.DaoAccount;
import entity.Account;
import entity.Customer;

public class AccountService {
	DaoProduct daoProduct = new DaoProduct();
	DaoAccount daoAccount = new DaoAccount();
	public int getCountQuery() {
		String HQL = "select count(A) From Account A Where A.isAdmin=0";
		return daoAccount.count(HQL);
	}
	
	public Account getSingle(String username) {
		return daoAccount.findSingle(Account.class, username);	
	}
	
	public List<Account> getAllAccount() {
		return daoAccount.findAll("");
	}
	
	
	public Account getAccount(String user, String pass) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", user);
		params.put("pass", pass);
		return daoAccount.findSingleWithParams("", params);
	}
	
	
	public int UpdatePassword (String user, String oldPass, String newPass1, String newPass2) {
		int row=0;
		if(newPass1.equals(newPass2))
		{
			try {
				Account acc = daoAccount.findSingle(Account.class, user);

					acc.setPassWord(newPass1);
					daoAccount.update(acc);
					row = 1;

			}
			catch (Exception e){			
			}
		}
		return row;
	}
	
	public int Signup(String username, String password, String repassword, int isadmin)
	{
		int row=0;
		if(password.equals(repassword))
		{
			try {
				Account acc = new Account();
				acc.setUserName(username);
				acc.setPassWord(password);
				acc.setIsAdmin(isadmin);
				daoAccount.create(acc);
				
				/*
				Session session = HibernateUtil.getSessionFactory().openSession();			
				String hql = "INSERT INTO Account (userName, passWord, isAdmin) Values (:username, :password, :isadmin)" ;
				Transaction tx=session.beginTransaction();  
				Query query = session.createNativeQuery(hql);
				query.setParameter("username",username);
				query.setParameter("password",password);
				query.setParameter("isadmin",isadmin);
				row=query.executeUpdate();
				tx.commit();
				session.close();
				*/
				row = 1;
			}
			catch (Exception e){	    	
		    }
		}
		return row;
	}
}
