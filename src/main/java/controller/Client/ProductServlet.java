package controller.Client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import service.ProductService;
import entity.Image;
import entity.Product;



@WebServlet(name = "HomeControl", urlPatterns = {"/shop"})
public class ProductServlet extends HttpServlet {
	ProductService pService = new ProductService();
	private int getEndPage(String subcateID, String show) {
		int showPage = Integer.parseInt(show);

		int count = pService.getCountAccount(subcateID);

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
	        // Get Parameter and Convert to 
	        String subcateID = request.getParameter("subcateID");
	        String show = request.getParameter("showP");
	        String indexP = request.getParameter("index");
	        int showPage = Integer.parseInt(show);
			int indexPage = Integer.parseInt(indexP);
	        int endP = getEndPage(subcateID, show);
	        
	        //List<Product> listA = dao.pagingAccount(subcateID, indexPage, showPage);
	        List<Product> listA = pService.pagingAccount(subcateID, indexPage, showPage);
	        request.setAttribute("endP", endP);
			request.setAttribute("listP", listA);
			
			// Send endP end showtag
			request.setAttribute("tag", indexPage);
			request.setAttribute("showtag", showPage);
			request.setAttribute("subcateID", subcateID);
	        request.getRequestDispatcher("Client/shop.jsp").forward(request, response);
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
