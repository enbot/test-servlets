package br.unisul.signo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();

		writer.print("<!DOCTYPE html>");
		writer.print("<head>");
		writer.print("<meta charset=\"UTF-8\">");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<form method=\"POST\" action=\"http://localhost:8080/lib/signo\">");
		writer.print("<h3>Signos</h3>");
		writer.print("<label for=\"day\">Dia</label>");
		writer.print("<input type=\"number\" id=\"day\" name=\"day\" placeholder=\"Dia\" required />");
		writer.print("<label for=\"month\">Mês</label>");
		writer.print("<input type=\"number\" id=\"month\" name=\"month\" placeholder=\"Mês\" required />");
		writer.print("<input type=\"submit\">");
		writer.print("</form>");
		writer.print("</body>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();

		int day = Integer.parseInt(req.getParameter("day"));

		int month = Integer.parseInt(req.getParameter("month"));

		if (month == 1 && day > 20 && month == 2 && day < 19)
			writer.print("aquarios");
		else if (month == 2 && day > 18 || month == 3 && day < 20)
			writer.print("peixes");
		else if (month == 3 && day > 19 || month == 4 && day < 21)
			writer.print("áries");
		else if (month == 4 && day > 20 || month == 5 && day < 21)
			writer.print("Touro");
		else if (month == 5 && day > 20 || month == 6 && day < 21)
			writer.print("gêmios");
		else if (month == 6 && day > 20 || month == 7 && day < 22)
			writer.print("cancêr");
		else if (month == 7 && day > 21 || month == 8 && day < 23)
			writer.print("leão");
		else if (month == 8 && day > 22 || month == 9 && day < 23)
			writer.print("virgem");
		else if (month == 9 && day > 22 || month == 10 && day < 23)
			writer.print("libra");
		else if (month == 10 && day > 22 || month == 11 && day < 22)
			writer.print("escorpião");
		else if (month == 11 && day > 21 || month == 12 && day < 22)
			writer.print("sagitario");
		else if (month == 12 && day > 21 || month == 1 && day < 22)
			writer.print("capricornio");
		else
			writer.print("não encontrado");

	}

}