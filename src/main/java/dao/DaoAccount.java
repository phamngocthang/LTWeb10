package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import context.HibernateUtil;
import entity.Account;
import entity.Customer;
import entity.Product;

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
}
