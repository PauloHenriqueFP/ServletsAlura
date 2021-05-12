package br.com.patarello.emanager.models;

import java.util.ArrayList;
import java.util.List;

public class DataBaseSimulator {
	public static Long generatedIdEmployee = 1L;
	public static Long generatedIdUser = 1L;

	
	private static List<Employee> employees = new ArrayList<>();
	
	private static List<User> users = new ArrayList<>();

	
	static {
		Employee e = new Employee("Noclai", "nic@gmail", "Relapsos");
		e.setId(generatedIdEmployee++);
		DataBaseSimulator.employees.add(e);
		
		User u = new User("paulo", "123");
		u.setId(generatedIdUser++);
		DataBaseSimulator.users.add(u);
	}
	
	public static List<Employee> getEmployees() {
		return DataBaseSimulator.employees;
	}
	
	public static List<User> getUsers() {
		return DataBaseSimulator.users;
	}
	
	public static Employee getEmployeeById(Long id) throws RuntimeException {
		for(Employee e : DataBaseSimulator.employees) {
			if(e.getId() == id) {
				return e;
			}
		}
		throw new RuntimeException("Employee with id " + id + " does not exists");
	}
	
	public static void deleteEmployeeById(Long id) throws RuntimeException {
		for(int i = 0; i < DataBaseSimulator.employees.size(); i++) {
			if(DataBaseSimulator.employees.get(i).getId() == id) {
				DataBaseSimulator.employees.remove(i);
				return;
			}
		}
		throw new RuntimeException("Employee with id " + id + " does not exists");
	}
	
	public static void saveEmployee(Employee e) {
		
		if(e.getId() != null) { // Update
			DataBaseSimulator.employees.add(e);
			return;
		}
		
		e.setId(DataBaseSimulator.generatedIdEmployee++);
		DataBaseSimulator.employees.add(e); // Create
	}
	
	public static User userExists(String login, String password) {
		for (User user : DataBaseSimulator.getUsers()) {
			if(user.isEquals(login, password)) {
				return user;
			}
		}
		return null;
	}
}
