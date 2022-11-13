package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import dao.DaoAccount;
import dao.DaoBill;
import dao.DaoCart;
import dao.DaoShopDetail;
import entity.Account;
import entity.Cart;
import entity.Image;
import entity.Product;

public class BillService {
	DaoBill daoBill = new DaoBill();
	DaoCart daoCart = new DaoCart();
	
	public void insertBill(String userName, int totalPrice) {
		/*
        String query = "update Cart set [amount]=?,\r\n"
        		+ "[size]=?\r\n"
        		+ "where [accountID]=? and [productID]=?";
        */
        String HQL = "INSERT INTO Bill(userName, totalPrice, date) Values (:userName, :totalPrice, :date)";
       daoBill.insertBill(HQL, userName, totalPrice);
  
    }
	
	public void insertBillDeTail(int idBill, int productID, int amount) {
		/*
        String query = "update Cart set [amount]=?,\r\n"
        		+ "[size]=?\r\n"
        		+ "where [accountID]=? and [productID]=?";
        */
        String HQL = "INSERT INTO Billdetail(idBill, id_P, amount) Values (:idBill, :id_P, :amount)";
       daoBill.insertBillDeTail(HQL, idBill, productID, amount);
  
    }
	
	public int getMaxIDBill() {
		/*
        String query = "update Cart set [amount]=?,\r\n"
        		+ "[size]=?\r\n"
        		+ "where [accountID]=? and [productID]=?";
        */
       String HQL = "Select max(B.idBill) from Bill B";
       return daoBill.getMaxIDBill(HQL);
  
    }
	
	
	public static void main(String[] args) {

		BillService carservice = new BillService();
		System.out.println(carservice.getMaxIDBill());
	}
}
