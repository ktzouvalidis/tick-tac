package com.ticktac.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ValidatePassFilter
 */
@WebFilter(description = "Checks if the confirmation password is the same with the password previously typed.",
urlPatterns = { "/signup" }, servletNames = {"AccountController"})
public class ValidatePassFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ValidatePassFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rqst = (HttpServletRequest) request;
		String pass = (String) rqst.getParameter("pass");
		String cfmpass = (String) rqst.getParameter("cfmpass");
		
		if(!pass.equals(cfmpass)) {
			rqst.setAttribute("passValidation", 0);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
