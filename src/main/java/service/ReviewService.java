package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	public void insertReview(String productID, String userName, String content) {
        String HQL = "INSERT INTO Feedback(id_P, userName, rate, content, date) Values (:id_P, :userName, :rate, :content, :date)";
       daoReview.insertReview(HQL, productID, userName, content);
  
    }
	
	public List<Feedback> showReview(int id) {
       String HQL = "From Feedback F Where F.product=" + id;
       List<Feedback> fb = daoReview.showReview(HQL);
       return fb;
    }
	
	public int countFBByPID(int productID) {
       String HQL = "Select count(F.id_FB) from Feedback F where F.product="+productID;
       return daoBill.getMaxIDBill(HQL);
  
    }
	
	public static void main(String[] args) {

		ReviewService carservice = new ReviewService();
		System.out.println(carservice.countFBByPID(1));
	}
}
