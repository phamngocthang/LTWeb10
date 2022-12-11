package controller.client.account.google_access.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.client.account.google_access.common.GooglePojo;
import controller.client.account.google_access.common.GoogleUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import entity.Account;
import entity.Customer;
import entity.Cart;
import service.CartService;
import service.CustomerService;
import service.AccountService;
import dao.DaoAccount;

@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LoginGoogleServlet() {
    super();
  }
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String code = request.getParameter("code");
    if (code == null || code.isEmpty()) {
      RequestDispatcher dis = request.getRequestDispatcher("Login");
      dis.forward(request, response);
    } else {
      String accessToken = GoogleUtils.getToken(code);
      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
      Account a=new Account();
      a.setUserName(googlePojo.getEmail().toString());
      a.setPassWord("");
      a.setIsAdmin(0);
      
      DaoAccount dao = new DaoAccount();
      AccountService accountservice = new AccountService();
      Account accountExisted = accountservice.getAccountByUsername(a.getUserName());
      if (accountExisted==null)
    	  dao.Signup(a.getUserName(), a.getPassWord(), a.getPassWord(), 0);
      
      CustomerService customerservice = new CustomerService();
      Customer customerExisted = customerservice.checkCustomerExist(a.getUserName());
      if (customerExisted==null)
    	  dao.InsertCustomer(a.getUserName());
      
      CartService cartservice = new CartService();
      String cart = "";
      Cookie[] arr = request.getCookies();
      for (Cookie o:arr) {
      	if (o.getName().equals("Cart")) {
      		cart = o.getValue();      		
      		o.setMaxAge(0);
      		response.addCookie(o);
      	}
      }
      List <Cart> list = cartservice.getCartCookies(cart);
		String userName = a.getUserName();
		for (Cart c : list) {
			Cart cartExisted = cartservice.checkCartExist(userName, String.valueOf(c.getProduct().getId_P()));
			int amountExisted;
			if (cartExisted != null) {
				amountExisted = cartExisted.getAmount();
				cartservice.editAmountCart(userName, String.valueOf(c.getProduct().getId_P()),
						(amountExisted + c.getAmount()));
			} else {
				cartservice.insertCart(userName, String.valueOf(c.getProduct().getId_P()), c.getAmount());
			}
		}    
		
		// store the Account object as a session attribute
        HttpSession session = request.getSession();
        session.setAttribute("user", a);   
        
        // add a cookie that stores the user's email to browser
        Cookie c = new Cookie("userName", a.getUserName());
        c.setMaxAge(60 * 60 * 24 * 365 * 3); // set age to 3 years
        c.setPath("/");                      // allow entire app to access it
        response.addCookie(c);
		
		RequestDispatcher dis = request.getRequestDispatcher("home");
		dis.forward(request, response);
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