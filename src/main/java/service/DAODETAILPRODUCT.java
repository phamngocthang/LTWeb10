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

public class DAODETAILPRODUCT {

	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	public Product getProductByID(String id) {
		String query = "select Product.id_P,"
						+ "Product.name_P,"
						+ "Product.price,"
						+ "Product.color,"
						+ "Product.size,"
						+ "Product.amount,"
						+ "Product.description,"
						+ "Product.detail_desc,"
						+ "Product.infor,"
						+ "Image.path_middle,"
						+ "Image.path_left,"
						+ "Image.path_right from Product, Image WHERE Product.id_P = Image.id_P and Product.id_P = ?;";
    	Product detailproduct = new Product();
    	try {
    		conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				detailproduct = new Product (rs.getInt(1),
						rs.getString (2),
						rs.getDouble (3),
						rs.getString (4),
						rs.getString (6),
						rs.getInt(6),
						rs.getString (7),
						rs.getString (8),
						rs.getString(9),
						new Image(rs.getString(10),rs.getString(11),rs.getString(12)) 
						);
			}
			System.out.print(detailproduct);
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	return detailproduct ;
	}
}
