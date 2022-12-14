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
import service.AccountService;
import service.CustomerService;

@WebServlet("/InsertAccount")
public class InsertAccount extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  response.setContentType("text/html;charset=UTF-8"); 
	  HttpSession session = request.getSession();
	  int isAdmin=0;
	  String username = request.getParameter("username");
      String password = request.getParameter("password");
      String isAdmin_ = request.getParameter("isAdmin");
      
      if (isAdmin_!=null)
    	  isAdmin=1;
      else 
    	  isAdmin=0;
	 
      session.setAttribute("checkinsert", true);
      AccountService svacc = new AccountService();
      int a = svacc.Signup(username, password, password, isAdmin);
      CustomerService svcus = new CustomerService();
      svcus.InsertCustomer(username);
      
      if(a>0)
    	  session.setAttribute("messinsert", true);
      else
    	  session.setAttribute("messinsert", false);
      request.getRequestDispatcher("AccountManage").forward(request, response);
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
