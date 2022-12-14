package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dao.DaoCart;
import dao.DaoProduct;
import entity.Account;
import entity.Cart;
import entity.Image;
import entity.Product;

public class CartService {
	DaoCart daoCart = new DaoCart();
	DaoProduct daoProduct = new DaoProduct();
	public void editAmountCart(String userName, String productID, int amount) {
        String HQL = "Update Cart c set c.amount=:amount Where c.account='"+ userName+"' and c.product=" + productID;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("amount", amount);
        daoCart.CreateQueryWithParams(HQL, params);
    }
	
	public void deleteCart(int productID, String userName) {
        String HQL = "Delete From Cart Where id_P=" + Integer.toString(productID) + " and userName='" + userName+ "'";
        Map<String, Object> params = new HashMap<String, Object>();
        daoCart.nativeQuery(HQL, params);
    }
	
	public void deleteCartByUser(String userName) {
        String HQL = "Delete From Cart Where userName='" + userName +"'";
        Map<String, Object> params = new HashMap<String, Object>();
        daoCart.nativeQuery(HQL, params);
    }
	
	public void insertCart(String userName, String productID, int amount) {
        String HQL = "INSERT INTO Cart(userName, id_P, amount) Values (:userName, :productID, :amount)";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        params.put("productID", productID);
        params.put("amount", amount);
        daoCart.nativeQuery(HQL, params);
  
    }
	public Cart checkCartExist(String userName,String productID) {
		String HQL = "From Cart C Where C.account='" + userName +"' And C.product=" + productID;
		Map<String, Object> params = new HashMap<String, Object>();
		Cart cart = daoCart.findSingleWithParams(HQL, params);
	    return cart;
	}
	
	
	public List<Cart> getCartByUserName(String userName) {
		List<Cart> cart = new ArrayList<>();
		String HQL = "From Cart C Where C.account='" + userName + "'";
		cart = daoCart.findAll(HQL);
		return cart;
	       
	}
	
	public List<Product> getProductByPIDAndUserName(List<Cart> listCart) {
		List<Product> product = new ArrayList<>();
		for (Cart c : listCart) {
			String HQL = "From Product P Where P.id_P=:productID";
			Product p = daoProduct.findSingle(Product.class, c.getProduct().getId_P());
			product.add(p);
		}
		return product;
	}
	
	public int getCountCart(String userName) {
		String HQL = "select count(C) from Cart C Where C.account='"+ userName + "'";
		return daoCart.count(HQL);
	}
	public List<Product> getProductCookies(List<Cart> cart) {
		List<Product> product = new ArrayList<>();
		for (Cart c : cart) {
			Product p = daoProduct.findSingle(Product.class, c.getProduct().getId_P());
			product.add(p);
		}
		return product;
	}
	public List<Cart> getCartCookies(String cart){
		List<Cart> Cart = new ArrayList<>();
		if(cart!= null && cart.length()!=0) {
			String[] s = cart.split("/");
			for(String i:s) {
				int check = 0;
				String[] n = i.split(":");
				for( Cart c: Cart) {
					if(c.getProduct().getId_P()== Integer.parseInt(n[0])) {
						c.setAmount(Integer.parseInt(n[1]));
						check = 1;
						break;
					}
				}
				if (check == 0) {
					Product id = new Product(Integer.parseInt(n[0]));
					int quantity = Integer.parseInt(n[1]);
					Cart c = new Cart(quantity,id);
					Cart.add(c);
				}
			}
		}
		return Cart;
	}
	public int checkCartCookies(String cart, String productID){
		int amount = 0;
		if(cart!= null && cart.length()!=0) {
			String[] s = cart.split("/");
			for(String i:s) {
				String[] n = i.split(":");
				if(productID.equals(n[0])) {
					amount = Integer.parseInt(n[1]);
				}
			}
		}
		return amount;
	}
	public String deleteCartCookies(int productID, List<Cart> cart) {
		String cartcookie ="";
		for (Cart c : cart) {
			if(c.getProduct().getId_P() != productID) {
				cartcookie = cartcookie + "/" + Integer.toString(c.getProduct().getId_P()) + ":" +  Integer.toString(c.getAmount());
			}
		}
		if(cartcookie != "")
			cartcookie = cartcookie.substring(1);
		return cartcookie;
    }
	public String editAmountCookies(int productID, List<Cart> cart, int amount) {
		String amountcart ="";
		for (Cart c : cart) {
			if(c.getProduct().getId_P() == productID) {
				amountcart = amountcart + "/" + Integer.toString(c.getProduct().getId_P()) + ":" +  Integer.toString(amount);
			}else {
				amountcart = amountcart + "/" + Integer.toString(c.getProduct().getId_P()) + ":" +  Integer.toString(c.getAmount());
			}
		}
		if(amountcart != "")
			amountcart = amountcart.substring(1);
		return amountcart;
    }
	
}
