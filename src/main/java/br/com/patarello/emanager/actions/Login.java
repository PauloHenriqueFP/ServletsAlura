package br.com.patarello.emanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patarello.emanager.models.Action;
import br.com.patarello.emanager.models.DataBaseSimulator;
import br.com.patarello.emanager.models.User;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String login = null, password = null;
		try {
			
			login = req.getParameter("login");
			password = req.getParameter("password");
			
		} catch (Exception e) {
			throw new ServletException("Error tring to read the body atributes of the request");
		}	
		
		if(login != null && password != null) {
			User user = DataBaseSimulator.userExists(login, password);
			System.out.println(user);
			if(user != null) {
				return "redirect:entry?action=ListEmployees";
			}
			else {
				return "redirect:entry?action=LoginForm";
			}
		}
		else {
			throw new ServletException("Login and password must not be null");
		}
	}

}
