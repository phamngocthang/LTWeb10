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
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  response.setContentType("text/html;charset=UTF-8"); 
	  HttpSession session = request.getSession();
	  String productID = (String)request.getParameter("id_P");
	  // get value product
	  ProductService productservice = new ProductService();
	  boolean checkdelete = productservice.DeleteProduct(productID);
	  session.setAttribute("checkdelete", true);
	  if (checkdelete)
		  session.setAttribute("messdelete", true);
	  else
		  session.setAttribute("messdelete", false);
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
