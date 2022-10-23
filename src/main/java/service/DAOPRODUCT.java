package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

import context.DBContext;
import entity.Image;
import entity.Product;
public class DAOPRODUCT {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    //ConnectionPool pool = ConnectionPool.getInstance();
    
	public List<Product> getRecentProduct() {
		String query = "select Product.id_P, Product.name_P, Product.price, Image.path_middle from Product, Image WHERE Product.id_P = Image.id_P\r\n"
				+ "ORDER BY id_P DESC LIMIT 4;";
    	List<Product> list = new ArrayList<>();
    	try {
    		conn = new DBContext().getConnection();
    		
    	    //Connection conn = pool.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						new Image(rs.getString(4))));
			}
			System.out.println(list);
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
		}
    	return list;
	}
	public List<Product> getProductAjax(String price1, String price2, String price3) {
		System.out.println(price1 + " " + price2 + " " + price3);
		String fillTotal = "";
		
		// Phân tích kết quả từ request
		String fillPrice = "(";
		if(price1.equals("true")) {
			fillPrice += "Product.price < 300000 ";
		}

		if(price2.equals("true")) {
			if(price1.equals("true")) {
				fillPrice += "OR ";
			}
			fillPrice += "(Product.price >= 300000 and Product.price < 800000) ";
		}
		if(price3.equals("true"))
		{
			if(price1.equals("true") || price2.equals("true")) {
				fillPrice += "OR ";
			}
			fillPrice += "Product.price >= 800000 ";
		}
		fillPrice += ")";
		if(fillPrice != "()") // Co dieu kien Price
		{
			fillTotal += fillPrice;
		}
		else
		{
			
		}
		  
		String query = "Select DISTINCT Product.id_P, Product.name_P, Product.price, Image.path_middle from Product, Image WHERE\r\n"
				+ "	Product.id_P = Image.id_P AND " + fillTotal +" ";
		System.out.println(query);
    	List<Product> list = new ArrayList<>();
    	try {
    		conn = new DBContext().getConnection();
    		
    	    //Connection conn = pool.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						new Image(rs.getString(4))));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return list;
	}
	
	public int getCountAccount() {
        String query = "select count(*) from Product";
        try {
        	conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
			conn.close();
        } catch (Exception e) {
        }
        finally {
    		
    	}
        return -1;
    }
	
	public List<Product> pagingAccount(int index, int show)
    {
    	List<Product> list = new ArrayList<>();
    	String query = "Select Product.id_P, Product.name_P, Product.price, Image.path_middle from Product INNER JOIN Image\r\n"
    			+ "ON Product.id_P = Image.id_P Order By id_P ASC LIMIT ? OFFSET ?;";
    	try {
    		conn = new DBContext().getConnection();
    		
    		ps = conn.prepareStatement(query);
    		ps.setInt(1, show);
    		ps.setInt(2, (index-1)*show);
    		rs = ps.executeQuery();
    		while(rs.next()) {
    			list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						new Image(rs.getString(4))));
    		}
    		rs.close();
    		ps.close();
    		conn.close();
    	}
    	catch (Exception e){
    	}
    	finally {
    		
    	}
    	return list;
    	
    }
	public List<Product> getAllProduct() {
		String query = "select Product.id_P, Product.name_P, Product.price, Image.path_middle from Product, Image WHERE Product.id_P = Image.id_P;";
    	List<Product> list = new ArrayList<>();
    	try {
    		conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
						new Image(rs.getString(4))));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
		}
    	finally {
    		
    	}
    	return list;
	}
}
