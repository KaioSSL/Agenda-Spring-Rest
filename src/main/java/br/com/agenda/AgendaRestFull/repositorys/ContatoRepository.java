package br.com.agenda.AgendaRestFull.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.agenda.AgendaRestFull.models.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Integer> {

}
