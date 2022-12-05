package controller.admin.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.Product;
import service.ProductService;
import service.ShopDetailService;

/**
 * Servlet implementation class GetProduct
 */
@WebServlet("/getProduct")
public class GetProduct extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  
	  response.setContentType("text/html;charset=UTF-8"); 
	  int productID = Integer.parseInt(request.getParameter("id_P"));
	  // get value product
	  ShopDetailService dp = new ShopDetailService(); 
	  Product productdetail = dp.getProductByID(productID);
	  request.setAttribute("productdetail", productdetail);
	  request.getRequestDispatcher("Admin/UpdateProduct.jsp").forward(request, response);
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
