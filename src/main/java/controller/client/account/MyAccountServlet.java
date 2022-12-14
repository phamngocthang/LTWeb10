package controller.client.account;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Bill;
import service.BillService;
import entity.Account;
import service.AccountService;

@WebServlet("/MyAccount")
public class MyAccountServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		
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
		Account acc = accountService.getSingle(username);
		BillService billService = new BillService();
		List<Bill> listBill = billService.getBillByAccount(acc);
		// print listBill length
		request.setAttribute("listBill", listBill);
		
		request.setAttribute("statusmanage", false);
		//check thêm tài khoản
		if (session.getAttribute("checkinsert") != null && session.getAttribute("messinsert") != null)
		{
			boolean checkinsert = (boolean)session.getAttribute("checkinsert");
			boolean messinsert = (boolean)session.getAttribute("messinsert");
			session.setAttribute("checkinsert", false);
			request.setAttribute("checkinsert", checkinsert);
			request.setAttribute("messinsert", messinsert);
			request.setAttribute("statusmanage", true);	 
		}
		else
			request.setAttribute("checkinsert", false);
		//check cập nhật tài khoản
		if (session.getAttribute("checkupdate") != null && session.getAttribute("messupdate") != null)
		{
			boolean checkupdate = (boolean)session.getAttribute("checkupdate");
			boolean messupdate = (boolean)session.getAttribute("messupdate");
			session.setAttribute("checkupdate", false);
			request.setAttribute("checkupdate", checkupdate);
			request.setAttribute("messupdate", messupdate);
			request.setAttribute("statusmanage", true);	 
		}
		else
			request.setAttribute("checkupdate", false);
		if(session.getAttribute("checkinsert") != null ||session.getAttribute("checkupdate") != null ) {
			request.setAttribute("statusmanage", true);
		}
		
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
