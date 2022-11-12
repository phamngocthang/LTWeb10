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
@WebServlet("/addCart")
public class AddCardServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String productID = request.getParameter("pid");
		HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        if(a == null) {
        	response.sendRedirect("Login");
        	return;
        }
        
        String userName = a.getUserName();
        
        int amount = Integer.parseInt(request.getParameter("quantity"));
        
        CartService cartservice = new CartService();
        Cart cartExisted = cartservice.checkCartExist(userName,productID);
        int amountExisted;
        if(cartExisted != null) {
	       	 amountExisted = cartExisted.getAmount();
	       	 System.out.println(amountExisted+amount);
	       	 cartservice.editAmountCart(userName,productID, (amountExisted+amount));
	       	 request.setAttribute("mess", "Da tang so luong san pham!");
	       	 request.getRequestDispatcher("managerCart").forward(request, response);
        }
        else {
        	cartservice.insertCart(userName, productID, amount);
	       	request.setAttribute("mess", "Da them san pham vao gio hang!");
	       	request.getRequestDispatcher("managerCart").forward(request, response);
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
