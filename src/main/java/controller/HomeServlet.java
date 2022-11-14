package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CartService;
import service.CategoryService;
import service.ProductService;
import service.FavoriteProductService;
import entity.Account;
import entity.Product;
import entity.Subcategory;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    // get all category
    protected List<Subcategory> getCategory() {
        CategoryService categoryService = new CategoryService();
        List<Subcategory> list = categoryService.getAllSubCategory();
        return list;
    }

    protected List<Product> getRecentProduct() {
        ProductService productService = new ProductService();
        List<Product> list = productService.getRecentProduct();
        return list;
    }
    
    protected HashMap<Integer, Integer> countProduct(List<Subcategory> list) {
        CategoryService categoryService = new CategoryService();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Subcategory subcategory : list) {
            int subcategoryId = subcategory.getId_SubCate();
            int count = categoryService.countProduct(subcategoryId);
            map.put(subcategoryId, count);
        }
        return map;
    }


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        
        // ProductService pService = new ProductService();
        // // Get 4 Recent Product
        // List<Product> list = pService.getRecentProduct();
    
        List<Subcategory> categories = getCategory();
        List<Product> recentProducts = getRecentProduct();
        HashMap<Integer, Integer> countProduct = countProduct(categories);

        
        request.setAttribute("allCategories", categories);
        request.setAttribute("recentProducts", recentProducts);
        request.setAttribute("countProduct", countProduct);
        
        CartService cartservice = new CartService();
        FavoriteProductService fproductservice = new FavoriteProductService();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("user");
        if(a != null) {
        	session.setAttribute("amountCart", cartservice.getCountCart(a.getUserName()));
        	session.setAttribute("amountfProduct", fproductservice.getCountFavoriteProduct(a.getUserName()));
        }
        
        request.getRequestDispatcher("Client/index.jsp").forward(request, response);
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
