package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DaoBill;
import dao.DaoCart;
import dao.DaoProduct;
import entity.Image;
import entity.Product;

public class ProductService {
	DaoProduct daoProduct = new DaoProduct();
	DaoCart daoCart = new DaoCart();
	public List<Product> getRecentProduct() {
    	return daoProduct.getRecentProduct();
	}
	
	public List<Product> getTopProduct() {
		return daoProduct.getTopProduct();
	}
	
	public List<Object[]> getProductByCate() {
		// group by how many product in bill
		String HQL = "SELECT Product.id_SubCate, count(*) FROM Product , Billdetail WHERE Product.id_P = Billdetail.id_P GROUP BY Product.id_SubCate ORDER BY id_SubCate ASC";
		return daoProduct.getProductByCate(HQL);
	}
	
	public List<Product> getAllProduct()
	{
		List<Product> list = new ArrayList<>();
		String HQL = "From Product";
		list = daoProduct.findAll(HQL);
		return list;
	}
	
	public List<Product> pagingAccount(String subcateID, int index, int show)
	{
		List<Product> list = new ArrayList<>();
		String HQL = "";
		if(subcateID.equals("-1")) {
    		HQL = "From Product P Order By P.id_P ASC";
    	}
    	else {
    		HQL = "From Product P Where P.subcategory=" + subcateID +" Order By P.id_P ASC";
    	}
		list = daoProduct.pagingAccount(HQL, (index-1)*show, show);
		return list;
	}
	
	public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String HQL = "From Product P Where P.name_P like '%" + txtSearch + "%'";
        list = daoProduct.findAll(HQL);
        return list;
    }
	
	public int getCountAccount(String subCateID) {
		String HQL = "";
		if(subCateID.equals("-1")) {
			HQL = "select count(p) from Product p";
		}
		else {
			HQL = "select count(p) from Product p Where p.subcategory=" + subCateID;
		}
		return daoProduct.count(HQL);
	}
	public int getCountProduct() {
		String HQL = "select count(id_P) from Product";	
		return daoProduct.getCountProduct(HQL);
	}
	public int getCountQuery(String query) {
		String HQL = "select count(P)" + query;
		return daoProduct.getCountQuery(HQL);
	}

	
	public List<Product> getProductAjax(String price1, String price2, String price3, String color1, String color2, String color3, 
			String subcateID, String index, int showP, String[] queryCount) {
		String fillTotal = "";

		// Fill Price
		String fillPrice = "";
		if(price1.equals("true")) {
			fillPrice += "P.price < 300000 ";
		}

		if(price2.equals("true")) {
			if(price1.equals("true")) {
				fillPrice += "OR ";
			}
			fillPrice += "(P.price >= 300000 and P.price < 800000) ";
		}
		if(price3.equals("true"))
		{
			if(price1.equals("true") || price2.equals("true")) {
				fillPrice += "OR ";
			}
			fillPrice += "P.price >= 800000 ";
		}
		// Fill Color
		String fillColor = "";
		if(color1.equals("true")) {
			fillColor += "P.color='Black' ";
		}

		if(color2.equals("true")) {
			if(color1.equals("true")) {
				fillColor += "Or ";
			}
			fillColor += "P.color='White' ";
		}
		if(color3.equals("true"))
		{
			if(color1.equals("true") || color2.equals("true")) {
				fillColor += "Or ";
			}
			fillColor += "P.color='Blue' ";
		}
		// Fill Total
		if(!fillPrice.equals("")) { // Khac rong
			fillTotal += "((" + fillPrice + ") ";
			if(!fillColor.equals("")) {
				fillTotal += "And (" + fillColor + ") ";
			}
			fillTotal += ") ";
		}
		else {
			if(!fillColor.equals("")) {
				fillTotal += "(" + fillColor + ") ";
			}
		}
		
		// Fill Catagory
		String fillCategory;
		String HQL = "";
		if(subcateID.equals("-1")) {
			//fillCategory = "";
			if(fillTotal == "") {
				HQL = "From Product P Order By P.id_P ASC";
			}
			else {
				HQL = "From Product P Where " + fillTotal + " Order By P.id_P ASC";
			}
		}
		else {
			if(fillTotal == "")
			{
				HQL = "From Product P Where (P.subcategory=" + subcateID + ") Order By P.id_P ASC";
			}
			else {
				HQL = "From Product P Where (P.subcategory=" + subcateID + ") And " + fillTotal +" Order By P.id_P ASC";
			}
			//fillCategory = "id_subCate=? AND";
			
		}
		//System.out.println("\n HQL Nè:"+ HQL + "\n");
		//System.out.println((Integer.parseInt(index)-1)*showP).toString() + " " + showP);
		List<Product> list = new ArrayList<>();
		list = daoProduct.getProductAjax(HQL, ((Integer.parseInt(index)-1)*showP), showP);
		queryCount[0] = HQL.substring(0, HQL.toString().indexOf("Order"));
		//System.out.println(queryCount[0]);
		
		return list;
	}
	public void insertImage(int idP, String image_mid, String image_left, String image_right) {
		String HQL = "INSERT INTO Image(id_P, path_middle, path_left, path_right) Values (:id_P, :image_mid, :image_left, :image_right)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id_P", idP);
		params.put("image_mid", image_mid);
		params.put("image_left", image_left);
		params.put("image_right", image_right);
		daoProduct.nativeQuery(HQL, params);
	}
	
	public boolean InsertProduct(Product product) {
		daoProduct.create(product);
		return true;
	}
	
	public int getMaxIDProduct() {
		String HQL = "Select max(P.id_P) from Product P";
		DaoBill daobill = new DaoBill();
		return daobill.getMaxIDBill(HQL);
	}
	
	
	public boolean UpdateProduct(Product product, Image img) {
		boolean check = daoProduct.updateProduct(product, img);
		if (check)
			return true;
		return false;
	}
	
	public boolean UpdateStatus(int productID) {
	   ProductService pc = new ProductService();
	   String HQL = "Update Product p set p.status=1 Where p.id_P="+ productID;
	   Map<String, Object> params = new HashMap<String, Object>();
	   daoProduct.CreateQueryWithParams(HQL, params);
	   return true;
	  
	}
	public boolean DeleteProduct(String id_P) {
		ProductService pc = new ProductService();
		String HQL = "Update Product P Set P.status = 0 Where P.id_P =" + id_P;
		Map<String, Object> params = new HashMap<String, Object>();
		daoProduct.CreateQueryWithParams(HQL, params);
	    return true;
	}
	public Product getProductByID(int productID) {
		Product product = daoProduct.findSingle(Product.class, productID);
		return product;
	}
}
