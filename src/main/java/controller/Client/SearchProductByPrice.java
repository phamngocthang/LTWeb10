package controller.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;
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
        
        String color1 = request.getParameter("color1");
        String color2 = request.getParameter("color2");
        String color3 = request.getParameter("color3");
        //
        String indexP = request.getParameter("indexP");
        int showP = Integer.parseInt(request.getParameter("showP"));
        String subcateID = request.getParameter("subcateID");
        //
		ProductService pService = new ProductService();
		String[] query = {""};
		//List<Product> listP = dao.getProductAjax(price1, price2, price3, color1, color2, color3, subcateID, indexP, showP, query);
		List<Product> listP = pService.getProductAjax(price1, price2, price3, color1, color2, color3, subcateID, indexP, showP, query);	


		int count = pService.getCountQuery(query[0]);
		int endP = count / showP;
		if(count % showP != 0)
		{
			endP++;
		}
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
				+ "                                    <button type=\"button\" class=\"btn btn-sm btn-light dropdown-toggle\" data-toggle=\"dropdown\">Showing</button>\r\n"
				+ "                                    <div class=\"dropdown-menu dropdown-menu-right\">\r\n"
				+ "                                        <a class=\"dropdown-item\" onclick=\"SearchByPrice(1, 3);\">3</a>\r\n"
				+ "                                        <a class=\"dropdown-item\" onclick=\"SearchByPrice(1, 6);\">6</a>\r\n"
				+ "                                        <a class=\"dropdown-item\" onclick=\"SearchByPrice(1, 9);\">9</a>\r\n"
				+ "                                    </div>\r\n"
				+ "                                </div>\r\n"
				+ "                            </div>\r\n"
				+ "                        </div>\r\n"
				+ "                    </div>");
		// Phan giua gom cac san pham
		for (Product o : listP) {
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
		// Phan cuoi 
		String disable = (indexP == "1" ? " disabled": "");
		String footer = "<div class=\"col-12\">\r\n"
				+ "                        <nav>\r\n"
				+ "                          <ul class=\"pagination justify-content-center\">\r\n"
				+ "	                        <li class=\"page-item "+(Integer.parseInt(indexP) == 1 ? "disabled": "")+"\"><a class=\"page-link\" onclick=\"SearchByPrice("+(Integer.parseInt(indexP)-1)+","+showP+");\">Previous</span></a></li>\r\n";
		for (int o = 1; o <= endP; o++) {
			footer += "<li class=\"page-item "+(Integer.parseInt(indexP) == o ? "active": "")+"\"><a class=\"page-link\" onclick=\"SearchByPrice("+o+","+showP+");\">"+o+"</a></li>";
		}
		footer += "<li class=\"page-item "+(Integer.parseInt(indexP) == endP ? "disabled": "")+"\"><a class=\"page-link\" onclick=\"SearchByPrice("+(Integer.parseInt(indexP)+1)+","+showP+");\">Next</a></li>\r\n"
				+ "                          </ul>\r\n"
				+ "                        </nav>\r\n"
				+ "                    </div>";
		out.println(footer);
		/*
		out.println("<div class=\"col-12\">\r\n"
				+ "                        <nav>\r\n"
				+ "                          <ul class=\"pagination justify-content-center\">\r\n"
				+ "	                        <li class=\"page-item ${"+indexP+" == 1?\"disabled\":\"\"}\"><a class=\"page-link\" onclick=\"SearchByPrice("+(Integer.parseInt(indexP)-1)+","+showP+");\">Previous</span></a></li>\r\n"
				+ "	                        <c:forEach begin=\"1\" end=\""+endP+"\" var=\"i\">\r\n"
				+ "		                        <li class=\"page-item ${"+indexP+" == i?\"active\":\"\"}\"><a class=\"page-link\" onclick=\"SearchByPrice(${i},"+showP+");\">i</a></li>          \r\n"
				+ "	                        </c:forEach>\r\n"
				+ "	                        <li class=\"page-item ${"+indexP+" == "+endP+"?\"disabled\":\"\"}\"><a class=\"page-link\" onclick=\"SearchByPrice("+(Integer.parseInt(indexP)+1)+","+showP+");\">Next</a></li>\r\n"
				+ "                          </ul>\r\n"
				+ "                        </nav>\r\n"
				+ "                    </div>");
		*/
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
