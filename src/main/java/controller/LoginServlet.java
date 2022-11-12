package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAccount;
import entity.Account;
import entity.Product;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
  
        DaoAccount dao = new DaoAccount();
        Account a = dao.Login(username, password);
        if(a != null) { 
        	// store the data in a Account object
        	Account acc = new Account();
        	acc.setUserName(username);
        	acc.setPassWord(password);
        	
            // store the Account object as a session attribute
            HttpSession session = request.getSession();
            session.setAttribute("user", acc);   
            
            // add a cookie that stores the user's email to browser
            Cookie c = new Cookie("userName", username);
            c.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
            c.setPath("/");                      // allow entire app to access it
            response.addCookie(c);
            
            response.sendRedirect("home");
        }
        else {
        	response.sendRedirect("Client/Login.jsp?err=1");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
