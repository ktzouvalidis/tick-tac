package com.ticktac.filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.ticktac.business.User;

/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}, urlPatterns = { "/addevent.jsp", "/editevent.jsp", "/myevents.jsp", "/editaccount.jsp" }, servletNames = { "EventController", "AccountController"})
public class LoginFilter implements Filter {
	
    public LoginFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest http = (HttpServletRequest) request;
		User user= (User) http.getSession().getAttribute("userBean");
		 
		if(user==null)
			 request.getRequestDispatcher("login.jsp").forward(request, response);
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {}

}
