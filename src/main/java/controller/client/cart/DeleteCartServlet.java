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
@WebServlet("/deleteCart")
public class DeleteCartServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        HttpSession session = request.getSession();
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
             		o.setMaxAge(0);
             		response.addCookie(o);	
             	}
            } 
        	List <Cart> carts = cartservice.getCartCookies(cart);
        	String cartCookies = cartservice.deleteCartCookies(productID,carts);
        	//Cookie newCartCookie = new Cookie("Cart",cartCookies);
        	//newCartCookie.setMaxAge(24*60*60);
        	//response.addCookie(newCartCookie);
        	//Cookie[] arr1 = request.getCookies();
        	for (Cookie o:arr) {
             	if (o.getName().equals("Cart")) {
             		o.setValue(cartCookies);
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
	        cartservice.deleteCart(productID, a.getUserName());
	        listCart = cartservice.getCartByUserName(a.getUserName());
	        listProduct = cartservice.getProductByPIDAndUserName(listCart);
        }
        session.setAttribute("listCart", listCart);   
        session.setAttribute("listProduct", listProduct);
        session.setAttribute("amountCart", listCart.size());
        Cookie amountCart = new Cookie("amountCart", Integer.toString(listCart.size()));
	    amountCart.setMaxAge(24*60*60);
	    response.addCookie(amountCart);
        //System.out.println(session.getAttribute("amountCart"));
        double subTotal=0;
        for(Cart c : listCart) {
        	for(Product p : listProduct) {
        		if(c.getProduct().getId_P()==p.getId_P()) {
        			subTotal=subTotal+p.getPrice()*c.getAmount();
        		}
        	}
        }
        session.setAttribute("subTotal", Math.round(subTotal));
        double totalPrice = subTotal+35000;
        session.setAttribute("totalPrice", Math.round(totalPrice));
        
        PrintWriter out = response.getWriter();
        out.println((int)session.getAttribute("amountCart"));
        
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
        					+ "				                                        <button class=\"btn btn-sm btn-primary btn-minus\" id=\"btnSubAmount\" onclick=\"EditCart("+p.getId_P()+", true, "+ c.getAmount() +")\">\n"
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
