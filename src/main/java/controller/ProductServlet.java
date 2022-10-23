package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.DAOPRODUCT;
import entity.Image;
import entity.Product;



@WebServlet(name = "HomeControl", urlPatterns = {"/shop"})
public class ProductServlet extends HttpServlet {
	DAOPRODUCT dao = new DAOPRODUCT();
	
	private int getEndPage(String show) {
		int showPage = Integer.parseInt(show);
		int count = dao.getCountAccount();
		int endP = count / showPage;
		if(count % showPage != 0)
		{
			endP++;
		}
		return endP;
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		try
		{
	        response.setContentType("text/html;charset=UTF-8");
	        // Get Parameter and Convert to INT
	        String show = request.getParameter("showP");
	        String indexP = request.getParameter("index");
	        int showPage = Integer.parseInt(show);
			int indexPage = Integer.parseInt(indexP);
	        // End Page Product
	        int endP = getEndPage(show);
			request.setAttribute("endP", endP);
			// Display Product
			List<Product> listA = dao.pagingAccount(indexPage, showPage);
			HttpSession session = request.getSession();
			session.setAttribute("listP", listA);
			// Send endP end showtag
			session.setAttribute("tag", indexPage);
			session.setAttribute("showtag", showPage);
	        request.getRequestDispatcher("shop.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
