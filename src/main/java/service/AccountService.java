package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import dao.DaoProduct;

import entity.Account;
import entity.Cart;
import entity.Feedback;
import entity.Image;
import entity.Product;

public class AccountService {
	DaoProduct daoProduct = new DaoProduct();
	
	public int getCountQuery() {
		String HQL = "select count(A) From Account A Where A.isAdmin=0";
		return daoProduct.getCountQuery(HQL);
	}
}
