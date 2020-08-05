package com.treinamento.moduloweb.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import com.treinamento.moduloweb.Loja;
import com.treinamento.moduloweb.dao.ConexaoMySqlDAO;
import com.treinamento.moduloweb.dao.CrudEntityManager;
import com.treinamento.moduloweb.dao.LojaDAO;
import com.treinamento.moduloweb.entity.LojaEntity;

public class LojaService {

	LojaDAO dao = null;
	Connection conn = null;
	
	EntityManager em = null;
	
	public LojaService() {
		em = CrudEntityManager.getEntityManager();
	}
	
	public void inserir(LojaEntity lojaEntity) {
		em.getTransaction().begin();
		em.persist(lojaEntity);
		em.getTransaction().commit();
	}
	
	public void atualizar(LojaEntity lojaEntity){
		em.getTransaction().begin();
		em.merge(lojaEntity);
		em.getTransaction().commit();
	}

	public LojaEntity buscarPorId(Integer codigo){
		return em.find(LojaEntity.class, codigo);
	}
	
	public void excluirPorId(Integer codigo) {
		em.getTransaction().begin();
		LojaEntity lojaEntity = buscarPorId(codigo);
		if(lojaEntity != null)
			em.remove(lojaEntity);
		
		em.getTransaction().commit();
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
	
	
//	ConexaoMySqlDAO conexaoMySql = new ConexaoMySqlDAO();
//	
//	try {
//		conn = conexaoMySql.obterConexao();
//	} catch (SQLException e1) {
//		e1.printStackTrace();
//	}
//	
//	dao = new LojaDAO(conn);
//}
//
//	
//	public void inserir(Loja loja) {
//		dao.inserir(loja);
//	}
//	
//	public Loja buscarPorId(Integer codigo){
//		return dao.buscarPorId(codigo);
//	}
	
//	public void atualizar(Loja loja){
//		dao.atualizar(loja);
//	}


	
//	public void excluirPorId(Integer codigo) {
//		dao.excluirPorId(codigo);
//	}
}
