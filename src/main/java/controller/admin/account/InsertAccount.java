package controller.admin.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAccount;

@WebServlet("/InsertAccount")
public class InsertAccount extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  response.setContentType("text/html;charset=UTF-8"); 
	  
	  int isAdmin=0;
	  String username = request.getParameter("username");
      String password = request.getParameter("password");
      String isAdmin_ = request.getParameter("isAdmin");
      
      if (isAdmin_!=null)
    	  isAdmin=0;
      else 
    	  isAdmin=1;
	 
      DaoAccount dao = new DaoAccount();
      int a= dao.Signup(username, password, password, isAdmin);
      if(a>0)
    	  request.getRequestDispatcher("/AccountManage?err=1").forward(request, response);
      else
    	  request.getRequestDispatcher("/AccountManage?err=2").forward(request, response);
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
