
  package controller;
  
  import java.io.IOException; import java.util.List;
  
  import javax.servlet.ServletException; 
  import javax.servlet.annotation.WebServlet; 
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest; 
  import javax.servlet.http.HttpServletResponse; 
  import javax.servlet.http.HttpSession;

import entity.Account;
import entity.Product;
import service.ProductService;
import service.ShopDetailService;
  
 /**
	 * Servlet implementation class DetailProductServlet
	 */
@WebServlet(name = "DetailProductServlet", urlPatterns = {"/detail"}) 
public class DetailProductServlet extends HttpServlet {
		protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		  response.setContentType("text/html;charset=UTF-8"); 
		  ShopDetailService dp = new ShopDetailService(); 
		  int id = Integer.parseInt(request.getParameter("id"));
		  String brand = request.getParameter("brand"); 
		  Product detail = dp.getProductByID(id); 
	      // Get 5 Recent Product
	      List<Product> list = dp.getAllProductByBrand(brand, id);
	      System.out.print(brand);
		  HttpSession session = request.getSession();
		  session.setAttribute("listNP", list);
		  session.setAttribute("detail", detail);
		  request.getRequestDispatcher("detail.jsp").forward(request, response);
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
		 