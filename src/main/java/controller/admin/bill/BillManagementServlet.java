package controller.admin.bill;

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
import entity.Feedback;
import entity.Product;
import service.AccountService;
import service.BillService;
import service.ProductService;
import service.ReviewService;
import service.ShopDetailService;

@WebServlet(name = "BillManagementServlet", urlPatterns = { "/BillManagement" })
public class BillManagementServlet extends HttpServlet {
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
    BillService billService = new BillService();
    List<Bill> listBill = billService.getAllBill();
    // print listBill length
    request.setAttribute("listBill", listBill);
    request.getRequestDispatcher("Admin/Bill.jsp").forward(request, response);
  }
}
