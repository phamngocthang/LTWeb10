package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.query.Query;

import context.HibernateUtil;
import entity.Product;

public class IDAO<T> {
	public IDAO () {
		
	}
	public T create(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.getTransaction().begin();
	    session.persist(entity);
	    session.getTransaction().commit();
	    session.close();
	    return entity;
	 }
	
	public T update(T entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.getTransaction().begin();
	    entity = (T) session.merge(entity);
	    session.getTransaction().commit();
	    session.close();
	    return entity;
	  }
	
	  public void delete(Class<T> type, Object id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.getTransaction().begin();
	    Object reference = session.getReference(type, id);
	    session.remove(reference);
	    session.getTransaction().commit();
	    session.close();
	  }
	  
	public T findSingle(Class<T> type, Object key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		T result = session.find(type, key);
		if (result != null) {
		      session.refresh(result);
		}
		session.close();
		return result;
	}
	@SuppressWarnings("unchecked")
	public T findSingleWithParams(String queryName, Map<String, Object> params) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		EntityTransaction trans = session.getTransaction();
		Query query = session.createQuery(queryName);
		Set<Entry<String, Object>> setParameters = params.entrySet();
		trans.begin();
	    for (Entry<String, Object> entry : setParameters) {
	      query.setParameter(entry.getKey(), entry.getValue());
	    }
	    T result = (T) query.uniqueResult();
	    trans.commit();
	    session.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findWithParams(String queryString, Map<String, Object> params) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createQuery(queryString);
		Set<Entry<String, Object>> setParameters = params.entrySet();
	    for (Entry<String, Object> entry : setParameters) {
	      query.setParameter(entry.getKey(), entry.getValue());
	    }
	    List<T> result = query.list();
		session.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public void CreateQueryWithParams(String queryName, Map<String, Object> params) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		EntityTransaction trans = session.getTransaction();
		Query query = session.createQuery(queryName);
		Set<Entry<String, Object>> setParameters = params.entrySet();
		trans.begin();
	    for (Entry<String, Object> entry : setParameters) {
	      query.setParameter(entry.getKey(), entry.getValue());
	    }
	    query.executeUpdate();
	    trans.commit();
	    session.close();
	}
	
	@SuppressWarnings("unchecked")
	public void nativeQuery(String HQL, Map<String, Object> params) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	EntityTransaction trans = session.getTransaction();
    	Query query = session.createNativeQuery(HQL);
    	trans.begin();
    	try {
    		Set<Entry<String, Object>> setParameters = params.entrySet();
    	    for (Entry<String, Object> entry : setParameters) {
    	      query.setParameter(entry.getKey(), entry.getValue());
    	    }
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
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(String queryString) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<T> result = session.createQuery(queryString).list();
		session.close();
		return result;
	}
	
	public List<T> findAllLimit(String queryString, int amount) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<T> list = session.createQuery(queryString).setMaxResults(amount).getResultList();
		session.close();
		return list;
	}
	
	public int count(String queryName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.getTransaction().begin();

	    int Result = ((Long) session.createQuery(queryName).getSingleResult()).intValue();

	    session.getTransaction().commit();
	    session.close();
	    return Result;
	  }
}
