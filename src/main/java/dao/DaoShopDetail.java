package dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import context.HibernateUtil;
import entity.Product;
public class DaoShopDetail {
	public Product getProductByID(int id) {
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
  		product = session.get(Product.class, id);
  		//trans.commit();
  		session.close();
		  } catch (Exception e) {
		  }
		  return product;
		}
    public List<Product> getAllProductByBrand(String brand, int id) {
		
    	List<Product> list = new ArrayList<>();
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		String HQL = "From Product P Where P.brand = :brand and P.id_P != :id";
    		Query <Product>query = session.createQuery(HQL, Product.class);
    		query.setParameter("id", id);
    		query.setParameter("brand", brand);
      		list  = query.getResultList();
    		session.close();
		} catch (Exception e) {
			
		}
    	return list;
	}
    /*public static void main (String[] args) { 
		ShopDetailService dao = new ShopDetailService(); 
    	//DaoShopDetail dao = new DaoShopDetail(); 
		List<Product> list = dao.getAllProductByBrand("Nike",7);
		
		for( Product o: list) {
		  System.out.println(o.getId_P());
		}
		
	}*/
}