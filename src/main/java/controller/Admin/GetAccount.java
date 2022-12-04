package controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import entity.Account;
import service.AccountService;

/**
 * Servlet implementation class GetProduct
 */
@WebServlet("/getAccount")
public class GetAccount extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  
	  response.setContentType("text/html;charset=UTF-8"); 
	  String username = request.getParameter("username");
	  // get value product
	  AccountService dp = new AccountService(); 
	  Account accountdetail = dp.getAccountByUsername(username);
	  request.setAttribute("accountdetail", accountdetail);
	  request.getRequestDispatcher("Admin/UpdateAccount.jsp").forward(request, response);
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
