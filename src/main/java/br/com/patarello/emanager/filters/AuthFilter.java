package br.com.patarello.emanager.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("AuthFilter");
		
		HttpServletResponse res = (HttpServletResponse) servletResponse;
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpSession session = req.getSession();
		
		String action = req.getParameter("action");
		
		/*
		 * Check if the user is authenticated
		 */		
		boolean isUserAuthenticated = (session.getAttribute("authenticatedUser") != null);
		
		boolean isResourceProtected = !(action.equals("Login")  || action.equals("LoginForm")); 
		
		if(!isUserAuthenticated && isResourceProtected) {
			
			res.sendRedirect("entry?action=LoginForm");
			return;
		}
		
		chain.doFilter(req, res);
		
	}

}
