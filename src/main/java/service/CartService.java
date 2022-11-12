package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import dao.DaoAccount;
import dao.DaoCart;
import dao.DaoShopDetail;
import entity.Account;
import entity.Cart;
import entity.Image;
import entity.Product;

public class CartService {
	DaoCart daoCart = new DaoCart();
	public Account getAccount(String userName, String Password) {
		/*
		Account acc = new Account();
		String HQL = "From Account A Where A.userName = :userName And A.passWord = :passWord";
		
		//System.out.println(HQL);
		List<Account> account = daoAcccout.getAccount(HQL, userName, Password);
		if(account.size() == 0) {
			return null;
		}
		for (Account ac : account) {
			return ac;
		}
		
		*/
		return null;
	}
	
	
	
	public void editAmountCart(String userName, String productID, int amount) {
		/*
        String query = "update Cart set [amount]=?,\r\n"
        		+ "[size]=?\r\n"
        		+ "where [accountID]=? and [productID]=?";
        */
        String HQL = "Update Cart c set c.amount=:amount Where c.account='"+ userName+"' and c.product=" + productID;
        daoCart.editAmountCart(HQL, amount);
  
    }
	public void deleteCart(int productID) {
		/*
        String query = "update Cart set [amount]=?,\r\n"
        		+ "[size]=?\r\n"
        		+ "where [accountID]=? and [productID]=?";
        */
        String HQL = "Delete From Cart c Where c.product=" + Integer.toString(productID);
        daoCart.deleteCart(HQL);
    }
	
	public void deleteCartByUser(String userName) {
		/*
        String query = "update Cart set [amount]=?,\r\n"
        		+ "[size]=?\r\n"
        		+ "where [accountID]=? and [productID]=?";
        */
        String HQL = "Delete From Cart c Where c.account='" + userName +"'";
        daoCart.deleteCart(HQL);
    }
	
	public void insertCart(String userName, String productID, int amount) {
		/*
        String query = "update Cart set [amount]=?,\r\n"
        		+ "[size]=?\r\n"
        		+ "where [accountID]=? and [productID]=?";
        */
        String HQL = "INSERT INTO Cart(userName, id_P, amount) Values (:userName, :productID, :amount)";
       daoCart.insertCart(HQL, userName, productID, amount);
  
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
		CartService carservice = new CartService();
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

		CartService carservice = new CartService();
		carservice.deleteCartByUser("pntnoah");
	}
}
