package controller.client.account;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAccount;
import entity.Account;
import entity.Cart;
import service.AccountService;
import service.CartService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("Client/Login.jsp").include(request, response);
		HttpSession session = request.getSession();

	    String username = request.getParameter("user");
	    String password = request.getParameter("pass");
	    String receivedToken = request.getParameter("csrfToken");
		System.out.println(receivedToken);
		if (receivedToken != null && receivedToken.equals(session.getAttribute("csrfToken"))) {
	        
	        AccountService sv = new AccountService();
	        Account a = sv.getAccount(username, password);
	        CartService cartservice = new CartService();
	        if(a != null) {
	        	String cart = "";
	            Cookie[] arr = request.getCookies();
	            for (Cookie o:arr) {
	            	if (o.getName().equals("Cart")) {
	            		cart = o.getValue();      		
	            		o.setMaxAge(0);
	            		response.addCookie(o);
	            	}
	            }
	            List <Cart> list = cartservice.getCartCookies(cart);
	        	String userName = a.getUserName();
	        	for (Cart c: list) {
	        		Cart cartExisted = cartservice.checkCartExist(userName,String.valueOf(c.getProduct().getId_P()));
	        		int amountExisted;
	        		if(cartExisted != null) {
		       	       	amountExisted = cartExisted.getAmount();
		       	       	cartservice.editAmountCart(userName,String.valueOf(c.getProduct().getId_P()), (amountExisted+c.getAmount()));
	        		}
	        		else {
		               cartservice.insertCart(userName, String.valueOf(c.getProduct().getId_P()), c.getAmount());
	        		}
	        	}    
	        	
	        	// store the Account object as a session attribute
	            session.setAttribute("user", a);   
	            
	            // store the Account object as a session attribute
	            session.setAttribute("userName", a.getUserName());   
	            // add a cookie that stores the user's email to browser
//	            Cookie c = new Cookie("userName", username);
//	            c.setHttpOnly(true);
//	            c.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
//	            c.setPath("/");                      // allow entire app to access it
//	            String encodedValue = Base64.getEncoder().encodeToString(username.getBytes());
//	            c.setValue(encodedValue);
//	            response.addCookie(c);
	            
	            if(a.getIsAdmin() == 0) {
	            	response.sendRedirect("home");
	            }
	            else {
	            	response.sendRedirect("DashBoard");
	            }
	        }
	        else if(username!=null){
	        	request.getRequestDispatcher("Client/Login.jsp?err=1").forward(request, response);
	        }
	      } else {
	    	  response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
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
