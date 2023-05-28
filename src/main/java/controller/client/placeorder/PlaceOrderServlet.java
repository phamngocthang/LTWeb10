package controller.client.placeorder;

import java.io.IOException;
import java.util.Base64;
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
import entity.Email;
import entity.EmailUtils;
import entity.Product;
import service.AccountService;
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
//        Account a = (Account) session.getAttribute("user");
        String userName = (String) session.getAttribute("userName");
        
        String codeBase64 = "";
        
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("userName")) {
//                    codeBase64 = cookie.getValue();
//                    // sử dụng giá trị userName ở đây
//                    break;
//                }
//            }
//        }
//        try {
//        	userName = new String(Base64.getDecoder().decode(codeBase64));
//        }
//        catch (Exception e) {
//        	session.setAttribute("checkinsert", false);
//            request.getRequestDispatcher("managerCart").forward(request, response);
//            return;
//		}
//       
        
        
        System.out.println(userName);
        if(userName == "") {
        	response.sendRedirect("Login");
        	return;
        }
        List<Cart> cart = (List<Cart>) session.getAttribute("listCart");
        List<Product> product = (List<Product>) session.getAttribute("listProduct");
        
        String t = String.valueOf(session.getAttribute("totalPrice"));
        int total = Integer.parseInt(t);
//        if(a == null) {
//        	response.sendRedirect("Login");
//        	return;
//        }
        
        System.out.println(userName);
        
        
        BillService billService = new BillService();
        AccountService accountService = new AccountService();
        if(cart.size() > 0) {
//        	billService.insertBill(a.getUserName(), total);
        	billService.insertBill(userName, total);
        	int idBill = billService.getMaxIDBill();
        	for (Cart c : cart) {
        		for (Product p : product) {
        			if(p.getId_P() == c.getProduct().getId_P())
        			{
        				billService.insertBillDeTail(idBill, p.getId_P(), c.getAmount());
        			}
				}
			}
        }
        Account checkAccount = accountService.getSingle(userName);
        session.setAttribute("showFirst", true);
        if(checkAccount != null) {
        	CartService carService = new CartService();
            carService.deleteCartByUser(userName);
            session.setAttribute("checkinsert", true);
            request.getRequestDispatcher("managerCart").forward(request, response);
        }
        else {
        	session.setAttribute("checkinsert", false);
        	request.getRequestDispatcher("managerCart").forward(request, response);
        }
        
        // ------------------------------------------ SEND MAIL --------------------------------------------------
//        try {
//			String emailAddress = request.getParameter("email");
//			String firstname = request.getParameter("firstname");
//			String lastname = request.getParameter("lastname");
//			String Address = request.getParameter("address");
//			String phonenumber = request.getParameter("phonenumber");
//		        
//		        
//		        //old code
//				Email email =new Email();
//				email.setFrom("20110728@student.hcmute.edu.vn"); 
//				email.setFromPassword("0937566870");
//				email.setTo(emailAddress);
//				email.setSubject("Đặt hàng thành công từ Shoes Family");
//				StringBuilder sb = new StringBuilder();
//				sb.append("<font color=red>").append("Dear ").append(firstname).append(" ").append(lastname).append("<br> </font>");
//				sb.append("Bạn vừa đặt hàng từ Shoes Family. <br> ");
//				sb.append("Địa chỉ nhận hàng của bạn là: <b>").append(Address).append(" </b> <br>");
//				sb.append("Số điên thoại khi nhận hàng của bạn là: <b>").append(phonenumber).append(" </b> <br>");
//				sb.append("Các sản phẩm bạn đặt là: <br>");
//				for (Cart c : cart) {
//	        		for (Product p : product) {
//	        			if(p.getId_P() == c.getProduct().getId_P())
//	        			{
//	        				sb.append(p.getName_P()).append(" | ").append("Price:").append(p.getPrice()).append("$").append(" | ").append("Amount:").append(c.getAmount()).append(" | ").append("<br>");
//	        			}
//					}
//				}
//				
//				sb.append("Tổng tiền: ").append("<font color=red>").append(total).append("$").append("</font> <br>");
//				sb.append("Cảm ơn bạn đã ủng hộ Shoes Family<br>");
//				
//				email.setContent(sb.toString());
//				EmailUtils.send(email);
//				request.setAttribute("mess", "Dat hang thanh cong!");
//				
//				 // Delete Cart
//		        CartService carService = new CartService();
////		        carService.deleteCartByUser(a.getUserName());
//		        carService.deleteCartByUser(userName);
//				
//			
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
    
        // ------------------------------------------ SEND MAIL --------------------------------------------------
        
        
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
