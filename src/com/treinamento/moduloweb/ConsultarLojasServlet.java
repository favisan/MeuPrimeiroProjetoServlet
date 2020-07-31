package com.treinamento.moduloweb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.treinamento.moduloweb.dao.ConexaoMySqlDAO;
import com.treinamento.moduloweb.dao.LojaDAO;

@WebServlet("/lojas")
public class ConsultarLojasServlet extends HttpServlet{
	
	public ConsultarLojasServlet() {
		System.out.println("Iniciando a nosssa servlet...");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ConexaoMySqlDAO conexaoMySql = new ConexaoMySqlDAO();
		Connection conn = conexaoMySql.obterConexao();
		
		LojaDAO lojaDAO = new LojaDAO(conn);
		List<Loja> listaLojas = lojaDAO.buscarLojas();
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("lojas", listaLojas);
		
		RequestDispatcher rd = req.getRequestDispatcher("/consulta_loja.jsp");
		rd.forward(req, resp);
	}
}
