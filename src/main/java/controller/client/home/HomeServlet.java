package controller.client.home;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoCustomer;
import service.BillService;
import service.CartService;
import service.CategoryService;
import service.CustomerService;
import service.FavoriteProductService;
import service.ProductService;
import entity.Account;
import entity.Cart;
import entity.Customer;
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

    protected List<Product> getBestSellerProduct() {
        ProductService productService = new ProductService();
        List<Product> list = productService.getTopProduct();
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
		String csrfToken = UUID.randomUUID().toString();
		HttpSession session = request.getSession();
	    session.setAttribute("csrfToken", csrfToken);
	    response.setHeader("Content-Security-Policy", "frame-ancestors 'self';");
	    response.setHeader("X-Frame-Options", "SAMEORIGIN");
		String user="";
        Cookie[] cookies=request.getCookies();
        if(cookies!=null)
        {
        	for(int i=0; i < cookies.length; i++)
            {
        		Cookie cookie=cookies[i];
        		if(cookie.getName().equals("userName"))
        			{
        				user=cookie.getValue();
        			}
        	}                    
        }
        CustomerService custsv = new CustomerService();
        Customer cus= custsv.getCustomerByID(user); 
        session.setAttribute("curCustomer", cus);
        // ProductService pService = new ProductService();
        // // Get 4 Recent Product
        // List<Product> list = pService.getRecentProduct();
    
        List<Subcategory> categories = getCategory();
        List<Product> recentProducts = getRecentProduct();
        HashMap<Integer, Integer> countProduct = countProduct(categories);
        List<Product> bestSellerProducts = getBestSellerProduct();
        
        request.setAttribute("allCategories", categories);
        request.setAttribute("recentProducts", recentProducts);
        request.setAttribute("countProduct", countProduct);
        request.setAttribute("bestSellerProducts", bestSellerProducts);

        FavoriteProductService fproductservice = new FavoriteProductService();
        CartService cartservice = new CartService();
        Account a = (Account) session.getAttribute("user");
        

        if(a != null) {
        	session.setAttribute("amountCart", cartservice.getCountCart(a.getUserName()));
        	session.setAttribute("amountfProduct", fproductservice.getCountFavoriteProduct(a.getUserName()));
        }
        else {
        	 String amount = "";
             Cookie[] arr = request.getCookies();
             if(arr!=null)
             {
            	 for (Cookie o:arr) {
                  	if (o.getName().equals("Cart")) {
                  		amount = o.getValue();
                  		o.setMaxAge(60*24*60);
                  		response.addCookie(o);
                  	}
                  }
             }
             if (amount.isEmpty())
             {
             	amount ="0";
     	    	Cookie amountCart = new Cookie("amountCart", amount);
     	    	amountCart.setHttpOnly(true);
     	    	amountCart.setMaxAge(24*60*60);
     	    	response.addCookie(amountCart);
             }
             else {
            	 CartService cart = new CartService();
            	 List<Cart> list = cart.getCartCookies(amount);
            	 amount = Integer.toString(list.size());
            	 Cookie amountCart = new Cookie("amountCart", Integer.toString(list.size()));
            	 amountCart.setHttpOnly(true);
      	    	 amountCart.setMaxAge(24*60*60);
      	    	 response.addCookie(amountCart);
             }
             session.setAttribute("amountCart", amount);
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
