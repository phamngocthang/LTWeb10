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
import entity.Bill;
import entity.Billdetail;

public class DaoBill {
	public List<Bill> getAllBill(String HQL) {
		List<Bill> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery(HQL, Bill.class).list();
			session.close();

		} catch (Exception e) {
		}
		return list;
	}

	public List<Billdetail> getAllBillDetail(String HQL, Integer idBill) {
		List<Billdetail> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createQuery(HQL, Billdetail.class).setParameter("id", idBill).getResultList();

			session.close();
		} catch (Exception e) {
		}
		return list;
	}

	public List<Object[]> getTopBill(String HQL) {

		List<Object[]> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createNativeQuery(HQL).getResultList();
			session.close();
		} catch (Exception e) {
		}
		return list;
	}
	
	public List<Object[]> getBillInMonth(String HQL) {

		List<Object[]> list = new ArrayList<>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			list = session.createNativeQuery(HQL).getResultList();
			session.close();
		} catch (Exception e) {
		}
		return list;
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

	public int getMaxIDBill(String HQL) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			int count = (Integer) session.createQuery(HQL).uniqueResult();

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
		} catch (Exception e) {
			trans.rollback();
		} finally {
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
		} catch (Exception e) {
			trans.rollback();
		} finally {
			session.close();
		}
	}

	public Bill getBillByID(String HQL, int id) {
		Bill bill = new Bill();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			bill = session.createQuery(HQL, Bill.class).setParameter("id", id).getSingleResult();
			session.close();
		} catch (Exception e) {
		}
		return bill;
	}



	public static void main(String[] args) {
		DaoBill dao = new DaoBill();
		// print length
		System.out.println(dao.getAllBillDetail("From Billdetail where idBill = :id", 3).size());
	}
}