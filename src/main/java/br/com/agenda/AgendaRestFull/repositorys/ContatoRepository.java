package br.com.agenda.AgendaRestFull.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.agenda.AgendaRestFull.models.Entity.ContatoEntity;

public interface ContatoRepository extends CrudRepository<ContatoEntity, Integer> {

}
