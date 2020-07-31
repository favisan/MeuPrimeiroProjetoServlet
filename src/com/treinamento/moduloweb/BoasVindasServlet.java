package com.treinamento.moduloweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class BoasVindasServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.append("<body>");
		out.append("Bem vindo ao meu primeiro projeto web");
		out.append("</body>");
		out.append("</html>");
	}

	
}
