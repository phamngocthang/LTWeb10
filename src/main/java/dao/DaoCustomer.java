package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import context.HibernateUtil;
import entity.Account;
import entity.Customer;

public class DaoCustomer extends IDAO<Customer> {
	@Override
	public Customer findSingle(Class<Customer> type, Object key) {
		// TODO Auto-generated method stub
		return super.findSingle(type, key);
	}
	
	@Override
	public Customer create(Customer entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}
	@Override
	public Customer update(Customer entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
}
