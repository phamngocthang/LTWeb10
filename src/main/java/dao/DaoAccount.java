package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import context.HibernateUtil;
import entity.Account;
import entity.Product;

public class DaoAccount {
	public Account Login(String user, String pass)
	{
	    Session session = HibernateUtil.getSessionFactory().openSession();
		Account acc = new Account();
		acc=null;
		String hql = "From Account A Where A.userName = :user and A.passWord = :pass";		
		acc= (Account) session.createQuery(hql, Account.class).setParameter("user",user).setParameter("pass",pass).uniqueResult();
		session.close();
		return acc;
	}
}
