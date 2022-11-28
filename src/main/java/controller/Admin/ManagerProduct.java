package controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Product;
import service.ProductService;


@WebServlet("/ManagerProduct")
public class ManagerProduct extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  response.setContentType("text/html;charset=UTF-8"); 
	  ProductService productservice = new ProductService();
	  List<Product> listProduct = productservice.getAllProduct();
	  request.setAttribute("listProduct", listProduct);
	  request.getRequestDispatcher("Admin/ManagerProduct.jsp").forward(request, response);
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
