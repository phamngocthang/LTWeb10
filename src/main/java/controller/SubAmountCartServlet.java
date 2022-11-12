package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        Account a = (Account) session.getAttribute("user");
        if(a == null) {
        	response.sendRedirect("Login");
        	return;
        }
        
        String userName = a.getUserName();;
        String productID = request.getParameter("productID");
        int amount = Integer.parseInt(request.getParameter("amount"));
        if(amount <= 1) {
        	response.sendRedirect("deleteCart?productID="+productID);
        	return;
        }
        amount-=1;
        CartService cartservice = new CartService();
        cartservice.editAmountCart(userName, productID, amount);
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
