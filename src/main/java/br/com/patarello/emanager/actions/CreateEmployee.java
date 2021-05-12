package br.com.patarello.emanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patarello.emanager.models.Action;
import br.com.patarello.emanager.models.DataBaseSimulator;
import br.com.patarello.emanager.models.Employee;

public class CreateEmployee implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String department = req.getParameter("department");
		
		Employee employee = new Employee(name, email, department);
		
		try {
			
			DataBaseSimulator.saveEmployee(employee);

		} catch (Exception e) {
			
			System.err.println("Error trying to save a client");
			
		}
		
		return "redirect:entry?action=ListEmployees";
		
	}
	
}
