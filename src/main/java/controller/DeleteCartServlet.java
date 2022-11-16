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

import entity.Account;
import entity.Cart;
import entity.Product;
import service.CartService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/deleteCart")
public class DeleteCartServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        CartService cartservice = new CartService();
        if(a == null) {
        	String cart ="";
        	Cookie[] arr = request.getCookies();
        	for (Cookie o:arr) {
             	if (o.getName().equals("Cart")) {
             		cart = o.getValue();
             		o.setMaxAge(0);
             		response.addCookie(o);	
             	}
            } 
        	System.out.println(cart);
        	List <Cart> carts = cartservice.getCartCookies(cart);
        	String cartCookies = cartservice.deleteCartCookies(productID,carts);
        	//Cookie newCartCookie = new Cookie("Cart",cartCookies);
        	//newCartCookie.setMaxAge(24*60*60);
        	//response.addCookie(newCartCookie);
        	//Cookie[] arr1 = request.getCookies();
        	for (Cookie o:arr) {
             	if (o.getName().equals("Cart")) {
             		o.setValue(cartCookies);
             	}
            } 
        	//response.sendRedirect("Login");
        	//return;
        }else {
	        cartservice.deleteCart(productID, a.getUserName());
        }
        request.setAttribute("mess", "Da xoa san pham khoi gio hang!");
        request.getRequestDispatcher("managerCart").forward(request, response);
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
