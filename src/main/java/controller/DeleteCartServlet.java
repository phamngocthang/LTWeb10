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
@WebServlet("/deleteCart")
public class DeleteCartServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        CartService cartservice = new CartService();
        cartservice.deleteCart(productID);
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
