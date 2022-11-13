package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import entity.Cart;
import entity.Image;
import entity.Product;
import service.CartService;
import service.ProductService;
import service.ReviewService;

/**
 * Servlet implementation class SearchByName
 */
@WebServlet("/AddCartAjax")
public class AddCartAjax extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String productID = request.getParameter("productID");
		HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        if(a == null) {
        	response.sendRedirect("Login");
        	return;
        }
        
        String userName = a.getUserName();
        int amountCart = (Integer) session.getAttribute("amountCart");
        int amount = 1;
        
        CartService cartservice = new CartService();
        Cart cartExisted = cartservice.checkCartExist(userName,productID);
        PrintWriter out = response.getWriter();
        if(cartExisted != null) {
	       	request.setAttribute("mess", "Sản phẩm này đã tồn tại trong giỏ hàng!");
	       	out.println("<a href=\"managerCart\" id=\"amountcart\" class=\"btn px-0 ml-3\">\n"
	        		+ "	                                <i class=\"fas fa-shopping-cart text-primary\"></i>\n"
	        		+ "		                                <span class=\"badge text-secondary border border-secondary rounded-circle\" style=\"padding-bottom: 2px;\">\n"
	        		+ "		                                		"+ (amountCart) +"\n"
	        		+ "		                                </span>\n"
	        		+ "	                            </a>");

        }
        else {
        	cartservice.insertCart(userName, productID, amount);
	       	request.setAttribute("mess", "Đã thêm sản phẩm vào giỏ hàng!");
	       	session.setAttribute("amountCart", amountCart+1);
	       	
	       	
	        out.println("<a href=\"managerCart\" id=\"amountcart\" class=\"btn px-0 ml-3\">\n"
	        		+ "	                                <i class=\"fas fa-shopping-cart text-primary\"></i>\n"
	        		+ "		                                <span class=\"badge text-secondary border border-secondary rounded-circle\" style=\"padding-bottom: 2px;\">\n"
	        		+ "		                                		"+ (amountCart+1) +"\n"
	        		+ "		                                </span>\n"
	        		+ "	                            </a>");

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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
