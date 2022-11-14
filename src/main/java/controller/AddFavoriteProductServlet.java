package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import entity.Favoriteproduct;
import service.FavoriteProductService;

/**
 * Servlet implementation class AddFavoriteProductServlet
 */
@WebServlet("/addFavoriteProduct")
public class AddFavoriteProductServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String productID = request.getParameter("pid");
		HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        if(a == null) {
        	response.sendRedirect("Login");
        	return;
        }
        
        String userName = a.getUserName();
        FavoriteProductService fproductservice = new FavoriteProductService ();
        Favoriteproduct fproductExisted = fproductservice.checkFavorityProductExist(userName,productID);
        if(fproductExisted == null) {
        	fproductservice.insertFavoriteProduct(userName, productID);
	       	request.setAttribute("mess", "Da them san pham yeu thich!");
	        request.getRequestDispatcher("managerFavoriteProduct").forward(request, response);
        }
        else 
        {
        	response.sendRedirect("#");
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
