package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import context.HibernateUtil;
import dao.DaoCart;
import dao.DaoCustomer;
import entity.Customer;

public class CustomerService {
	
	DaoCustomer daoCustomer = new DaoCustomer();
	
	public Customer checkCustomerExist(String userName) {
		Customer cus = daoCustomer.findSingle(Customer.class, userName);
		return cus;	       
	}
	
	public Customer getCustomerByID(String userName) {
		return daoCustomer.findSingle(Customer.class, userName);
	}
	
	public void InsertCustomer(String username)
	{
		Customer cust = new Customer(username, "", " ", " ", " ");
		cust.setAddress(" ");
		daoCustomer.create(cust);
	}
	
	public int UpdateCustomer(String user, String firstName, String lastName, String email, String address, String phone)
	{
		int row=0;
		try {
			Customer cust = new Customer(user, address, email, firstName, lastName, phone);
			daoCustomer.update(cust);
			/*
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
			*/
			row = 1;
		}
		catch (Exception e){	    	
	    }
		return row;
	}
}
