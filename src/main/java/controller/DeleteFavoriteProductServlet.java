package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FavoriteProductService;

@WebServlet("/deleteFavoriteProduct")
public class DeleteFavoriteProductServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        FavoriteProductService fproductservice = new FavoriteProductService();
        fproductservice.deleteCart(productID);
        request.setAttribute("mess1", "Da xoa san pham khoi san pham yeu thich!");
        request.getRequestDispatcher("managerFavoriteProduct").forward(request, response);
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
