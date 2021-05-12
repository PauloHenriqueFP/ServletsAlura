package br.com.patarello.emanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patarello.emanager.models.Action;
import br.com.patarello.emanager.models.DataBaseSimulator;
import br.com.patarello.emanager.models.Employee;

public class UpdateEmployee implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Long id = null;
		String name = null;
		String email = null;
		String department = null;
		
		try {
			
			 id = Long.parseLong(req.getParameter("id"));
			 name = req.getParameter("name");
			 email = req.getParameter("email");
			 department = req.getParameter("department");
			 
		} catch (Exception e) {
			
			throw new ServletException("A Employee atribute was invalid or was not provided");
			
		}
		
		if(id != null && name != null && email != null && department != null) {
			Employee employee = new Employee(name, email, department);
			employee.setId(id);
			
			try {
				
				for(Employee e : DataBaseSimulator.getEmployees()) {
					if(e.getId() == employee.getId()) {
						e.setName(employee.getName());
						e.setEmail(employee.getEmail());
						e.setDepartment(employee.getDepartment());
					}
				}
				
				return "redirect:entry?action=ListEmployees";
				
			} catch (Exception e) {
				
				throw new ServletException("Error trying to save a employee in the Database");
				
			}
			
		}
		else {
			throw new ServletException("A atribute was not passed");
		}
		
	}

}
