package controller.admin.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAccount;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/updateAccount")
public class UpdateAccount extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  response.setContentType("text/html;charset=UTF-8");
	  HttpSession session = request.getSession();
	  String user_name=request.getParameter("initial_username");
	  String old_password= request.getParameter("initial_password");
	  String new_password= request.getParameter("new_password");
	  String re_password= request.getParameter("re_newpassword");
	  
	  System.out.println(user_name);
	  DaoAccount dao = new DaoAccount();
	  session.setAttribute("checkupdate", true);
	  int a = dao.UpdatePassword(user_name, old_password, new_password, re_password);	  
	  if(a>0)
		  session.setAttribute("messupdate", true);
	  else
		  session.setAttribute("messupdate", false);
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
