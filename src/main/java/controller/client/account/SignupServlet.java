package controller.client.account;

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

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("Client/Login.jsp").include(request, response);
        String username = request.getParameter("user_signup");
        String password = request.getParameter("pass_signup");
        String repassword = request.getParameter("repass_signup");
  
        DaoAccount dao = new DaoAccount();
        int a= dao.Signup(username, password, repassword, 0);
        if(a!= 0) { 
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
        else{
        	request.getRequestDispatcher("Client/Login.jsp?err2=2").forward(request, response);
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