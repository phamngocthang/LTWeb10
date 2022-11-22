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

public class DaoBill {
	
	public List<Object[]> getTopBill(String HQL) {
		
    	List<Object[]> list = new ArrayList<>();
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		list = session.createNativeQuery(HQL).getResultList();
    		session.close();
		} catch (Exception e) {
		}
    	return list;
	}
	
	public int getSumBill(String HQL) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		double count1 = ((double) session.createQuery(HQL).uniqueResult());
    		return (int)count1;
    		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        return -1;
    }
	
	public int getMaxIDBill(String HQL) {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		int count = (Integer)session.createQuery(HQL).uniqueResult();

    		return count++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return -1;
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
	}
}