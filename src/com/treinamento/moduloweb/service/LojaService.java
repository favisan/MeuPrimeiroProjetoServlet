package com.treinamento.moduloweb.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.treinamento.moduloweb.Loja;
import com.treinamento.moduloweb.dao.ConexaoMySqlDAO;
import com.treinamento.moduloweb.dao.LojaDAO;

public class LojaService {

	LojaDAO dao = null;
	Connection conn = null;
	
	public LojaService() {
		ConexaoMySqlDAO conexaoMySql = new ConexaoMySqlDAO();
		
		try {
			conn = conexaoMySql.obterConexao();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		dao = new LojaDAO(conn);
	}
	
	public List<Loja> listarLojas(){
		List<Loja> listaLojas = dao.listarTodas();
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaLojas;
	}
	
	public void inserir(Loja loja) {
		dao.inserir(loja);}
}
