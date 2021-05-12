package br.com.patarello.emanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.patarello.emanager.models.Action;

public class LoginForm implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		return "forward:WEB-INF/view/login.jsp";
	}

}
