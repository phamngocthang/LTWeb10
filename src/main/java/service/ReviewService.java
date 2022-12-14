package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dao.DaoBill;
import dao.DaoReview;

import entity.Account;
import entity.Cart;
import entity.Feedback;
import entity.Image;
import entity.Product;

public class ReviewService {
	DaoBill daoBill = new DaoBill();
	DaoReview daoReview = new DaoReview();
	private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
	
	public void insertReview(String productID, String userName, String content) {
		String HQL = "INSERT INTO Feedback(id_P, userName, rate, content, date) Values (:id_P, :userName, :rate, :content, :date)";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id_P", productID);
        params.put("userName", userName);
        params.put("rate", 1);
        params.put("content", content);
        params.put("date", getCurrentDate());
        daoReview.nativeQuery(HQL, params);
    }
	
	
	public List<Feedback> showReview(int id) {
       String HQL = "From Feedback F Where F.product=" + id;
       return daoReview.findAll(HQL);
    }

	
}
