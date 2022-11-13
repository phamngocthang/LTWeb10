package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.query.Query;

import context.HibernateUtil;
import entity.Favoriteproduct;
import entity.Product;

public class DaoFavoriteProduct {
	public List<Favoriteproduct> getFavoriteProductByUserName(String HQL) {
		List<Favoriteproduct> fproduct = new ArrayList<>();
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		fproduct = session.createQuery(HQL, Favoriteproduct.class).list();	
    		session.close();
    		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return fproduct;
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
	
	public Favoriteproduct getFavoriteProduct(String HQL, String userName, String productID) {
		Favoriteproduct fproduct = new Favoriteproduct();
    	try (Session session = HibernateUtil.getSessionFactory().openSession()){
    		fproduct = session.createQuery(HQL, Favoriteproduct.class).uniqueResult();
    		session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return fproduct;
	}
	public void insertFavoriteProduct(String HQL, String userName, String productID) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	EntityTransaction trans = session.getTransaction();
    	Query query = session.createNativeQuery(HQL);
    	trans.begin();
    	try {
    		query.setParameter("userName", userName);
    		query.setParameter("productID", productID);
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
	/*public static void main(String []args) {
		DaoFavoriteProduct a = new DaoFavoriteProduct();
		String userName = "pntnoah";
		int productID = 1;
		String HQL = "From Favoriteproduct F Where F.account='" + userName +"' And F.product=" + productID;
		List <Favoriteproduct> p = a.getFavoriteProductByUserName(HQL);
		for (Favoriteproduct f:p) {
			System.out.print(f.getIdSpyeuthich());
		}
	  }*/
}
