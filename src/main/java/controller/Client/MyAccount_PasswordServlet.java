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

import dao.*;
import entity.*;


/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdatePassword")
public class MyAccount_PasswordServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String user="";
        Cookie[] cookies=request.getCookies();
        for(int i=0; i < cookies.length; i++)
        {
    		Cookie cookie=cookies[i];
    		if(cookie.getName().equals("userName"))
    			{
    				user=cookie.getValue();
    			}
    	}      
        String oldPass=request.getParameter("oldpass");
        String newPass1=request.getParameter("newpass1");
        String newPass2=request.getParameter("newpass2");
        
        DaoAccount dao = new DaoAccount();
        int a=dao.UpdatePassword(user, oldPass, newPass1, newPass2);
        if(a>0)
        {
        	response.sendRedirect("home");
        }
        else
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
