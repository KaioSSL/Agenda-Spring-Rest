package br.com.agenda.AgendaRestFull.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAO {
	@PersistenceContext
	private EntityManager teste;

	public EntityManager getTeste() {
		return teste;
	}

	public void setTeste(EntityManager teste) {
		this.teste = teste;
	}

}
