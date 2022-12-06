package controller.admin.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Category;
import entity.Image;
import entity.Product;
import entity.Subcategory;
import service.ProductService;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet(name = "UpdateStatus", urlPatterns = {"/updateStatus"}) 
public class UpdateStatus extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  response.setContentType("text/html;charset=UTF-8");
	  request.setCharacterEncoding("UTF-8");
	  HttpSession session = request.getSession();
	  int ProductID = Integer.parseInt(request.getParameter("id_P"));
	  
	  ProductService productservice = new ProductService();
	  boolean checkupdate = productservice.UpdateStatus(ProductID);
	  session.setAttribute("checkupdate", true);
	  if (checkupdate){
		  session.setAttribute("messupdate", true);
	  }
	  else{
		  session.setAttribute("messupdate", false);
	  }
	  request.getRequestDispatcher("ManagerProduct").forward(request, response);
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
