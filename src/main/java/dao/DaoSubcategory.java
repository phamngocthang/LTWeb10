package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import context.HibernateUtil;
import entity.Category;
import entity.Subcategory;

public class DaoSubcategory extends IDAO<Subcategory>{

  // get all category with jpa
  @Override
	public List<Subcategory> findAll(String queryString) {
		// TODO Auto-generated method stub
	  queryString = "From Subcategory";
		return super.findAll(queryString);
	}  
}
