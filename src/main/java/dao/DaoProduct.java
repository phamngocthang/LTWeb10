package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.EntityTransaction;

import context.HibernateUtil;
import entity.Image;
import entity.Product;

public class DaoProduct {
	public List<Product> getTopProduct(String HQL, int amount) {
		List<Product> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery(HQL, Product.class).setMaxResults(amount).getResultList();
			session.close();
		} catch (Exception e) {
		}
		return list;
	}
	
	public List<Object[]> getProductByCate(String HQL) {
		List<Object[]> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createNativeQuery(HQL).getResultList();
			session.close();
		} catch (Exception e) {
		}
		return list;
	}

	public List<Product> getRecentProduct(String HQL, int amount) {

		List<Product> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery(HQL, Product.class).setMaxResults(amount).getResultList();
			session.close();
		} catch (Exception e) {
		}
		return list;
	}

	public int getCountProduct(String HQL) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Long count1 = ((Long) session.createQuery(HQL).uniqueResult());
			Integer count = count1.intValue();

			return count;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public int getCountQuery(String HQL) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Long count1 = ((Long) session.createQuery(HQL).uniqueResult());
			Integer count = count1.intValue();

			return count;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public List<Product> searchByName(String HQL, String txtSearch) {
		List<Product> list = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		EntityTransaction trans = session.getTransaction();
		try {

			trans.begin();
			list = session.createQuery(HQL, Product.class).list();
			trans.commit();
			session.close();

		} catch (Exception e) {
			trans.rollback();
		}
		return list;
	}

	public List<Product> pagingAccount(String HQL, int offset, int limit) {
		List<Product> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery(HQL, Product.class).setFirstResult(offset).setMaxResults(limit).list();
			session.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public List<Product> getProductAjax(String HQL, int offset, int limit) {
		List<Product> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery(HQL, Product.class).setFirstResult(offset).setMaxResults(limit).list();
			session.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;

	}

	public List<Product> getAllProduct(String HQL) {
		List<Product> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery(HQL, Product.class).list();
			session.close();

		} catch (Exception e) {
		}
		return list;
	}
	public void insertProduct(Product product, Image img) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
    		session.save(product);
    		session.save(img);
    		session.getTransaction().commit();
    		session.close();
    		
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	public void updateStatus(String HQL) {
		Session session = HibernateUtil.getSessionFactory().openSession();
    	EntityTransaction trans = session.getTransaction();
    	Query query = session.createQuery(HQL);
    	trans.begin();
    	try {
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
	public void updateProduct(Product product, Image img) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
    		session.update(product);
    		session.update(img);
    		session.getTransaction().commit();
    		session.close();
    		
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	public void deleteProduct(String HQL) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery(HQL);
		try{
			session.getTransaction().begin();
    		query.executeUpdate();
    		session.getTransaction().commit();
    		session.close();
    		
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}