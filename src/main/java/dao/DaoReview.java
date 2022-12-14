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
import entity.Feedback;
import entity.Product;

public class DaoReview extends IDAO<Feedback> {
	
	
	private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
	
	@Override
	public Feedback create(Feedback entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}
	@Override
	public void nativeQuery(String HQL, Map<String, Object> params) {
		// TODO Auto-generated method stub
		
		super.nativeQuery(HQL, params);
	}
	@Override
	public List<Feedback> findAll(String queryString) {
		// TODO Auto-generated method stub
		return super.findAll(queryString);
	}
	
}