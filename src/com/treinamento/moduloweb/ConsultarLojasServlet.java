package com.treinamento.moduloweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lojas")
public class ConsultarLojasServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Loja loja1 = new Loja();
		loja1.setCodigo(1);
		loja1.setNome("Jaguaré");
		loja1.setLogomarca("Drogaraia");
		loja1.setCidade("São Paulo");

		Loja loja2 = new Loja();
		loja2.setCodigo(2);
		loja2.setNome("Butantã");
		loja2.setLogomarca("Drogaraia");
		loja2.setCidade("São Paulo");
		
		List<Loja> listaLojas = new ArrayList();
		listaLojas.add(loja1);
		listaLojas.add(loja2);
		
		req.setAttribute("lojas", listaLojas);
		
		RequestDispatcher rd = req.getRequestDispatcher("/consulta_loja.jsp");
		rd.forward(req, resp);
	}
}
