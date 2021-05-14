package br.com.patarello.emanager;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patarello.emanager.models.Action;

public class EntryPoint implements Filter {
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("EntryPoint");


		HttpServletResponse res = (HttpServletResponse) servletResponse;
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		
		String action = req.getParameter("action");
		
		String className = "br.com.patarello.emanager.actions." + action; 
		Class<?> clazz = null;
		try {
			
			clazz = Class.forName(className);
			
		} catch (ClassNotFoundException e) {
			
			throw new ServletException(e.getMessage());
			
		}
		
		String whatToDo = null;
		if( !Objects.isNull(clazz) ) {
			try {
				
				@SuppressWarnings("deprecation")
				Action myAction = (Action) clazz.newInstance();
				whatToDo = myAction.execute(req, res);
				
			} catch ( InstantiationException | IllegalAccessException e ) {
				
				throw new ServletException(e.getMessage());
				
			}
		}
		
		String[] ResponseTypeAndAddress = whatToDo.split(":");
		
		if ( ResponseTypeAndAddress[0].equals("redirect") ) { // do redirect
			
			res.sendRedirect(ResponseTypeAndAddress[1]); // URL address
			
		}
		
		if ( ResponseTypeAndAddress[0].equals("forward") ) { // do forward
			
			RequestDispatcher rd = req.getRequestDispatcher(ResponseTypeAndAddress[1]); // JSP address
			rd.forward(req, res);
			
		}
		

		
	}
	
}
