package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Account;
import entity.Product;

public class DAOACCOUNT {
	Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	public Account Login(String user, String pass)
	{
		String query = "SELECT *from ACCOUNT WHERE userName= ? AND `passWord` = ?";
		Account acc = null; //
		try {
    		conn = new DBContext().getConnection();
			
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				// return new Account(rs.getString(1), rs.getString(2), rs.getInt(3));
				acc = new Account(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
			rs.close();
			ps.close();
			conn.close();
			return acc; //
		} catch (Exception e) {
			
		}
		finally {
    	}
		return null;
	}
}
