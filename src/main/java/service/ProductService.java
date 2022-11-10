package service;

import java.util.ArrayList;
import java.util.List;

import dao.DaoProduct;
import entity.Category;
import entity.Image;
import entity.Product;

public class ProductService {
	DaoProduct daoProduct = new DaoProduct();
	public List<Product> getRecentProduct() {
    	List<Product> list = new ArrayList<>();
    	String HQL = "From Product P ORDER BY P.id_P DESC";
    	list = daoProduct.getRecentProduct(HQL, 12);
    	return list;
	}
	
	public List<Product> getAllProduct()
	{
		List<Product> list = new ArrayList<>();
		String HQL = "From Product";
		list = daoProduct.getAllProduct(HQL);
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
		//System.out.println(HQL);
		list = daoProduct.pagingAccount(HQL, (index-1)*show, show);
		return list;
	}
	
	public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String HQL = "From Product P Where P.name_P like '%" + txtSearch + "%'";
        //System.out.println("\n"+ HQL +"\n");
        list = daoProduct.searchByName(HQL, '%' + txtSearch + '%');
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
	
	public static void main (String[] args) { 
		ProductService dao = new ProductService(); 
		List<Product> list = dao.getProductAjax("true", "false", "false", "false", "false", "false", "3", "1", 3, args);
		System.out.println(list);
		/*
		for( Product o: list) {
		  System.out.println(o.getId_P());
		}
		*/
	}
}
