package controller.client.account;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Bill;
import service.BillService;
import entity.Account;
import service.AccountService;

@WebServlet("/MyAccount")
public class MyAccountServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String username="";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		 for (Cookie cookie : cookies) {
		   if (cookie.getName().equals("userName")) {
			   username=cookie.getValue();
		    }
		  }
		}		
		AccountService accountService = new AccountService();
		Account acc = accountService.getAccountByUsername(username);
		BillService billService = new BillService();
		List<Bill> listBill = billService.getBillByAccount(acc);
		// print listBill length
		request.setAttribute("listBill", listBill);
        request.getRequestDispatcher("Client/myaccount.jsp").forward(request, response);
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
