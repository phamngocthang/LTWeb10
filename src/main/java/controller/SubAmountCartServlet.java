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
@WebServlet("/subAmountCart")
public class SubAmountCartServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int amount = Integer.parseInt(request.getParameter("amount"));
        String productID = request.getParameter("productID");
        amount-=1;
        System.out.print(amount);
        Account a = (Account) session.getAttribute("user");
        CartService cartservice = new CartService();
        if(a == null) {
        	String cart ="";
        	Cookie[] arr = request.getCookies();
            for (Cookie o:arr) {
            	if (o.getName().equals("Cart")) {
            		cart = o.getValue();
            	}
            }
            List<Cart> list = cartservice.getCartCookies(cart);
            String subamount = cartservice.editAmountCookies(Integer.parseInt(productID), list, amount);
            for (Cookie o:arr) {
            	if (o.getName().equals("Cart")) {
            		o.setValue(subamount);
            	}
            }
        }else {
        	String userName = a.getUserName();
        	cartservice.editAmountCart(userName, productID, amount);
        }
        if(amount < 1) {
        	response.sendRedirect("deleteCart?productID="+productID);
        	return;
        }
        request.setAttribute("mess", "Da giam so luong!");
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
