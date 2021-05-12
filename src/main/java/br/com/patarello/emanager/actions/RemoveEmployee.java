package br.com.patarello.emanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patarello.emanager.models.Action;
import br.com.patarello.emanager.models.DataBaseSimulator;

public class RemoveEmployee implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Long id = null;
		
		try {
			
			id = Long.parseLong(req.getParameter("id"));
			
		} catch (Exception e) {
			
			throw new ServletException("Id was invalid or null");
			
		}
		
		DataBaseSimulator.deleteEmployeeById(id);
		
		return "redirect:entry?action=ListEmployees";
	}

}
