package com.treinamento.moduloweb.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.treinamento.moduloweb.Loja;
import com.treinamento.moduloweb.dao.ConexaoMySqlDAO;
import com.treinamento.moduloweb.dao.LojaDAO;

public class LojaService {

	public List<Loja> listarLojas(){
		ConexaoMySqlDAO conexaoMySql = new ConexaoMySqlDAO();
		Connection conn = null;
		try {
			conn = conexaoMySql.obterConexao();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		LojaDAO lojaDAO = new LojaDAO(conn);
		List<Loja> listaLojas = lojaDAO.listarTodas();
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaLojas;
	}
}
