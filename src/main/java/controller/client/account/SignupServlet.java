package controller.client.account;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAccount;
import entity.Account;
import service.AccountService;
import service.CustomerService;

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
  
        AccountService accsv = new AccountService();
        if(isValidPassword(password)) {
        	int a = accsv.Signup(username, password, repassword, 0);
            CustomerService cussv = new CustomerService();
            cussv.InsertCustomer(username);
            
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
        } else {
        	request.getRequestDispatcher("Client/Login.jsp?err2=3").forward(request, response);
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
    public boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$";
        return Pattern.matches(passwordPattern, password);
    }
}