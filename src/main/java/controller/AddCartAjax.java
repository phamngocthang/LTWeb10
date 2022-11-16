package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
        CartService cartservice = new CartService();
        PrintWriter out = response.getWriter();
        if(a == null) {
        	//String string = session.getAttribute("amountCart").toString();
        	// amount = Integer.parseInt(string);
        	String amountCart ="";
        	String cart = "";
            Cookie[] arr = request.getCookies();
            for (Cookie o:arr) {
            	if (o.getName().equals("Cart")) {
            		cart = o.getValue();      		
            		o.setMaxAge(0);
            		response.addCookie(o);
            	}
            	if (o.getName().equals("amountCart")) {
            		//if(productID ==)
            		amountCart = o.getValue();
            		o.setMaxAge(0);
            		response.addCookie(o);
            	}
            }
            if (productID != null){
            	String num = "1";
            	int amount = Integer.parseInt(amountCart);
            	if(cart.isEmpty()){
            		cart = productID +":"+num;
            		amount++;
                }else {
                	int number = cartservice.checkCartCookies(cart, productID);
                	if(number!=0) {
                		number = number + 1;
                		cart = cart +"/"+productID+":"+ String.valueOf(number);
                	}else {	
                		cart = cart +"/"+productID+":"+num;
                		amount++;
                	}
                }
        		Cookie amountC = new Cookie("amountCart",Integer.toString(amount));
        		amountC.setMaxAge(24*60*60);
    	    	response.addCookie(amountC);
        		session.setAttribute("amountCart",amount);
            	
            }
            int amountNew = (Integer) session.getAttribute("amountCart");
            out.println("<i class=\"fas fa-shopping-cart text-primary\"></i>\n"
	       			+ "		                                <span class=\"badge text-secondary border border-secondary rounded-circle\" style=\"padding-bottom: 2px;\">\n"
	       			+ "		                                		"+amountNew+"\n"
	       			+ "		                                </span>");
            Cookie Cart = new Cookie("Cart", cart);
	    	Cart.setMaxAge(24*60*60);
	    	response.addCookie(Cart);
        	//response.sendRedirect("Login");
        	//return;
        }
        else {
	        String userName = a.getUserName();
	        int amountCart = (Integer) session.getAttribute("amountCart");
	        int amount = 1;
	        
	        Cart cartExisted = cartservice.checkCartExist(userName,productID);
	        if(cartExisted != null) {
		       	request.setAttribute("mess", "Sản phẩm này đã tồn tại trong giỏ hàng!");
		       	out.println("<i class=\"fas fa-shopping-cart text-primary\"></i>\n"
		       			+ "		                                <span class=\"badge text-secondary border border-secondary rounded-circle\" style=\"padding-bottom: 2px;\">\n"
		       			+ "		                                		"+amountCart+"\n"
		       			+ "		                                </span>");
	
	        }
	        else {
	        	cartservice.insertCart(userName, productID, amount);
		       	request.setAttribute("mess", "Đã thêm sản phẩm vào giỏ hàng!");
		       	session.setAttribute("amountCart", amountCart+1);
		       	
		       	
		        out.println("<i class=\"fas fa-shopping-cart text-primary\"></i>\n"
		        		+ "		                                <span class=\"badge text-secondary border border-secondary rounded-circle\" style=\"padding-bottom: 2px;\">\n"
		        		+ "		                                		"+(amountCart+1)+"\n"
		        		+ "		                                </span>");
	
	        }
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
