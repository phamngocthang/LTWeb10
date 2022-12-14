package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dao.DaoBill;
import dao.DaoBillDetail;
import dao.DaoCart;
import dao.DaoProduct;
import entity.Bill;
import entity.Billdetail;
import entity.Account;

public class BillService {
	DaoBill daoBill = new DaoBill();
	DaoCart daoCart = new DaoCart();
	DaoProduct daoProduct = new DaoProduct();
	DaoBillDetail daoBillDetail = new DaoBillDetail();
	
	private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
	
	public List<Bill> getBillByAccount(Account account) {
		String HQL = "From Bill B where B.account = :account";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("account", account);
		return daoBill.findWithParams(HQL, params);
	}
	
	public List<Bill> getAllBill() {
		return daoBill.findAll("");
	}
	
	public List<Object[]> getBillInMonth() {
		List<Object[]> list = new ArrayList<>();
		String HQL = "select MONTH(date), SUM(totalPrice) from Bill Group by MONTH(date)";
		list = daoBill.getBillInMonth(HQL);
		return list;
	}

	public List<Billdetail> getAllBillDetails(Integer idBill) {
		
		String HQL = "From Billdetail where idBill = " + idBill;
		// create query
		return daoBillDetail.findAll(HQL);
	}

	public List<Object[]> getTopBill() {
		String HQL = "SELECT B.userName, firstName, lastName, email, phonenumber, SUM FROM (SELECT userName, SUM(totalPrice) AS SUM FROM Bill GROUP BY userName)\r\n"
				+ "AS B INNER JOIN Customer ON B.userName = Customer.userName ORDER BY SUM DESC LIMIT 5;";
		return daoBill.getTopBill(HQL);
	}

	public List<Object[]> getTopProduct() {
		String HQL = "Select Product.name_P, Product.price, Product.color, Product.brand, SUM(Billdetail.amount)*Product.price as Total From Billdetail inner JOIN \r\n"
				+ "Product ON Billdetail.id_P = Product.id_P GROUP BY Product.id_P ORDER BY Total DESC LIMIT 5;";
		return daoBill.getTopBill(HQL);
	}

	public int getSumBill() {
		String HQL = "select SUM(totalPrice) From Bill";
		return daoBill.getSumBill(HQL);
	}

	public int getCountBill() {
		String HQL = "select count(B) From Bill B";
		return daoProduct.count(HQL);
	}

	public void insertBill(String userName, int totalPrice) {
		String HQL = "INSERT INTO Bill(userName, totalPrice, date) Values (:userName, :totalPrice, :date)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("totalPrice", totalPrice);
		params.put("date", getCurrentDate());
		daoBill.nativeQuery(HQL, params);
	}

	public void insertBillDeTail(int idBill, int productID, int amount) {
		String HQL = "INSERT INTO Billdetail(idBill, id_P, amount) Values (:idBill, :id_P, :amount)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idBill", idBill);
		params.put("id_P", productID);
		params.put("amount", amount);
		daoBillDetail.nativeQuery(HQL, params);
	}

	public int getMaxIDBill() {
		String HQL = "Select max(B.idBill) from Bill B";
		return daoBill.getMaxIDBill(HQL);
	}

	public Bill getBillByID(int idBill) {
		String HQL = "From Bill B where B.idBill = :idBill";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("idBill", idBill);
		return daoBill.findSingleWithParams(HQL, params);
	}
}
