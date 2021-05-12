package br.com.patarello.emanager.models;

public class User {
	
	private Long id;
	
	private String login;
	
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User (String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEquals(String login, String password) {
		if(!this.login.equals(login)) {
			return false;
		}
		
		if(!this.password.equals(password)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	
}
