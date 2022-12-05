package controller.admin.account;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAccount;

import entity.Account;
import entity.Subcategory;
import service.AccountService;

@WebServlet("/AccountManage")
public class AccountManageServlet extends HttpServlet {
	protected List<Account> getAccount() {
        AccountService Service = new AccountService();
        List<Account> list = Service.getAllAccount();
        return list;
    }
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		List<Account> accounts = getAccount();
		session.setAttribute("allAccounts", accounts);
        request.getRequestDispatcher("Admin/ManageAccount.jsp").forward(request, response);
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
