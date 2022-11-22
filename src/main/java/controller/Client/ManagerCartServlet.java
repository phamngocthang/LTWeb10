package controller.Client;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/managerCart")
public class ManagerCartServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        CartService cartservice = new CartService();
        List<Cart> listCart = new ArrayList<>();
        List<Product> listProduct = new ArrayList<>();
        String cart ="";
        Cookie[] arr = request.getCookies();
        if(a == null) {
        	for (Cookie o:arr) {
             	if (o.getName().equals("Cart")) {
             		cart = o.getValue();
             		o.setMaxAge(24*60);
             		response.addCookie(o);
             	}
             }
        	listCart = cartservice.getCartCookies(cart);
        	listProduct = cartservice.getProductCookies(listCart);
        	//response.sendRedirect("login");
        	//return;
        }else {
	        String userName = a.getUserName();
	        listCart = cartservice.getCartByUserName(userName);
	        listProduct = cartservice.getProductByPIDAndUserName(listCart);
        }
        session.setAttribute("listCart", listCart);   
        session.setAttribute("listProduct", listProduct);
        session.setAttribute("amountCart", listCart.size());
        
        double totalPrice=0;
        for(Cart c : listCart) {
        	for(Product p : listProduct) {
        		if(c.getProduct().getId_P()==p.getId_P()) {
        			totalPrice=totalPrice+p.getPrice()*c.getAmount();
        		}
        	}
        }
        session.setAttribute("subTotal", Math.round(totalPrice));
        totalPrice = totalPrice+35000;
        session.setAttribute("totalPrice", Math.round(totalPrice));
        request.getRequestDispatcher("Client/cart.jsp").forward(request, response);
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
