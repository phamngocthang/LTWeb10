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
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        CartService cartservice = new CartService();
        try {
        	if(a == null) {
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
                String num = Integer.toString(quantity);
                int amount = Integer.parseInt(amountCart);
                if(cart.isEmpty()){
                	cart = productID +":"+num;
                	amount++;
                }else {
                	
                    int number = cartservice.checkCartCookies(cart, productID);
                    // Đã có
                    if(number!=0) {
                    	number = number + quantity;
                    	cart = cart +"/"+productID+":"+ String.valueOf(number);
                    }
                    // Chưa có
                    else {	
                    	cart = cart +"/"+productID+":"+num;
                    	amount++;
                    }
                }
                System.out.println(amount);
            	Cookie amountC = new Cookie("amountCart",Integer.toString(amount));
            	amountC.setMaxAge(24*60*60);
        	    response.addCookie(amountC);
            	session.setAttribute("amountCart",amount);
            	// IN KQ
                Cookie Cart = new Cookie("Cart", cart);
    	    	Cart.setMaxAge(24*60*60);
    	    	response.addCookie(Cart);
    	    	
    	    	request.getRequestDispatcher("managerCart").forward(request, response);
            }
            else {
            	String userName = a.getUserName();
                
                Cart cartExisted = cartservice.checkCartExist(userName,productID);
                int amountExisted;
                if(cartExisted != null) {
        	       	 amountExisted = cartExisted.getAmount();
        	       	 cartservice.editAmountCart(userName,productID, (amountExisted+quantity));

        	       	 request.getRequestDispatcher("managerCart").forward(request, response);
                }
                else {
                	cartservice.insertCart(userName, productID, quantity);
        	       	request.getRequestDispatcher("managerCart").forward(request, response);
                }
            }
        }
        catch (Exception e) {
			System.out.println(e.getMessage());
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
