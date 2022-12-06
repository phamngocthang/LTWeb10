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

import entity.Product;
import service.ProductService;


@WebServlet("/ManagerProduct")
public class ManagerProduct extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  HttpSession session = request.getSession();
	  response.setContentType("text/html;charset=UTF-8"); 
	  ProductService productservice = new ProductService();
	  List<Product> listProduct = productservice.getAllProduct();
	  boolean statusmanage = false;
	  //check thêm sản phẩm
	  if (session.getAttribute("checkinsert") != null)
	  {
		  boolean checkinsert = (boolean)session.getAttribute("checkinsert");
		  session.setAttribute("checkinsert", false);
		  request.setAttribute("checkinsert", checkinsert);
		  request.setAttribute("statusmanage", true);
		 
	  }
	  else 
		  request.setAttribute("checkinsert", false);
	  // check xóa sản phẩm
	  if (session.getAttribute("checkdelete") != null && session.getAttribute("messdelete") != null)
	  {
		  boolean checkdelete = (boolean)session.getAttribute("checkdelete");
		  boolean messdelete = (boolean)session.getAttribute("messdelete");
		  session.setAttribute("checkdelete", false);
		  request.setAttribute("checkdelete", checkdelete);
		  request.setAttribute("messdelete", messdelete);
		  request.setAttribute("statusmanage", true);
		  
	  }
	  else 
		  request.setAttribute("checkdelete", false);
	  // check hoàn tác sản phẩm
	  if (session.getAttribute("checkupdate") != null && session.getAttribute("messupdate") != null)
	  {
		  boolean checkupdate = (boolean)session.getAttribute("checkupdate");
		  boolean messupdate = (boolean)session.getAttribute("messupdate");
		  session.setAttribute("checkupdate", false);
		  request.setAttribute("checkupdate", checkupdate);
		  request.setAttribute("messupdate", messupdate);
		  request.setAttribute("statusmanage", true);

	  }
	  else 
		  request.setAttribute("checkupdate", false);
	  // check cập nhật sản phẩm
	  if (session.getAttribute("checkupdateproduct") != null && session.getAttribute("messupdate") != null)
	  {
		  boolean checkupdateproduct = (boolean)session.getAttribute("checkupdateproduct");
		  boolean messupdateproduct = (boolean)session.getAttribute("messupdateproduct");
		  session.setAttribute("checkupdateproduct", false);
		  request.setAttribute("checkupdateproduct", checkupdateproduct);
		  request.setAttribute("messupdateproduct", messupdateproduct);
		  request.setAttribute("statusmanage", true);

	  }
	  else 
		  request.setAttribute("checkupdateproduct", false);
	  if(session.getAttribute("checkinsert") != null || session.getAttribute("checkdelete") != null
			  || session.getAttribute("checkupdate") != null || session.getAttribute("checkupdateproduct") != null) {
		  request.setAttribute("statusmanage", true);
	  }
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
