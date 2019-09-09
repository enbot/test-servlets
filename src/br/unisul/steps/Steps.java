package br.unisul.steps;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unisul.login.User;

public class Steps extends HttpServlet {

	String[] form = new String[10];

	boolean ready1 = false;
	boolean ready2 = false;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();

		writer.print("<!DOCTYPE html>");
		writer.print("<head>");
		writer.print("<meta charset=\"UTF-8\">");
		writer.print("</head>");

		writer.print("<body>");

		writer.print("<form method=\"POST\" action=\"http://localhost:8080/lib/steps\">");
		writer.print("<h3>Parte 1</h3>");
		writer.print("<input type=\"hidden\" id=\"step\" name=\"step\" value=\"1\" />");
		writer.print("<input type=\"checkbox\" name=\"f1\" value=\"1\"> Pergunta 1");
		writer.print("<input type=\"checkbox\" name=\"f2\" value=\"1\"> Pergunta 2");
		writer.print("<input type=\"checkbox\" name=\"f3\" value=\"1\"> Pergunta 3");
		writer.print("<input type=\"checkbox\" name=\"f4\" value=\"1\"> Pergunta 4");
		writer.print("<input type=\"checkbox\" name=\"f5\" value=\"1\"> Pergunta 5");
		writer.print("<input type=\"submit\">");
		writer.print("</form>");

		writer.print("<form method=\"POST\" action=\"http://localhost:8080/lib/steps\">");
		writer.print("<h3>Parte 2</h3>");
		writer.print("<input type=\"hidden\" id=\"step\" name=\"step\" value=\"2\" />");
		writer.print("<input type=\"checkbox\" name=\"f1\" value=\"1\"> Pergunta 1");
		writer.print("<input type=\"checkbox\" name=\"f2\" value=\"1\"> Pergunta 2");
		writer.print("<input type=\"checkbox\" name=\"f3\" value=\"1\"> Pergunta 3");
		writer.print("<input type=\"checkbox\" name=\"f4\" value=\"1\"> Pergunta 4");
		writer.print("<input type=\"checkbox\" name=\"f5\" value=\"1\"> Pergunta 5");
		writer.print("<input type=\"submit\">");
		writer.print(" </form>");

		writer.print("</body>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		HttpSession session = req.getSession();

		PrintWriter writer = resp.getWriter();

		int step = Integer.parseInt(req.getParameter("step"));

		if (step == 1) {
			this.ready1 = true;
			System.out.print("naoSei");

			System.out.print(req.getAttribute("f1"));

			this.form[0] = (String) req.getParameter("f1");
			this.form[1] = (String) req.getParameter("f2");
			this.form[2] = (String) req.getParameter("f3");
			this.form[3] = (String) req.getParameter("f4");
			this.form[4] = (String) req.getParameter("f5");

		}

		if (step == 2) {
			this.ready2 = true;
			this.form[5] = (String) req.getParameter("f6");
			this.form[6] = (String) req.getParameter("f7");
			this.form[7] = (String) req.getParameter("f8");
			this.form[8] = (String) req.getParameter("f9");
			this.form[8] = (String) req.getParameter("f10");
		}

		if (this.ready1 && this.ready2) {
			for (int i = 0; i < form.length; i++) {
				writer.print("Pergunta " + (i + 1) + ": ");
				writer.print(form[i]);
				writer.print("<br>");
			}
		}

	}

}