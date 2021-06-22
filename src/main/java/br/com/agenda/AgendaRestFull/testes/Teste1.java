package br.com.agenda.AgendaRestFull.testes;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import br.com.agenda.AgendaRestFull.dao.DAO;
import br.com.agenda.AgendaRestFull.models.Estado;
import br.com.agenda.AgendaRestFull.models.Pais;

public class Teste1 {

	public static void main(String[] args) {
		DAO dao = new DAO();
		EntityManager teste = dao.getTeste();

		Pais us = new Pais("Brasil", "Pais de alegria", new ArrayList<Estado>());

		teste.getTransaction().begin();
		teste.persist(us);
		teste.getTransaction().commit();
		teste.close();

	}
}
