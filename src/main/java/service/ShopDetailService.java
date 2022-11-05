package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoShopDetail;
import entity.Image;
import entity.Product;

public class ShopDetailService {
	DaoShopDetail daoShopDetail = new DaoShopDetail();
	public Product getProductByID(String id) {
		Product product = daoShopDetail.getProductByID(id);
    	return product;
	}

	
	public static void main (String[] args) { 
		ShopDetailService dao = new ShopDetailService(); 

		/*
		for( Product o: list) {
		  System.out.println(o.getId_P());
		}
		*/
	}
}
