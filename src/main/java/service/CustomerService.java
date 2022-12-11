package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.DaoCart;
import dao.DaoCustomer;
import entity.Customer;

public class CustomerService {
	
	DaoCustomer daoCustomer = new DaoCustomer();
	
	public Customer checkCustomerExist(String userName) {
		Customer cus = daoCustomer.getCustomer(userName);
		return cus;	       
	}
}
