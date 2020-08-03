package com.treinamento.moduloweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.treinamento.moduloweb.service.LojaService;
import com.treinamento.moduloweb.util.HttpUtil;

@WebServlet("/v1/lojas")
public class LojasWebService extends HttpServlet{
	
	public LojasWebService() {
		System.out.println("Iniciando a nosssa servlet...");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		LojaService service = new LojaService();
		List<Loja> listaLojas = service.listarLojas();
		
		Gson json = new Gson();
		
		String resultado = json.toJson(listaLojas);
		
		resp.getWriter().append(resultado);
		resp.setContentType("application/json");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String conteudo = HttpUtil.getBody(req);
		
		System.out.println(conteudo);
		
		Gson json = new Gson();
		Loja loja = json.fromJson(conteudo, Loja.class);
		
		LojaService service = new LojaService();
		service.inserir(loja);
		
		resp.getWriter().append("Registro inserido com sucesso");
		resp.setContentType("application/json");
		resp.setStatus(201);
	}
	
}
