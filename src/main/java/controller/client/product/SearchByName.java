package controller.client.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Image;
import entity.Product;
import service.ProductService;

/**
 * Servlet implementation class SearchByName
 */
@WebServlet("/SearchByName")
public class SearchByName extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");//giay chay bo
        ProductService pService = new ProductService();
        List<Product> list = pService.searchByName(txtSearch);
        PrintWriter out = response.getWriter();
        // Phan dau
        out.println("<div class=\"col-12 pb-1\">\r\n"
				+ "                        <div class=\"d-flex align-items-center justify-content-between mb-4\">\r\n"
				+ "                            <div>\r\n"
				+ "                                <button class=\"btn btn-sm btn-light\"><i class=\"fa fa-th-large\"></i></button>\r\n"
				+ "                                <button class=\"btn btn-sm btn-light ml-2\"><i class=\"fa fa-bars\"></i></button>\r\n"
				+ "                            </div>\r\n"
				+ "                            <div class=\"ml-2\">\r\n"
				+ "                                <div class=\"btn-group ml-2\">\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ "                    </div>");
        
        for (Product o : list) {
			Image img = o.getImage();
			out.println("<div class=\"col-lg-4 col-md-6 col-sm-6 pb-1\">\r\n"
					+ "	                        <div class=\"product-item bg-light mb-4\">\r\n"
					+ "	                            <div class=\"product-img position-relative overflow-hidden\">\r\n"
					+ "	                                <img class=\"img-fluid w-100\" src=\""+img.getPathMiddle()+"\" alt=\"\">\r\n"
					+ "	                                <div class=\"product-action\">\r\n"
					+ "	                                    <a class=\"btn btn-outline-dark btn-square\" onclick=\"AddCartAjax("+o.getId_P()+", "+ o.getStatus()+")\"><i class=\"fa fa-shopping-cart\"></i></a>\r\n"
					+ "	                                    <a class=\"btn btn-outline-dark btn-square\" onclick=\"AddFavoriteProductAjax("+o.getId_P()+")\"><i class=\"far fa-heart\"></i></a>\r\n");
			if(o.getStatus() == 0) {
				out.println("<button type=\"button\" class=\"btn btn-warning\" id=\"expired\">\r\n"
						+ "											      Hết hàng\r\n"
						+ "											    </button>\r\n");
			}
			out.println("</div>\r\n"
					+ "	                            </div>\r\n"
					+ "	                            <div class=\"text-center py-4\">\r\n"
					+ "	                                <a class=\"h6 text-decoration-none text-truncate\" href=\"detail?id="+o.getId_P()+"&brand="+o.getBrand()+"\">"+o.getName_P()+"</a>\r\n"
					+ "	                                <div class=\"d-flex align-items-center justify-content-center mt-2\">\r\n"
					+ "	                                    <h5>"+o.getPrice()+" VNĐ</h5>\r\n"
					+ "	                                </div>\r\n"
					+ "	                                <div class=\"d-flex align-items-center justify-content-center mb-1\">\r\n"
					+ "	                                    <small class=\"fa fa-star text-primary mr-1\"></small>\r\n"
					+ "	                                    <small class=\"fa fa-star text-primary mr-1\"></small>\r\n"
					+ "	                                    <small class=\"fa fa-star text-primary mr-1\"></small>\r\n"
					+ "	                                    <small class=\"fa fa-star text-primary mr-1\"></small>\r\n"
					+ "	                                    <small class=\"fa fa-star-half-alt text-primary mr-1\"></small>\r\n"
					+ "	                                    <small>(99)</small>\r\n"
					+ "	                                </div>\r\n"
					+ "	                            </div>\r\n"
					+ "	                        </div>\r\n"
					+ "	                    </div>");
		}
    }

    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
