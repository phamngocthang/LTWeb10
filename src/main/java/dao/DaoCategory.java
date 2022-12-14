package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import context.HibernateUtil;
import entity.Category;
import entity.Subcategory;

public class DaoCategory extends IDAO<Category>{

  @Override
	public List<Category> findAll(String queryString) {
		// TODO Auto-generated method stub
	    queryString = "From Category";
		return super.findAll(queryString);
	}
  @Override
	public int count(String queryName) {
		// TODO Auto-generated method stub
		return super.count(queryName);
	}
}
