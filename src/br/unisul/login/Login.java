package br.unisul.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unisul.login.User;

public class Login extends HttpServlet {

	User[] users = new User[100];
	int index = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		
		writer.print("<!DOCTYPE html>");
		writer.print("<head>");
		writer.print("<meta charset=\"UTF-8\">");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<form method=\"POST\" action=\"http://localhost:8080/lib/login\">");
		writer.print("<h3>Login</h3>");
		writer.print("<input type=\"text\" id=\"login\" name=\"login\" />");
		writer.print("<input type=\"password\" id=\"password\" name=\"password\" />");
		writer.print("<input type=\"submit\">");
		writer.print("</form>");
		writer.print("</body>");

	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		String login = req.getParameter("login");
		
		String password = req.getParameter("password");

		 
		if (login.equalsIgnoreCase("admin") && password.equalsIgnoreCase(("admin"))) {

			HttpSession session = req.getSession();
			
			session.setAttribute("logado", 1);
			
			resp.sendRedirect("http://localhost:8080/lib/cadastro");
			
		}else{
			
			resp.sendError(401);
			
		}

	}

}