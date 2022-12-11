package controller.client.bill;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import entity.Bill;
import entity.Billdetail;
import entity.Feedback;
import entity.Product;
import service.AccountService;
import service.BillService;
import service.ProductService;
import service.ReviewService;
import service.ShopDetailService;

@WebServlet(name = "MyBillDetailServet", urlPatterns = { "/MyBillDetail" })
public class MyBillDetailServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    // get bill id from request
    int billId = Integer.parseInt(request.getParameter("billId"));
    // get bill detail by bill id
    BillService billService = new BillService();
    List<Billdetail> listBillDetail = billService.getAllBillDetails(billId);
    
    int total = 0;
    for (Billdetail billdetail : listBillDetail) {
		total += billdetail.getAmount() * billdetail.getProduct().getPrice();
	}
    request.setAttribute("total", total);
    
    // print billDetail
    request.setAttribute("billDetail", listBillDetail);
    request.setAttribute("billId", billId);
    request.getRequestDispatcher("Client/MyBillDetail.jsp").forward(request, response);
  }
}
