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
import entity.Favoriteproduct;
import entity.Product;
import service.FavoriteProductService;

/**
 * Servlet implementation class ManagerFavoriteProductServlet
 */
@WebServlet("/managerFavoriteProduct")
public class ManagerFavoriteProductServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        if(a == null) {
        	response.sendRedirect("Login");
        	return;
        }
        String userName = a.getUserName();
        FavoriteProductService fproductservice = new FavoriteProductService();
        
        List<Favoriteproduct> listfproduct = fproductservice.getFavoriteProductByUserName(userName);
        List<Product> listProduct = fproductservice.getProductByPIDAndUserName(userName);
        session.setAttribute("listfproduct", listfproduct);   
        session.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("Client/favoriteproduct.jsp").forward(request, response);
      
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
