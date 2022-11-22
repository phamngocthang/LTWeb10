package controller.Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import entity.Image;
import entity.Product;
import service.ProductService;
import service.ReviewService;

/**
 * Servlet implementation class SearchByName
 */
@WebServlet("/AddReviews")
public class AddReviewAjax extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		// Get Parameter
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String message = request.getParameter("message");
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("user");
        String productID = request.getParameter("productID");
        ReviewService reviewService = new ReviewService();
        // Insert Review
        reviewService.insertReview(productID, acc.getUserName() , message);
        // Get Current Date
        java.util.Date today = new java.util.Date();
        Date date = new java.sql.Date(today.getTime());
        // Println to AddReview Servlet
        PrintWriter out = response.getWriter();
        out.println("<div id=\"testrv\">\n"
        		+ "	                                    	<div class=\"media mb-4\">\n"
        		+ "		                                        <div class=\"media-body\">\n"
        		+ "		                                            <h6>"+ acc.getUserName()+"<small> - <i>"+ date.toString() +"</i></small></h6>\n"
        		+ "		                                            <p>"+ message +"</p>\n"
        		+ "		                                        </div>\n"
        		+ "	                                    	</div>\n"
        		+ "                                    	</div>");
        
        out.println("<div class=\"media mb-4\" id=\"testrv2\">\n"
        		
        		+ "                                        <div class=\"media-body\">\n"
        		+ "                                            <h6>"+acc.getUserName()+"<small> - <i>"+ date.toString() +"</i></small></h6>\n"
        		+ "                                            <p>"+ message + " test2"+ "</p>\n"
        		+ "                                        </div>\n"
        		+ "                                    </div>");

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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
