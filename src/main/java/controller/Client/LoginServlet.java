package controller.Client;

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
import entity.Cart;
import entity.Product;
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
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
  
        DaoAccount dao = new DaoAccount();
        Account a = dao.Login(username, password);
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
            HttpSession session = request.getSession();
            session.setAttribute("user", a);   
            
            // add a cookie that stores the user's email to browser
            Cookie c = new Cookie("userName", username);
            c.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
            c.setPath("/");                      // allow entire app to access it
            response.addCookie(c);
            
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
