package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DAOPRODUCT;
import entity.Image;
import entity.Product;
/**
 * Servlet implementation class SearchProductByPrice
 */
@WebServlet("/SearchProductByPrice")
public class SearchProductByPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductByPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        // Get atrribute request
        String price1 = request.getParameter("price1");
        String price2 = request.getParameter("price2");
        String price3 = request.getParameter("price3");
		DAOPRODUCT dao = new DAOPRODUCT();
		List<Product> listP = dao.getProductAjax(price1, price2, price3);
		PrintWriter out = response.getWriter();
		// Phan dau
		out.println("<div class=\"col-12 pb-1\">\r\n"
				+ "                        <div class=\"d-flex align-items-center justify-content-between mb-4\">\r\n"
				+ "                            <div>\r\n"
				+ "                                <button class=\"btn btn-sm btn-light\"><i class=\"fa fa-th-large\"></i></button>\r\n"
				+ "                                <button class=\"btn btn-sm btn-light ml-2\"><i class=\"fa fa-bars\"></i></button>\r\n"
				+ "                            </div>\r\n"
				+ "                            <div class=\"ml-2\">\r\n"
				+ "                                <div class=\"btn-group\">\r\n"
				+ "                                    <button type=\"button\" class=\"btn btn-sm btn-light dropdown-toggle\" data-toggle=\"dropdown\">Sorting</button>\r\n"
				+ "                                    <div class=\"dropdown-menu dropdown-menu-right\">\r\n"
				+ "                                        <a class=\"dropdown-item\" href=\"#\">Latest</a>\r\n"
				+ "                                        <a class=\"dropdown-item\" href=\"#\">Popularity</a>\r\n"
				+ "                                        <a class=\"dropdown-item\" href=\"#\">Best Rating</a>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </div>\r\n"
				+ "                                <div class=\"btn-group ml-2\">\r\n"
				+ "                                    <button type=\"button\" class=\"btn btn-sm btn-light dropdown-toggle\" data-toggle=\"dropdown\">Showing</button>\r\n"
				+ "                                    <div class=\"dropdown-menu dropdown-menu-right\">\r\n"
				+ "                                        <a class=\"dropdown-item\" href=\"shop?index=${1}&showP=${3}\">3</a>\r\n"
				+ "                                        <a class=\"dropdown-item\" href=\"shop?index=${1}&showP=${6}\">6</a>\r\n"
				+ "                                        <a class=\"dropdown-item\" href=\"shop?index=${1}&showP=${9}\">9</a>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ "                    </div>");
		// Phan giua gom cac san pham
		for (Product o : listP) {
			Image img = o.getImg();
			out.println("<div class=\"col-lg-4 col-md-6 col-sm-6 pb-1\">\r\n"
					+ "	                        <div class=\"product-item bg-light mb-4\">\r\n"
					+ "	                            <div class=\"product-img position-relative overflow-hidden\">\r\n"
					+ "	                                <img class=\"img-fluid w-100\" src=\""+img.getPath_middle()+"\" alt=\"\">\r\n"
					+ "	                                <div class=\"product-action\">\r\n"
					+ "	                                    <a class=\"btn btn-outline-dark btn-square\" href=\"\"><i class=\"fa fa-shopping-cart\"></i></a>\r\n"
					+ "	                                    <a class=\"btn btn-outline-dark btn-square\" href=\"\"><i class=\"far fa-heart\"></i></a>\r\n"
					+ "	                                    <a class=\"btn btn-outline-dark btn-square\" href=\"\"><i class=\"fa fa-sync-alt\"></i></a>\r\n"
					+ "	                                    <a class=\"btn btn-outline-dark btn-square\" href=\"\"><i class=\"fa fa-search\"></i></a>\r\n"
					+ "	                                </div>\r\n"
					+ "	                            </div>\r\n"
					+ "	                            <div class=\"text-center py-4\">\r\n"
					+ "	                                <a class=\"h6 text-decoration-none text-truncate\" href=\"\">"+o.getName_P()+"</a>\r\n"
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
		// Phan cuoi 
		out.println("<div class=\"col-12\">\r\n"
				+ "                        <nav>\r\n"
				+ "                          <ul class=\"pagination justify-content-center\">\r\n"
				+ "	                        <li class=\"page-item ${tag == 1?\"disabled\":\"\"}\"><a class=\"page-link\" href=\"shop?index=${tag-1}&showP=${showtag}\">Previous</span></a></li>\r\n"
				+ "	                        <c:forEach begin=\"1\" end=\"${endP}\" var=\"i\">\r\n"
				+ "		                        <li class=\"page-item ${tag == i?\"active\":\"\"}\"><a class=\"page-link\" href=\"shop?index=${i}&showP=${showtag}\">${i}</a></li>          \r\n"
				+ "	                        </c:forEach>\r\n"
				+ "	                        <li class=\"page-item ${tag == endP?\"disabled\":\"\"}\"><a class=\"page-link\" href=\"shop?index=${tag+1}&showP=${showtag}\">Next</a></li>\r\n"
				+ "                          </ul>\r\n"
				+ "                        </nav>\r\n"
				+ "                    </div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
