package br.com.patarello.emanager.models;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
