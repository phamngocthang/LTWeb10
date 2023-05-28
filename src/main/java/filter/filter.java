package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;

@WebFilter(urlPatterns = {"/Signup"})
public class filter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String requestURL = req.getRequestURL().toString();
		 // Kiểm tra URL yêu cầu
	    if (requestURL.contains("http://localhost:8088/WebApp/Signup") && req.getMethod().equals("GET")) {
	        // Chuyển hướng về trang home
	        res.sendRedirect("home");
	    } else {
	        // Tiếp tục xử lý yêu cầu
	        chain.doFilter(request, response);
	    }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
