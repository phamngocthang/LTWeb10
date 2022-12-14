package controller.client.placeorder;

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
import entity.Email;
import entity.EmailUtils;
import entity.Product;
import service.BillService;
import service.CartService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/PlaceOrder")
public class PlaceOrderServlet extends HttpServlet {
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        
        List<Cart> cart = (List<Cart>) session.getAttribute("listCart");
        List<Product> product = (List<Product>) session.getAttribute("listProduct");
        
        String t = String.valueOf(session.getAttribute("totalPrice"));
        int total = Integer.parseInt(t);
        if(a == null) {
        	response.sendRedirect("Login");
        	return;
        }
        BillService billService = new BillService();
        if(cart.size() > 0) {
        	billService.insertBill(a.getUserName(), total);
        	int idBill = billService.getMaxIDBill();
        	for (Cart c : cart) {
        		for (Product p : product) {
        			if(p.getId_P() == c.getProduct().getId_P())
        			{
        				billService.insertBillDeTail(idBill, p.getId_P(), c.getAmount());
        			}
				}
			}
        	session.setAttribute("checkinsert",true);
        }
        
        // ------------------------------------------ SEND MAIL --------------------------------------------------
        try {
			String emailAddress = request.getParameter("email");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String Address = request.getParameter("address");
			String phonenumber = request.getParameter("phonenumber");
		        
		        
		        //old code
				Email email =new Email();
				email.setFrom("20110672@student.hcmute.edu.vn"); 
				email.setFromPassword("Baolocace111@");
				email.setTo(emailAddress);
				email.setSubject("?????t h??ng th??nh c??ng t??? Shoes Family");
				StringBuilder sb = new StringBuilder();
				sb.append("<font color=red>").append("Dear ").append(firstname).append(" ").append(lastname).append("<br> </font>");
				sb.append("B???n v???a ?????t h??ng t??? Shoes Family. <br> ");
				sb.append("?????a ch??? nh???n h??ng c???a b???n l??: <b>").append(Address).append(" </b> <br>");
				sb.append("S??? ??i??n tho???i khi nh???n h??ng c???a b???n l??: <b>").append(phonenumber).append(" </b> <br>");
				sb.append("C??c s???n ph???m b???n ?????t l??: <br>");
				for (Cart c : cart) {
	        		for (Product p : product) {
	        			if(p.getId_P() == c.getProduct().getId_P())
	        			{
	        				sb.append(p.getName_P()).append(" | ").append("Price:").append(p.getPrice()).append("$").append(" | ").append("Amount:").append(c.getAmount()).append(" | ").append("<br>");
	        			}
					}
				}
				
				sb.append("T???ng ti???n: ").append("<font color=red>").append(total).append("$").append("</font> <br>");
				sb.append("C???m ??n b???n ???? ???ng h??? Shoes Family<br>");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				request.setAttribute("mess", "Dat hang thanh cong!");
				
				 // Delete Cart
		        CartService carService = new CartService();
		        carService.deleteCartByUser(a.getUserName());
				
				
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    
        // ------------------------------------------ SEND MAIL --------------------------------------------------
        request.setAttribute("mess", "?????t H??ng Th??nh C??ng! Ki???m Tra ????n H??ng T??i Email C???a B???n");
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
