package br.com.patarello.emanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patarello.emanager.models.Action;
import br.com.patarello.emanager.models.DataBaseSimulator;

public class ListEmployees implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			
			req.setAttribute("employees", DataBaseSimulator.getEmployees());

		} catch (Exception e) {
			
			throw new ServletException("Error trying to get all employees");
			
		}
		
		return "forward:WEB-INF/view/list_employees.jsp";
	}

}
