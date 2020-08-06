package com.treinamento.moduloweb.service;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;

import com.treinamento.moduloweb.dao.CrudEntityManager;
import com.treinamento.moduloweb.dao.LojaDAO;
import com.treinamento.moduloweb.entity.LojaEntity;

public class LojaService {

	LojaDAO dao = null;
	Connection conn = null;

//	@PersistenceContext(unitName = "DevPersistence")
	EntityManager em;

	public LojaService() {
		em = CrudEntityManager.getEntityManager();
	}

	public void inserir(LojaEntity lojaEntity) {
//		em.getTransaction().begin();
		em.persist(lojaEntity);
//		em.getTransaction().commit();
	}

	public void atualizar(LojaEntity lojaEntity) {
		em.getTransaction().begin();
		em.merge(lojaEntity);
		em.getTransaction().commit();
	}

	public LojaEntity buscarPorId(Integer codigo) {
		return em.find(LojaEntity.class, codigo);
	}

	public void excluirPorId(Integer codigo) {
		em.getTransaction().begin();
		LojaEntity lojaEntity = buscarPorId(codigo);
		if (lojaEntity != null)
			em.remove(lojaEntity);

		em.getTransaction().commit();
	}

	public List<LojaEntity> listarTodas() {
		return em.createNamedQuery("buscarTodas", LojaEntity.class).getResultList();
	}

	public List<LojaEntity> buscarPorNome(String nome) {
//		TypedQuery<LojaEntity> query = em.createNamedQuery("buscarPorNome", LojaEntity.class);
//		query.setParameter("nome", nome);
//		return query.getResultList();

		return em.createNamedQuery("buscarPorNome", LojaEntity.class).setParameter("nome", nome).getResultList();
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
