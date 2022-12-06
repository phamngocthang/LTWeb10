package controller.admin.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


@WebServlet("/InsertProduct")
public class InsertProduct extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  response.setContentType("text/html;charset=UTF-8"); 
	  request.setCharacterEncoding("UTF-8");
	  HttpSession session = request.getSession();
	  // get value product
	  String name = (String)request.getParameter("product-name");
	  int category = Integer.parseInt(request.getParameter("product-category"));
	  String brand = (String)request.getParameter("product-brand");
	  Double price = Double.parseDouble(request.getParameter("product-price"));
	  String color = (String)request.getParameter("product-color");
	  String imgleft = (String)request.getParameter("product-img-left");
	  String imgcenter = (String)request.getParameter("product-img-center");
	  String imgright = (String)request.getParameter("product-img-right");
	  String size = (String)request.getParameter("product-size");
	  String desc = (String)request.getParameter("product-desc");
	  int status = 1;
	  // Insert new product
	  ProductService productservice = new ProductService();
	  int newid_P = productservice.getCountProduct();
	  Subcategory newsubcategory = new Subcategory(1);
	  Image newimage = new Image(newid_P+1,imgleft, imgcenter, imgright);
	  Category newcategory = new Category(category);
	  Product newproduct = new Product(name, brand, newcategory, color, desc,price, size, newsubcategory, newimage, status);
	  boolean checkinsert= productservice.InsertProduct(newproduct,newimage);
	  if (checkinsert)
		  session.setAttribute("checkinsert", checkinsert);
	  else
		  session.setAttribute("checkinsert", false);
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
