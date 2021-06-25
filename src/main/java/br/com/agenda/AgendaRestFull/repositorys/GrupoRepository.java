package br.com.agenda.AgendaRestFull.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.agenda.AgendaRestFull.models.Entity.GrupoEntity;

public interface GrupoRepository extends CrudRepository<GrupoEntity, Integer> {

}
