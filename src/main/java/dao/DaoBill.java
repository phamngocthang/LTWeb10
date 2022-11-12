package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.EntityTransaction;

import context.HibernateUtil;
import entity.Account;
import entity.Bill;
import entity.Cart;
import entity.Image;
import entity.Product;

public class DaoBill {
	
	public int getMaxIDBill(String HQL) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		int count = (Integer)session.createQuery(HQL).uniqueResult();

    		return count++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return -1;
    }
	public Product getProductByID(String HQL,int productID) {
		Product product = new Product();
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		product = session.createQuery(HQL, Product.class).setParameter("productID", productID).uniqueResult();
    		
    		session.close();
    		
    		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return product;
	}
	public List<Cart> getCartByUserName(String HQL) {
		List<Cart> cart = new ArrayList<>();
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		cart = session.createQuery(HQL, Cart.class).list();
    		
    		session.close();
    		
    		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return cart;
	}
	
	public List<Product> getProductByID(String HQL) {
		List<Product> product = new ArrayList<>();
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		product = session.createQuery(HQL).list();
    		
    		session.close();
    		
    		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return product;
	}
	
	public void deleteCart(String HQL) {
		Session session = HibernateUtil.getSessionFactory().openSession();
    	EntityTransaction trans = session.getTransaction();
    	Query query = session.createQuery(HQL);
    	trans.begin();
    	try {
    		
    		
    		query.executeUpdate();
        	trans.commit();
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
			trans.rollback();
		}
    	finally {
			session.close();
		}
	}
	
	public void editAmountCart(String HQL, int amount) {
		Session session = HibernateUtil.getSessionFactory().openSession();
    	EntityTransaction trans = session.getTransaction();
    	Query query = session.createQuery(HQL);
    	trans.begin();
    	try {
    		
    		query.setParameter("amount", amount);
    		
    		query.executeUpdate();
        	trans.commit();
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
			trans.rollback();
		}
    	finally {
			session.close();
		}
	}
	private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
	
	public void insertBill(String HQL, String userName, int totalPrice) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	EntityTransaction trans = session.getTransaction();
    	Query query = session.createNativeQuery(HQL);
    	trans.begin();
    	try {
    		query.setParameter("userName", userName);
    		query.setParameter("totalPrice", totalPrice);
    		query.setParameter("date", getCurrentDate());
    		query.executeUpdate();
        	trans.commit();
    	}
    	catch (Exception e) {
			trans.rollback();
		}
    	finally {
			session.close();
		}
	}
	
	public void insertBillDeTail(String HQL, int idBill, int productID, int amount) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	EntityTransaction trans = session.getTransaction();
    	Query query = session.createNativeQuery(HQL);
    	trans.begin();
    	try {
    		query.setParameter("idBill", idBill);
    		query.setParameter("id_P", productID);
    		query.setParameter("amount", amount);
    		query.executeUpdate();
        	trans.commit();
    	}
    	catch (Exception e) {
			trans.rollback();
		}
    	finally {
			session.close();
		}
	}
	
	
	public static void main (String[] args) { 
		DaoBill dao = new DaoBill();
		String name = "'pntnoah'";
		String id = "1";
		
		/*
		for( Product o: list) {
		  System.out.println(o.getId_P());
		}
		*/
	}
}