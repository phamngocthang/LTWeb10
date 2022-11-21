
  package controller.Admin;
  
  import java.io.IOException; import java.util.List;
  
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
		  request.setAttribute("amountCustomer", amountCustomer);
		  request.setAttribute("amountProduct", amountProduct);
		  request.setAttribute("sumBill", sumBill);
		  request.setAttribute("countBill", countBill);
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
		 