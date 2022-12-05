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

import dao.*;
import entity.*;


/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomer")
public class MyAccount_CustomerServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        try {
        	DaoCustomer dao = new DaoCustomer();
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
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");      
            int a=dao.UpdateCustomer(user, firstName, lastName, email, address, phone); 
            if(a>0)
            {
                response.sendRedirect("home");
            }
            else
            	request.getRequestDispatcher("Client/myaccount.jsp").forward(request, response);
        }
        catch(Exception e) {        	
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
