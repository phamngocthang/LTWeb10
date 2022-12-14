package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;

import context.HibernateUtil;
import entity.Favoriteproduct;
import entity.Product;

public class DaoFavoriteProduct extends IDAO<Favoriteproduct> {
	@Override
	public int count(String queryName) {
		// TODO Auto-generated method stub
		return super.count(queryName);
	}
	
	@Override
	public List<Favoriteproduct> findWithParams(String queryString, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findWithParams(queryString, params);
	}

	
	
	@Override
	public Favoriteproduct findSingleWithParams(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findSingleWithParams(queryName, params);
	}
	@Override
	public void nativeQuery(String HQL, Map<String, Object> params) {
		// TODO Auto-generated method stub
		super.nativeQuery(HQL, params);
	}
	@Override
	public void CreateQueryWithParams(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		super.CreateQueryWithParams(queryName, params);
	}
	
}
