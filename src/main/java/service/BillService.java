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
	public Cart checkCartExist(String userName,String productID) {
		String HQL = "From Cart C Where C.account='" + userName +"' And C.product=" + productID;
		//String HQL1 = "From Cart C Where C.account=:userName And C.product=" + productID;
		//String HQL2 = "From Cart C";
		Cart cart = daoCart.getCart(HQL, userName, productID);
		return cart;
	    
	}
	
	
	public List<Cart> getCartByUserName(String userName) {
		List<Cart> cart = new ArrayList<>();
		String HQL = "From Cart C Where C.account='" + userName + "'";
		cart = daoCart.getCartByUserName(HQL);
		return cart;
	       
	}
	
	public List<Product> getProductByPIDAndUserName(String userName) {
		List<Product> product = new ArrayList<>();
		BillService carservice = new BillService();
		List<Cart> cart = carservice.getCartByUserName(userName);
		for (Cart c : cart) {
			String HQL = "From Product P Where P.id_P=:productID";
			Product p = daoCart.getProductByID(HQL, c.getProduct().getId_P());
			product.add(p);
		}
		//String HQL = "Select P.name_P, P.price, P.image From Product P";
		//product = daoCart.getProductByID(HQL);
		return product;
	}
	
	public static void main(String[] args) {

		BillService carservice = new BillService();
		System.out.println(carservice.getMaxIDBill());
	}
}
