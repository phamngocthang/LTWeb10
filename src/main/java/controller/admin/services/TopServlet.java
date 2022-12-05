
  package controller.admin.services;
  
  import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
  
  import javax.servlet.ServletException; 
  import javax.servlet.annotation.WebServlet; 
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest; 
  import javax.servlet.http.HttpServletResponse; 
  import javax.servlet.http.HttpSession;

import entity.Account;
import entity.Customer;
import entity.Feedback;
import entity.Product;
import service.AccountService;
import service.BillService;
import service.ProductService;
import service.ReviewService;
import service.ShopDetailService;
  
 /**
	 * Servlet implementation class DetailProductServlet
	 */
@WebServlet(name = "TopServlet", urlPatterns = {"/TopServlet"}) 
public class TopServlet extends HttpServlet {
		protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		  response.setContentType("text/html;charset=UTF-8"); 
		  BillService billService = new BillService();
		  // Top Customer
		  List<Object[]> listTop = billService.getTopBill();
		  List<Customer> listTopCustomer = new ArrayList<>();
		  List<Integer> listTotal = new ArrayList<>();
		  for (Object[] objects : listTop) {
			  Customer cust = new Customer(objects[0].toString(), objects[3].toString(), objects[1].toString(), objects[2].toString(), objects[4].toString());
			  listTotal.add((int)((double)objects[5]));
			  listTopCustomer.add(cust);
		  }
		  // Top Product
		  List<Object[]> listTop2 = billService.getTopProduct();
		  List<Product> listTopProduct = new ArrayList<>();
		  List<Integer> listTotalProduct = new ArrayList<>();
		  for (Object[] objects : listTop2) {
			  Product cust = new Product(objects[3].toString(), objects[2].toString(), objects[0].toString(), Double.valueOf(objects[1].toString()));
			  listTotalProduct.add((int)((double)objects[4]));
			  listTopProduct.add(cust);
		  }
		  
		  request.setAttribute("listTopCustomer", listTopCustomer);
		  request.setAttribute("listTopProduct", listTopProduct);
		  request.setAttribute("listTotal", listTotal);
		  request.setAttribute("listTotalProduct", listTotalProduct);
		  request.getRequestDispatcher("Admin/Top.jsp").forward(request, response);
		}
		  
		  @Override protected void doGet(HttpServletRequest request,
		  HttpServletResponse response) throws ServletException, IOException {
		  processRequest(request, response); }
		  
		  
		  @Override protected void doPost(HttpServletRequest request,
		  HttpServletResponse response) throws ServletException, IOException {
		  processRequest(request, response); }
		  
		  @Override public String getServletInfo() { return "Short description"; }
		  //</editor-fold>
		  
		}
		 