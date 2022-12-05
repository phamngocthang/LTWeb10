package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.DaoBill;
import dao.DaoCart;
import dao.DaoProduct;
import entity.Account;
import entity.Bill;
import entity.Billdetail;
import entity.Cart;
import entity.Image;
import entity.Product;

public class BillService {
	DaoBill daoBill = new DaoBill();
	DaoCart daoCart = new DaoCart();
	DaoProduct daoProduct = new DaoProduct();

	public List<Bill> getAllBill() {
		List<Bill> list = new ArrayList<>();
		String HQL = "From Bill";
		list = daoBill.getAllBill(HQL);
		return list;
	}
	
	public List<Object[]> getBillInMonth() {
		List<Object[]> list = new ArrayList<>();
		String HQL = "select MONTH(date), SUM(totalPrice) from bill Group by MONTH(date)";
		
		list = daoBill.getBillInMonth(HQL);
		
		return list;
	}

	public List<Billdetail> getAllBillDetails(Integer idBill) {
		List<Billdetail> list = new ArrayList<>();
		String HQL = "From Billdetail where idBill = :id";
		// create query
		list = daoBill.getAllBillDetail(HQL, idBill);
		return list;
	}

	public List<Object[]> getTopBill() {
		String HQL = "SELECT B.userName, firstName, lastName, email, phonenumber, SUM FROM (SELECT userName, SUM(totalPrice) AS SUM FROM bill GROUP BY userName) \n"
				+ "AS B INNER JOIN customer ON B.userName = customer.userName ORDER BY SUM DESC LIMIT 5;";
		return daoBill.getTopBill(HQL);
	}

	public List<Object[]> getTopProduct() {
		String HQL = "Select P.name_P, P.price, P.color, P.brand, SUM(b.amount)*p.price as Total From billdetail as B inner JOIN "
				+ "product as P ON B.id_P = P.id_P GROUP BY P.id_P ORDER BY Total DESC LIMIT 5;";
		return daoBill.getTopBill(HQL);
	}

	public int getSumBill() {
		String HQL = "select SUM(totalPrice) From Bill";
		return daoBill.getSumBill(HQL);
	}

	public int getCountBill() {
		String HQL = "select count(B) From Bill B";
		return daoProduct.getCountQuery(HQL);
	}

	public void insertBill(String userName, int totalPrice) {
		String HQL = "INSERT INTO Bill(userName, totalPrice, date) Values (:userName, :totalPrice, :date)";
		daoBill.insertBill(HQL, userName, totalPrice);

	}

	public void insertBillDeTail(int idBill, int productID, int amount) {
		String HQL = "INSERT INTO Billdetail(idBill, id_P, amount) Values (:idBill, :id_P, :amount)";
		daoBill.insertBillDeTail(HQL, idBill, productID, amount);

	}

	public int getMaxIDBill() {
		String HQL = "Select max(B.idBill) from Bill B";
		return daoBill.getMaxIDBill(HQL);
	}

	public Bill getBillByID(int idBill) {
		String HQL = "From Bill B where B.idBill = :idBill";
		return daoBill.getBillByID(HQL, idBill);
	}

	public static void main(String[] args) {

		BillService carservice = new BillService();
		List<Object[]> list = carservice.getBillInMonth();
		for (Object[] objects : list) {
			System.out.println(Double.valueOf(objects[0].toString()) + "   " + Double.valueOf(objects[1].toString()));
		}
	}
}
