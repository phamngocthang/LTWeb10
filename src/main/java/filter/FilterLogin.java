package filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;

@WebFilter(urlPatterns = {"/DashBoard", "/TopServlet", "/BillManagement", "/AccountManage", "/ManagerProduct"})
public class FilterLogin implements Filter {
	public void destroy() {
		//close any resources here
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Account a = (Account) session.getAttribute("user");
		
        if(a != null && (a.getIsAdmin() == 1)) {
        	chain.doFilter(request, response);
        }
        else {
        	res.sendRedirect("home");
        }
	}
}
