package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import context.HibernateUtil;
import entity.Account;
import entity.Customer;

public class DaoCustomer {
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
	public int UpdateCustomer(String user, String firstName, String lastName, String email, String address, String phone)
	{
		int row=0;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "UPDATE Customer SET firstName=:firstName, lastName=:lastName, email=:email, address=:address, phonenumber=:phone WHERE userName=:user";		
			Transaction tx=session.beginTransaction();  
			Query query = session.createQuery(hql);
			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);
			query.setParameter("email", email);
			query.setParameter("address", address);
			query.setParameter("phone", phone);
			query.setParameter("user", user);
			row=query.executeUpdate();
			tx.commit(); 
			session.close();
		}
		catch (Exception e){	    	
	    }
		return row;
	}
	public Customer getCustomer(String user) {
		Customer customer = new Customer();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			String hql = "From Customer C Where C.userName = :user";		
			customer =  session.createQuery(hql, Customer.class).setParameter("user",user).uniqueResult();
		}
		catch (Exception e){			
		}
		return customer;
	}
}
