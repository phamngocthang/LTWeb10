package controller.client.cart;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/EditCart")
public class EditAmountCartServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String productID = request.getParameter("productID");
        String isSub = request.getParameter("isSub");
        int amount = Integer.parseInt(request.getParameter("amount"));
        if(isSub.equals("true")) {
        	amount-=1;
        }
        else {
        	amount+=1;
        }
        if(amount <= 0) {
        	amount = 1;
        }
        Account a = (Account) session.getAttribute("user");
        CartService cartservice = new CartService();
        
        List<Cart> listCart = new ArrayList<>();
        List<Product> listProduct = new ArrayList<>();
        if(a == null) {
        	String cart ="";
        	Cookie[] arr = request.getCookies();
            for (Cookie o:arr) {
            	if (o.getName().equals("Cart")) {
            		cart = o.getValue();
            	}
            }
            List<Cart> list = cartservice.getCartCookies(cart);
            String editamount = cartservice.editAmountCookies(Integer.parseInt(productID), list, amount);
            for (Cookie o:arr) {
            	if (o.getName().equals("Cart")) {
            		o.setValue(editamount);
            	}
            }
        	
            
            for (Cookie o:arr) {
             	if (o.getName().equals("Cart")) {
             		cart = o.getValue();
             		o.setMaxAge(24*60);
             		response.addCookie(o);
             	}
             }

            listCart = cartservice.getCartCookies(cart);
            listProduct = cartservice.getProductCookies(listCart);
        }else {
	        String userName = a.getUserName();;
	        cartservice.editAmountCart(userName, productID, amount);
	        
	        listCart = cartservice.getCartByUserName(userName);
	        listProduct = cartservice.getProductByPIDAndUserName(listCart);
        }
        session.setAttribute("listCart", listCart);   
        session.setAttribute("listProduct", listProduct);

        double subTotal=0;
        for(Cart c : listCart) {
        	for(Product p : listProduct) {
        		if(c.getProduct().getId_P()==p.getId_P()) {
        			subTotal+=p.getPrice()*c.getAmount();
        		}
        	}
        }
        session.setAttribute("subTotal", Math.round(subTotal));
        double totalPrice = subTotal+35000;
        session.setAttribute("totalPrice", Math.round(totalPrice));
        
      
        PrintWriter out = response.getWriter();
        String list = "<div class=\"col-lg-8 table-responsive mb-5\">\n"
        		+ "                <table class=\"table table-light table-borderless table-hover text-center mb-0\">\n"
        		+ "                    <thead class=\"thead-dark\">\n"
        		+ "                        <tr>\n"
        		+ "                            <th>Products</th>\n"
        		+ "                            <th>Price</th>\n"
        		+ "                            <th>Quantity</th>\n"
        		+ "                            <th>Total</th>\n"
        		+ "                            <th>Remove</th>\n"
        		+ "                        </tr>\n"
        		+ "                    </thead>\n"
        		+ "                    <tbody class=\"align-middle\">";
        for(Cart c : listCart) {
        	for(Product p : listProduct) {
        		if(c.getProduct().getId_P()==p.getId_P()) {
        			
        			list += "<tr>\n"
        					+ "				                            <td class=\"align-middle\"><img src=\""+p.getImage().getPathMiddle()+"\" alt=\"\" style=\"width: 50px;\"> "+p.getName_P()+"</td>\n"
        					+ "				                            <td class=\"align-middle\">"+(int)p.getPrice()+" VND</td>\n"
        					+ "				                            <td class=\"align-middle\">\n"
        					+ "				                                <div class=\"input-group quantity mx-auto\" style=\"width: 100px;\">\n"
        					+ "				                                    <div class=\"input-group-btn\">\n"
        					+ "				                                        <button class=\"btn btn-sm btn-primary btn-minus\" id=\"btnSubAmount\" onclick=\"EditCart("+p.getId_P()+", true, "+ c.getAmount()+")\">\n"
        					+ "				                                        <i class=\"fa fa-minus\"></i>\n"
        					+ "				                                        </button>\n"
        					+ "				                                    </div>\n"
        					+ "				                                    <input type=\"text\" id=\"valueAmount\" class=\"form-control form-control-sm bg-secondary border-0 text-center\" value=\""+ c.getAmount() +"\">\n"
        					+ "				                                    <div class=\"input-group-btn\">\n"
        					+ "				                                        <button class=\"btn btn-sm btn-primary btn-plus\" id=\"btnAddAmount\" onclick=\"EditCart("+p.getId_P()+", false, "+ c.getAmount() +")\">\n"
        					+ "				                                            <i class=\"fa fa-plus\"></i>\n"
        					+ "				                                        </button>\n"
        					+ "				                                    </div>\n"
        					+ "				                                </div>\n"
        					+ "				                            </td>\n"
        					+ "				                            <td class=\"align-middle\">"+ (int)(p.getPrice() * c.getAmount())+" VND</td>\n"
        					+ "				                            <td class=\"align-middle\"><button class=\"btn btn-sm btn-danger\" onclick=\"DeleteCart("+p.getId_P()+")\"><i class=\"fa fa-times\"></i></button></td>\n"
        					+ "				                        </tr>\n";
        		}
        	}
        }
        list += "</tbody>\n"
        		+ "                </table>\n"
        		+ "            </div>";
        
        out.println(list);
        out.println("<div class=\"col-lg-4\">\n"
        		+ "				\n"
        		+ "                <h5 class=\"section-title position-relative text-uppercase mb-3\"><span class=\"bg-secondary pr-3\">Cart Summary</span></h5>\n"
        		+ "                <div class=\"bg-light p-30 mb-5\" id=\"charge\">\n"
        		+ "                    <div class=\"border-bottom pb-2\">\n"
        		+ "                        <div class=\"d-flex justify-content-between mb-3\">\n"
        		+ "                            <h6>Subtotal</h6>\n"
        		+ "                            <h6>"+(int)subTotal+" VND</h6>\n"
        		+ "                        </div>\n"
        		+ "                        <div class=\"d-flex justify-content-between\">\n"
        		+ "                            <h6 class=\"font-weight-medium\">Shipping</h6>\n"
        		+ "                            <h6 class=\"font-weight-medium\">35000 VND</h6>\n"
        		+ "                        </div>\n"
        		+ "                    </div>\n"
        		+ "                    <div class=\"pt-2\">\n"
        		+ "                        <div class=\"d-flex justify-content-between mt-2\">\n"
        		+ "                            <h5>Total</h5>\n"
        		+ "                            <h5>"+(int)totalPrice+" VND</h5>\n"
        		+ "                        </div>\n"
        		+ "                        <button class=\"btn btn-block btn-primary font-weight-bold my-3 py-3\" onclick=\"location.href='Checkout'\">Proceed To Checkout</button>\n"
        		+ "                    </div>\n"
        		+ "                </div>\n"
        		+ "            </div>");
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
