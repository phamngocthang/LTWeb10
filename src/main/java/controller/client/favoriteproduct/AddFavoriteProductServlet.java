package controller.client.favoriteproduct;

import java.io.IOException;
import java.io.PrintWriter;

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
		String productID = request.getParameter("productID");
		HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        if(a == null) {
        	response.sendRedirect("Login");
        	return;
        }
        
        String userName = a.getUserName();
        int amountfproduct = (Integer) session.getAttribute("amountfProduct");
    	PrintWriter out = response.getWriter();
        FavoriteProductService fproductservice = new FavoriteProductService ();
        Favoriteproduct fproductExisted = fproductservice.checkFavorityProductExist(userName,productID);
        if(fproductExisted == null) {
        	fproductservice.insertFavoriteProduct(userName, productID);
	       	request.setAttribute("mess1", "Da them san pham yeu thich!");
	       	session.setAttribute("amountfProduct", amountfproduct+1);
	       	out.println((amountfproduct + 1));
        }
        else 
        {
        	request.setAttribute("mess1", "Sản phẩm này đã tồn tại trong giỏ hàng!");

        	out.println((amountfproduct));
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
