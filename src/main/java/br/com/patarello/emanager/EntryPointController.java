package br.com.patarello.emanager;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patarello.emanager.models.Action;

@SuppressWarnings("serial")
@WebServlet("/entry")
public class EntryPointController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		String className = "br.com.patarello.emanager.actions." + action; 
		Class<?> clazz = null;
		try {
			
			clazz = Class.forName(className);
			
		} catch (ClassNotFoundException e) {
			
			throw new ServletException(e.getMessage());
			
		}
		
		String whatToDo = null;
		if(!Objects.isNull(clazz)) {
			try {
				
				@SuppressWarnings("deprecation")
				Action myAction = (Action) clazz.newInstance();
				whatToDo = myAction.execute(req, res);
				
			} catch (InstantiationException | IllegalAccessException e) {
				
				throw new ServletException(e.getMessage());
				
			}
		}
		
		String[] ResponseTypeAndAddress = whatToDo.split(":");
		
		if ( ResponseTypeAndAddress[0].equals("redirect") ) { // do redirect
			
			res.sendRedirect(ResponseTypeAndAddress[1]); // address
			
		}
		
		if ( ResponseTypeAndAddress[0].equals("forward") ) { // do forward
			
			RequestDispatcher rd = req.getRequestDispatcher(ResponseTypeAndAddress[1]); // JSP address
			rd.forward(req, res);
			
		}
		
	}
	
}
