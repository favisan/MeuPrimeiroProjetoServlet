package com.treinamento.moduloweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.treinamento.moduloweb.Loja;

public class LojaDAO {

	Connection conn;
	
	private String SQL_ATUALIZA = "update tb_loja set nome = ?, logomarca = ?, cidade = ? where codigo = ?";
	private String SQL_BUSCA_POR_ID = "select * from tb_loja where codigo = ?";
	private String SQL_LISTAR_TODAS = "select * from tb_loja";
	private String SQL_INSERIR = "insert into tb_loja values(null, ?, ?, ?)"; 
	private String SQL_EXCLUIR_POR_ID = "delete from tb_loja where codigo = ?";
	
	public LojaDAO(Connection conn) {
		this.conn = conn;
	}

	public List<Loja> listarTodas() {
		
		List<Loja> listaLojas = new ArrayList();
		
		try (   Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL_LISTAR_TODAS);) {

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

	public Loja buscarPorId(Integer codigo) {
		
	try (PreparedStatement stmt = conn.prepareStatement(SQL_BUSCA_POR_ID)) {

			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Loja loja = new Loja();
				loja.setCodigo(rs.getInt("codigo"));
				loja.setNome(rs.getString("nome"));
				loja.setLogomarca(rs.getString("logomarca"));
				loja.setCidade(rs.getString("cidade"));

				return loja;
			}

			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void inserir(Loja loja) {
		
		try (PreparedStatement stmt = conn.prepareStatement(SQL_INSERIR);){
			
			stmt.setString(1, loja.getNome());
			stmt.setString(2, loja.getLogomarca());
			stmt.setString(3, loja.getCidade());
			
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Loja loja) {
		try(PreparedStatement stmt = conn.prepareStatement(SQL_ATUALIZA);) {
			
			stmt.setString(1, loja.getNome());
			stmt.setString(2, loja.getLogomarca());
			stmt.setString(3, loja.getCidade());
			stmt.setInt(4, loja.getCodigo());
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirPorId(Integer codigo) {
		try(PreparedStatement stmt = conn.prepareStatement(SQL_EXCLUIR_POR_ID);) {
			stmt.setInt(1, codigo);
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
