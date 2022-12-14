package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import context.HibernateUtil;
import entity.Account;
import entity.Customer;

public class DaoAccount extends IDAO<Account>  {
	
	
	@Override
	public int count(String queryName) {
		// TODO Auto-generated method stub
		return super.count(queryName);
	}
	@Override
	public Account findSingleWithParams(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		queryName = "From Account A Where A.userName = :user and A.passWord = :pass";
		return super.findSingleWithParams(queryName, params);
	}
	
	@Override
	public List<Account> findAll(String queryString) {
		// TODO Auto-generated method stub
		queryString = "From Account";
		return super.findAll(queryString);
	}
	
	@Override
	public Account findSingle(Class<Account> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
	
	@Override
	public Account create(Account entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}
	@Override
	public Account update(Account entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
	

}
