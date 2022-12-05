package controller.admin.services;
  
  import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
  
  import javax.servlet.ServletException; 
  import javax.servlet.annotation.WebServlet; 
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest; 
  import javax.servlet.http.HttpServletResponse; 
  import javax.servlet.http.HttpSession;

import entity.Account;
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
@WebServlet(name = "DetailProductServlet", urlPatterns = {"/DashBoard"}) 
public class DashBoardServlet extends HttpServlet {
		protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		  response.setContentType("text/html;charset=UTF-8"); 
		  AccountService accService = new AccountService();
		  ProductService productService = new ProductService();
		  BillService billService = new BillService();
		  int amountCustomer = accService.getCountQuery();
		  int amountProduct = productService.getCountAccount("-1");
		  int sumBill = billService.getSumBill();
		  int countBill = billService.getCountBill();
		  List<Object[]> list = billService.getBillInMonth();
		  List<Double> listBillInMon = new ArrayList<>();
		  for (int i = 1; i <= 12; i++) {
			  int check = 0;
			  for (Object[] objects : list) {
				  if(Double.valueOf(objects[0].toString()) == i) {
					  listBillInMon.add(Double.valueOf(objects[1].toString()));
					  check = 1;
					  break;
				  }
			  }
			  if(check == 0)
				  listBillInMon.add(0.0);
		  }
		  
		  List<Object[]> listCate = productService.getProductByCate();
		  int total = 0;
		  List<Integer> listSL = new ArrayList<>();
		  for (int i = 1; i <= 8; i++) {
			  int check = 0;
			  for (Object[] objects : listCate) {
				  if(Integer.parseInt(objects[0].toString()) == i) {
					  listSL.add(Integer.parseInt(objects[1].toString()));
					  total += Integer.parseInt(objects[1].toString());
					  check = 1;
					  break;
				  }
			  }
			  if(check == 0)
				  listSL.add(0);
		  }
		  
		  request.setAttribute("amountCustomer", amountCustomer);
		  request.setAttribute("amountProduct", amountProduct);
		  request.setAttribute("sumBill", sumBill);
		  request.setAttribute("countBill", countBill);
		  request.setAttribute("listBillInMon", listBillInMon);
		  request.setAttribute("listSL", listSL);
		  request.setAttribute("total", total);
		  request.getRequestDispatcher("Admin/DashboardHome.jsp").forward(request, response);
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
		 