package br.com.agenda.AgendaRestFull.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.agenda.AgendaRestFull.models.Entity.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade, Integer>{

}
