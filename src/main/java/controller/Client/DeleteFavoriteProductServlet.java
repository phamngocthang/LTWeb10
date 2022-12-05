package controller.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import entity.Favoriteproduct;
import entity.Product;
import service.FavoriteProductService;

@WebServlet("/deleteFavoriteProduct")
public class DeleteFavoriteProductServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("productID"));
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        if(a == null) {
        	response.sendRedirect("Login");
        	return;
        }
        String userName = a.getUserName();
        FavoriteProductService fproductservice = new FavoriteProductService();
        fproductservice.deleteCart(productID, a.getUserName());
        
        List<Favoriteproduct> listfproduct = fproductservice.getFavoriteProductByUserName(userName);
        List<Product> listProduct = fproductservice.getProductByPIDAndUserName(listfproduct);
        session.setAttribute("amountfProduct", listfproduct.size());
        
        PrintWriter out = response.getWriter();
        out.println(listfproduct.size());
        
        for (Favoriteproduct f : listfproduct) {
			for (Product p : listProduct) {
				if(f.getProduct().getId_P() == p.getId_P()) {
					out.println("<div class=\"col-lg-3 col-md-4 col-sm-6 pb-1\">\n"
							+ "                        <div class=\"product-item bg-light mb-4\">\n"
							+ "                            <div class=\"product-img position-relative overflow-hidden\">\n"
							+ "                                <img class=\"img-fluid w-100\" src=\""+ p.getImage().getPathMiddle() +"\" alt=\"\">\n"
							+ "                                <div class=\"product-action\">\n"
							+ "                                    <a class=\"btn btn-outline-dark btn-square\" onclick=\"DelFavoriteProductAjax("+ p.getId_P()+")\"><i\n"
							+ "                                            class=\"fas fa-heart-broken\" ></i></a>		\n"
							+ "                                </div>\n"
							+ "                            </div>\n"
							+ "                            <div class=\"text-center py-4\">\n"
							+ "                                <a class=\"h6 text-decoration-none text-truncate\"\n"
							+ "                                    href=\"${pageContext.request.contextPath}/detail?id="+ p.getId_P()+"&brand="+p.getBrand() +"\">"+ p.getName_P()+"</a>\n"
							+ "                                <div class=\"d-flex align-items-center justify-content-center mt-2\">\n"
							+ "                                    <h5>"+p.getPrice() +" VND</h5>\n"
							+ "                                </div>\n"
							+ "                                <div class=\"d-flex align-items-center justify-content-center mb-1\">\n"
							+ "                                    <small class=\"fa fa-star text-primary mr-1\"></small>\n"
							+ "                                    <small class=\"fa fa-star text-primary mr-1\"></small>\n"
							+ "                                    <small class=\"fa fa-star text-primary mr-1\"></small>\n"
							+ "                                    <small class=\"fa fa-star text-primary mr-1\"></small>\n"
							+ "                                    <small class=\"fa fa-star text-primary mr-1\"></small>\n"
							+ "                                    <small>(99)</small>\n"
							+ "                                </div>\n"
							+ "                            </div>\n"
							+ "                        </div>\n"
							+ "                    </div>");
				}
			}
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
