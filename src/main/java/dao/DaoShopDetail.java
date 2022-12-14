package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class DaoShopDetail extends IDAO<Product> {

	@Override
	public Product findSingle(Class<Product> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
    @Override
    public List<Product> findWithParams(String queryString, Map<String, Object> params) {
    	// TODO Auto-generated method stub
    	return super.findWithParams(queryString, params);
    }
}