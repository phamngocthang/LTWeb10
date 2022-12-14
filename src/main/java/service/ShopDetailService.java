package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DaoShopDetail;
import entity.Product;

public class ShopDetailService {
	DaoShopDetail daoShopDetail = new DaoShopDetail();
	public Product getProductByID(int id) {
		Product product = daoShopDetail.findSingle(Product.class, id);
    	return product;
	}
	
	public List<Product> getAllProductByBrand(String brand, int id) {
		String HQL = "From Product P Where P.brand = :brand and P.id_P != " + id;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("brand", brand);
		return daoShopDetail.findWithParams(HQL, params);
	}
}
