package br.com.patarello.emanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patarello.emanager.models.Action;
import br.com.patarello.emanager.models.DataBaseSimulator;
import br.com.patarello.emanager.models.Employee;

public class UpdateEmployeeForm implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Long id = null;
		try {
			
			id = Long.parseLong(req.getParameter("id"));
			
		} catch (Exception e) {
			
			throw new ServletException("Id passed was not a valid value");
			
		}
		
		Employee employee = DataBaseSimulator.getEmployeeById(id);
		
		req.setAttribute("employee", employee);
		
		return "forward:WEB-INF/view/update_employee.jsp";
		
	}

}
