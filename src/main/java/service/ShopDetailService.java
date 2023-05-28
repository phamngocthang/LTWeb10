package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoShopDetail;
import entity.Product;

public class ShopDetailService {
	DaoShopDetail daoShopDetail = new DaoShopDetail();
	public Product getProductByID(int id) {
		Product product = daoShopDetail.getProductByID(id);
    	return product;
	}
	
	public List<Product> getAllProductByBrand(String brand, int id) {
		List <Product> pList = daoShopDetail.getAllProductByBrand(brand, id);
		return pList;
	}
}
