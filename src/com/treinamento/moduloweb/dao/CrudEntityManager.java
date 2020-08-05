package com.treinamento.moduloweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CrudEntityManager {

	private static EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("DevPersistence");

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
}
