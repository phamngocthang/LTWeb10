package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import context.HibernateUtil;
import entity.Account;
import entity.Customer;

public class DaoAccount {
	public Account Login(String user, String pass)
	{
		Account acc = new Account();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			acc=null;
			String hql = "From Account A Where A.userName = :user and A.passWord = :pass";		
			acc= (Account) session.createQuery(hql, Account.class).setParameter("user",user).setParameter("pass",pass).uniqueResult();
			session.close();
		}
		catch (Exception e){
	    	
	    }
		return acc;
	}
	public int Signup(String username, String password, String repassword, int isadmin)
	{
		int row=0;
		if(password.equals(repassword))
		{
			try {
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
			}
			catch (Exception e){	    	
		    }
		}
		return row;
	}
	public void InsertCustomer(String username)
	{

			try {
				Session session = HibernateUtil.getSessionFactory().openSession();			
				String hql = "INSERT INTO Customer Values (:username, '', '', '', '', '')" ;
				Transaction tx=session.beginTransaction();  
				Query query = session.createNativeQuery(hql);
				query.setParameter("username",username);
				query.executeUpdate();
				tx.commit();
				session.close();
			}
			catch (Exception e){	    	
		    }


	}
	
	
	public int UpdatePassword (String user, String oldPass, String newPass1, String newPass2) {
		int row=0;
		if(newPass1.equals(newPass2))
		{
			try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				String hql = "Update Account Set passWord=:newPass1 Where userName = :user And passWord = : oldPass";		
				Transaction tx=session.beginTransaction();  
				Query query = session.createQuery(hql);
				query.setParameter("newPass1", newPass1);
				query.setParameter("oldPass", oldPass);
				query.setParameter("user", user);
				row=query.executeUpdate();
				tx.commit(); 
				session.close();
			}
			catch (Exception e){			
			}
		}
		return row;
	}
	public Customer getCustomer(String user) {
		Customer customer = new Customer();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "From Customer C Where C.userName = :user";		
			customer=  session.createQuery(hql, Customer.class).setParameter("user",user).uniqueResult();
			session.close();
		}
		catch (Exception e){
			
		}
		return customer;
	}
	
	public List<Account> getAllAccount(String HQL) {
	    List<Account> list = new ArrayList<>();

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	      list = session.createQuery(HQL, Account.class).getResultList();
	      session.close();
	    } catch (Exception e) {
	    }
	    return list;
	  }
	public Account getAccountByUsername(String HQL, String username) {
	    Account acc = new Account();

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	      acc = session.createQuery(HQL, Account.class).setParameter("username", username).uniqueResult();
	      session.close();
	    } catch (Exception e) {
	    }
	    return acc;
	  }
}
