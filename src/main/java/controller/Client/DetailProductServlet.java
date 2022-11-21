
  package controller.Client;
  
  import java.io.IOException; 
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
import service.ProductService;
import service.ReviewService;
import service.ShopDetailService;
  
 /**
	 * Servlet implementation class DetailProductServlet
	 */
@WebServlet("/detail")
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
	      
	      // Get FeedBack
	      ReviewService reviewService = new ReviewService();
	      List<Feedback> fb = reviewService.showReview(id);
	      //int countFeedBack = reviewService.countFBByPID(id);
	      System.out.print(brand);
		  
		  request.setAttribute("listNP", list);
		  request.setAttribute("detail", detail);
		  request.setAttribute("feedback", fb);
		  //session.setAttribute("countfeedback", countFeedBack);
		  request.getRequestDispatcher("Client/detail.jsp").forward(request, response);
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
		 