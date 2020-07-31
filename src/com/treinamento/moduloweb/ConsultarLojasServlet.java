package com.treinamento.moduloweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lojas")
public class ConsultarLojasServlet extends HttpServlet{

	
	public ConsultarLojasServlet() {
		System.out.println("Iniciando a nosssa servlet...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection conn = null;
		String url = "jdbc:mysql://dev.crurmnllvgn6.us-east-2.rds.amazonaws.com/dev";
		String usuario = "java";
		String senha = "1234";
		List<Loja> listaLojas = new ArrayList();
		
		String codigo = req.getParameter("codigo");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, usuario, senha);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select codigo, nome, logomarca, cidade from tb_loja");
			while(rs.next()) {
				Loja loja = new Loja();
				loja.setCodigo(rs.getInt("codigo"));
				loja.setNome(rs.getString("nome"));
				loja.setLogomarca(rs.getString("logomarca"));
				loja.setCidade(rs.getString("cidade"));
				
				listaLojas.add(loja);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//CONSULTA NO BANCO

		
		
		//INSERÇÃO 
		
		//ATUALIZACAO
		
		//EXCLUSÃO
		
//		Loja loja1 = new Loja();
//		loja1.setCodigo(1);
//		loja1.setNome("Jaguaré");
//		loja1.setLogomarca("Drogaraia");
//		loja1.setCidade("São Paulo");
//		loja1.setDtInauguracao(new Date());
//		
//		Loja loja2 = new Loja();
//		loja2.setCodigo(2);
//		loja2.setNome("Butantã");
//		loja2.setLogomarca("Drogaraia");
//		loja2.setCidade("São Paulo");
//		loja2.setDtInauguracao(new Date());
		
//
//		listaLojas.add(loja1);
//		listaLojas.add(loja2);
//		
		req.setAttribute("lojas", listaLojas);
		
		RequestDispatcher rd = req.getRequestDispatcher("/consulta_loja.jsp");
		rd.forward(req, resp);
	}
}
