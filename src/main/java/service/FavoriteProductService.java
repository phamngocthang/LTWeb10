package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import context.HibernateUtil;
import entity.Cart;
import entity.Favoriteproduct;
import entity.Product;
import dao.DaoFavoriteProduct;


public class FavoriteProductService {
	
	DaoFavoriteProduct daoFacvoriteProduct = new DaoFavoriteProduct();
	
	
	public List<Favoriteproduct> getFavoriteProductByUserName(String userName) {
		List<Favoriteproduct> fproduct = new ArrayList<>();
		String HQL = "From Favoriteproduct F Where F.account='" + userName + "'";
		fproduct = daoFacvoriteProduct.getFavoriteProductByUserName(HQL);
		return fproduct;
	       
	}
	
	public List<Product> getProductByPIDAndUserName(String userName) {
		List<Product> product = new ArrayList<>();
		FavoriteProductService fproductservice = new FavoriteProductService();
		List<Favoriteproduct> fproduct = fproductservice.getFavoriteProductByUserName(userName);
		for (Favoriteproduct f : fproduct) {
			String HQL = "From Product P Where P.id_P=:productID";
			Product p = daoFacvoriteProduct.getProductByID(HQL, f.getProduct().getId_P());
			product.add(p);
		}
		return product;
	}
	public Favoriteproduct checkFavorityProductExist(String userName,String productID) {
		String HQL = "From Favoriteproduct F Where F.account='" + userName +"' And F.product=" + productID;
		Favoriteproduct fproduct = daoFacvoriteProduct.getFavoriteProduct(HQL, userName, productID);
		return fproduct;      
	}
	public void insertFavoriteProduct(String userName, String productID) {
        String HQL = "INSERT INTO Favoriteproduct(userName, id_P) Values (:userName, :productID)";
        daoFacvoriteProduct.insertFavoriteProduct(HQL, userName, productID);
    }
	public void deleteCart(int productID, String userName) {
        String HQL = "Delete From Favoriteproduct F Where F.product=" + Integer.toString(productID) + " and F.account='" + userName+ "'";;
        daoFacvoriteProduct.deleteCart(HQL);
    }
	public int getCountFavoriteProduct(String userName) {
		String HQL = "";
		HQL = "select count(F) from Favoriteproduct F Where F.account='"+ userName + "'";
		return daoFacvoriteProduct.getCountFavoriteProduct(HQL);
	}
}
