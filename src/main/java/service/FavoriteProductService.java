package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import context.HibernateUtil;
import entity.Favoriteproduct;
import entity.Product;
import dao.DaoFavoriteProduct;
import dao.DaoProduct;


public class FavoriteProductService {
	
	DaoFavoriteProduct daoFacvoriteProduct = new DaoFavoriteProduct();
	DaoProduct daoProduct = new DaoProduct();
	
	public List<Favoriteproduct> getFavoriteProductByUserName(String userName) {
		List<Favoriteproduct> fproduct = new ArrayList<>();
		String HQL = "From Favoriteproduct F Where F.account='" + userName + "'";
		Map<String, Object> params = new HashMap<String, Object>();
		fproduct = daoFacvoriteProduct.findWithParams(HQL, params);
		return fproduct;
	       
	}
	
	public List<Product> getProductByPIDAndUserName(List<Favoriteproduct> fproduct) {
		List<Product> product = new ArrayList<>();
		for (Favoriteproduct f : fproduct) {
			Product p = daoProduct.findSingle(Product.class, f.getProduct().getId_P());
			product.add(p);
		}
		return product;
	}
	
	public Favoriteproduct checkFavorityProductExist(String userName,String productID) {
		String HQL = "From Favoriteproduct F Where F.account='" + userName +"' And F.product=" + productID;
		Map<String, Object> params = new HashMap<String, Object>();
		Favoriteproduct fproduct = daoFacvoriteProduct.findSingleWithParams(HQL, params);
		return fproduct;
	}
	public void insertFavoriteProduct(String userName, String productID) {
        String HQL = "INSERT INTO Favoriteproduct(userName, id_P) Values (:userName, :productID)";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        params.put("productID", productID);
        daoFacvoriteProduct.nativeQuery(HQL, params);
    }
	public void deleteCart(int productID, String userName) {
        String HQL = "Delete From Favoriteproduct F Where F.product=" + Integer.toString(productID) + " and F.account='" + userName+ "'";
        Map<String, Object> params = new HashMap<String, Object>();
        daoFacvoriteProduct.CreateQueryWithParams(HQL, params);
    }
	public int getCountFavoriteProduct(String userName) {
		String HQL = "select count(F) from Favoriteproduct F Where F.account='"+ userName + "'";
		return daoFacvoriteProduct.count(HQL);
	}
}
