package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import entity.Bill;
import entity.Billdetail;
import entity.Account;

public class DaoBill extends IDAO<Bill>{
	
	
	@Override
	public int count(String queryName) {
		// TODO Auto-generated method stub
		return super.count(queryName);
	}
	@Override
	public List<Bill> findWithParams(String queryString, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findWithParams(queryString, params);
	}
	@Override
	public List<Bill> findAll(String queryString) {
		// TODO Auto-generated method stub
		queryString = "from Bill";
		return super.findAll(queryString);
	}
	public List<Object[]> getTopBill(String HQL) {

		List<Object[]> list = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		list = session.createNativeQuery(HQL).getResultList();
		session.close();
		return list;
	}
	
	public List<Object[]> getBillInMonth(String HQL) {

		List<Object[]> list = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		list = session.createNativeQuery(HQL).getResultList();
		session.close();
		return list;
	}
	
	public int getMaxIDBill(String HQL) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			int count = (Integer) session.createQuery(HQL).uniqueResult();

			return count++;
		} catch (Exception e) {
		}
		return -1;
	}
	
	public int getSumBill(String HQL) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			double count1 = ((double) session.createQuery(HQL).uniqueResult());
			return (int) count1;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public int getMaxIDBill() {
		String HQL = "Select max(B.idBill) from Bill B";
		return count(HQL);
	}

	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	@Override
	public void nativeQuery(String HQL, Map<String, Object> params) {
		// TODO Auto-generated method stub
		super.nativeQuery(HQL, params);
	}

	/*
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
		} catch (Exception e) {
			trans.rollback();
		} finally {
			session.close();
		}
	}
	*/
	@Override
	public Bill findSingleWithParams(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findSingleWithParams(queryName, params);
	}

}