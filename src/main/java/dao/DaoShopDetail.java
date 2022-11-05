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
import entity.Image;
import entity.Product;
public class DaoShopDetail {
	public Product getProductByID(String id) {
		  Product product = new Product();
		  try (Session session = HibernateUtil.getSessionFactory().openSession()){
  		//trans.begin();
  		//CriteriaBuilder builder = session.getCriteriaBuilder();
  		//CriteriaQuery <Product> query = builder.createQuery(Product.class);
  		//Root proot = query.from(Product.class);
  		//query = query.select(proot);
  		String hql = "From Product P Where P.id_P = :id";
  		//Query q = session.createQuery(hql, Product.class);
  		//q.setParameter("id", id);
  		//product  = q.uniqueResult();
  		//product = session.createQuery(hql, Product.class).setParameter("id", id).uniqueResult();
  		product = session.get(Product.class, Integer.parseInt(id));
  		//trans.commit();
  		session.close();
		  } catch (Exception e) {
		  }
		  return product;
		}
    public List<Product> getRecentProduct(String HQL, int amount) {
		
    	List<Product> list = new ArrayList<>();
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		list = session.createQuery(HQL, Product.class ).setMaxResults(amount).getResultList();
    		session.close();
		} catch (Exception e) {
		}
    	return list;
	}
}