package dao;

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
import entity.Feedback;
import entity.Product;

public class DaoReview {
	
	
	private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
	
	public void insertReview(String HQL, String productID, String userName, String content) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	EntityTransaction trans = session.getTransaction();
    	Query query = session.createNativeQuery(HQL);
    	trans.begin();
    	try {
    		query.setParameter("id_P", productID);
    		query.setParameter("userName", userName);
    		query.setParameter("rate", 5);
    		query.setParameter("content", content);
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
	
	
	public List<Feedback> showReview(String HQL) {
    	
    	List<Feedback> fb = new ArrayList<>();
    	try {
    		Session session = HibernateUtil.getSessionFactory().openSession();
    		fb = session.createQuery(HQL, Feedback.class).getResultList();
    		session.close();
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
		}
    	return fb;
	}
	
	public static void main (String[] args) { 
	}
}