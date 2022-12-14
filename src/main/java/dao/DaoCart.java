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
import entity.Cart;
import entity.Product;

public class DaoCart extends IDAO<Cart>{
	@Override
	public int count(String queryName) {
		// TODO Auto-generated method stub
		return super.count(queryName);
	}
	@Override
	public Cart findSingleWithParams(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findSingleWithParams(queryName, params);
	}
	@Override
	public void CreateQueryWithParams(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		super.CreateQueryWithParams(queryName, params);
	}


	@Override
	public Cart findSingle(Class<Cart> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
	@Override
	public List<Cart> findAll(String queryString) {
		// TODO Auto-generated method stub
		return super.findAll(queryString);
	}
	
	@Override
	public void nativeQuery(String HQL, Map<String, Object> params) {
		// TODO Auto-generated method stub
		try {
			super.nativeQuery(HQL, params);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}