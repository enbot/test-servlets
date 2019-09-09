package br.unisul.cadastro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unisul.login.User;

public class Cadastro extends HttpServlet {

	User[] users = new User[100];
	int index = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		HttpSession session = req.getSession();

		Object logado = session.getAttribute("logado");

		if (logado != null) {
			writer.print("<!DOCTYPE html>");
			writer.print("<head>");
			writer.print("<meta charset=\"UTF-8\">");
			writer.print("</head>");
			writer.print("<body>");
			writer.print("<form method=\"POST\" action=\"http://localhost:8080/lib/cadastro\">");
			writer.print("<h3>Cadastro</h3>");
			writer.print("<label for=\"nome\"> nome </label>");
			writer.print("<input type=\"text\" id=\"nome\" name=\"nome\" value=\"nathan\" />");
			writer.print("<label for=\"nome\"> idade </label>");
			writer.print("<input type=\"number\" id=\"idade\" name=\"idade\" value=\"20\" />");
			writer.print("<label for=\"disciplinas\"> disciplinas (insira com virgula) </label>");
			writer.print(
					"<input type=\"text\" id=\"disciplinas\" name=\"disciplinas\" value=\"Portugues, matematica\" />");
			writer.print("<input type=\"submit\">");
			writer.print("</form>");
			writer.print("</body>");

		} else {

			resp.sendRedirect("http://localhost:8080/lib/login");

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		String nome = req.getParameter("nome");

		int idade = Integer.parseInt(req.getParameter("idade"));

		String[] disc = req.getParameter("disciplinas").split(",");

		HttpSession session = req.getSession();

		Object logado = session.getAttribute("logado");

		if (logado != null) {

			if (this.index < 100) {

				User user = new User();

				user.setDisciplinas(disc);
				user.setIdade(idade);
				user.setNome(nome);

				this.users[this.index] = user;
				this.index++;

				PrintWriter writer = resp.getWriter();

				this.doGet(req, resp);

				writer.print("<h3>cadastrados: </h3>");

				writer.print("<table>");
				
				writer.print("<tr>");
				writer.print("<th> nome </th>");
				writer.print("<th> idade </th>");
				writer.print("<th> disciplinas </th>");
				writer.print("</tr>");

				for (int i = 0; i < this.index; i++) {
					writer.print("<tr>");
					writer.print("<td>" + this.users[i].getNome() + "</td>");
					writer.print("<td>" + this.users[i].getIdade() + " </td>");
					writer.print("<td>");

					for (int j = 0; j < this.users[i].getDisciplinas().length; j++) {
						writer.print("<span>");
						writer.print(this.users[i].getDisciplinas()[j]);
						writer.print("</span> <br>");
					}

					writer.print("</td>");
					writer.print("</tr>");
				}

				writer.print("</table>");

			}

		} else {

			resp.sendRedirect("http://localhost:8080/lib/login");

		}

	}

}