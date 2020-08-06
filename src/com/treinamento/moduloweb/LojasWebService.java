package com.treinamento.moduloweb;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.treinamento.moduloweb.dao.CrudEntityManager;
import com.treinamento.moduloweb.entity.LojaEntity;
import com.treinamento.moduloweb.service.LojaService;
import com.treinamento.moduloweb.util.HttpUtil;

@WebServlet("/v1/lojas")
public class LojasWebService extends HttpServlet{
		
	public LojasWebService() {
		System.out.println("Iniciando a nosssa servlet...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codigo = req.getParameter("codigo");
				
		LojaService service = new LojaService();
		Gson json = new Gson();
		
		if(codigo != null && !codigo.isEmpty()) {
//			Loja loja = service.buscarPorId(Integer.valueOf(codigo));
			LojaEntity loja = service.buscarPorId(Integer.valueOf(codigo));
			
			resp.getWriter().append(json.toJson(loja));
			resp.setContentType("application/json");
		}else {
			List<LojaEntity> listaLojas = service.listarTodas();
			resp.getWriter().append(json.toJson(listaLojas));
			resp.setContentType("application/json");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String conteudo = HttpUtil.getBody(req);
		
		System.out.println(conteudo);
			
		Gson json = new Gson();
//		Loja loja = json.fromJson(conteudo, Loja.class);
		LojaEntity loja = json.fromJson(conteudo, LojaEntity.class);
		
		LojaService service = new LojaService();
		service.inserir(loja);
		
		LojaEntity lojaEntity = json.fromJson(conteudo, LojaEntity.class);
		
		resp.getWriter().append("Registro inserido com sucesso");
		resp.setContentType("application/json");
		resp.setStatus(201);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String conteudo = HttpUtil.getBody(req);
		
		System.out.println(conteudo);
		
		Gson json = new Gson();
//		Loja loja = json.fromJson(conteudo, Loja.class);
		LojaEntity loja = json.fromJson(conteudo, LojaEntity.class);
		
		LojaService service = new LojaService();
		service.atualizar(loja);
		
		resp.getWriter().append("Registro atualizado com sucesso");
		resp.setContentType("application/json");
		resp.setStatus(202);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String codigo = req.getParameter("codigo");
		
		if(codigo == null || codigo.isEmpty()) {
			resp.getWriter().append("Parâmetro não informado");
			resp.setStatus(409);
		}

		LojaService service = new LojaService();
		service.excluirPorId(Integer.valueOf(codigo));
		
		resp.getWriter().append("Registro excluído com sucesso");
		resp.setContentType("application/json");
		resp.setStatus(202);
	}
	
}
