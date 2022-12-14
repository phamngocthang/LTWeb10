package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

public class DaoProduct extends IDAO<Product>{
	
	@Override
	public void nativeQuery(String HQL, Map<String, Object> params) {
		// TODO Auto-generated method stub
		super.nativeQuery(HQL, params);
	}
	
	@Override
	public Product findSingle(Class<Product> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
	
	@Override
	public List<Product> findAll(String queryString) {
		// TODO Auto-generated method stub
		return super.findAll(queryString);
	}
	
	@Override
	public List<Product> findAllLimit(String queryString, int amount) {
		// TODO Auto-generated method stub
		return super.findAllLimit(queryString, amount);
	}
	public List<Product> getRecentProduct() {
		String HQL = "From Product P ORDER BY P.id_P DESC";
		return findAllLimit(HQL, 4);
	}
	public List<Product> getTopProduct() {
		String HQL = "SELECT P FROM Product P, Billdetail B WHERE P.id_P = B.product.id_P GROUP BY P.id_P ORDER BY COUNT(P.id_P) DESC";
		return findAllLimit(HQL, 4);
	}
	@Override
	public int count(String queryName) {
		// TODO Auto-generated method stub
		return super.count(queryName);
	}

	public int getCountProduct(String HQL) {
		
		return count(HQL);
	}

	public int getCountQuery(String HQL) {
		return count(HQL);
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

	public List<Product> pagingAccount(String HQL, int offset, int limit) {
		List<Product> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery(HQL, Product.class).setFirstResult(offset).setMaxResults(limit).list();
			session.close();

		} catch (Exception e) {
		}
		return list;

	}

	public List<Product> getProductAjax(String HQL, int offset, int limit) {
		List<Product> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery(HQL, Product.class).setFirstResult(offset).setMaxResults(limit).list();
			session.close();

		} catch (Exception e) {
		}
		return list;

	}

	
	@Override
	public Product create(Product entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}
	
	@Override
	public void CreateQueryWithParams(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		super.CreateQueryWithParams(queryName, params);
	}
	public boolean updateProduct(Product product, Image img) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.getTransaction().begin();
    		session.update(product);
    		session.update(img);
    		session.getTransaction().commit();
    		session.close();
    		return true;
    		
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}
	}
}