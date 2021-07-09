package br.com.agenda.AgendaRestFull.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.agenda.AgendaRestFull.models.Entity.EstadoEntity;

public interface EstadoRepository extends CrudRepository<EstadoEntity, Integer> {

}
