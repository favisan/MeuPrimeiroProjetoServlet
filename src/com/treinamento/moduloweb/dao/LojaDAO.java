package com.treinamento.moduloweb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.treinamento.moduloweb.Loja;

public class LojaDAO {

	Connection conn;

	public LojaDAO(Connection conn) {
		this.conn = conn;
	}

	public List<Loja> buscarLojas() {
		
		List<Loja> listaLojas = new ArrayList();
		
		try (   Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select codigo, nome, logomarca, cidade from tb_loja");) {

			while (rs.next()) {
				Loja loja = new Loja();
				loja.setCodigo(rs.getInt("codigo"));
				loja.setNome(rs.getString("nome"));
				loja.setLogomarca(rs.getString("logomarca"));
				loja.setCidade(rs.getString("cidade"));

				listaLojas.add(loja);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaLojas;
	}

	//insert
	
	//updates
	
	//delete
	
}
