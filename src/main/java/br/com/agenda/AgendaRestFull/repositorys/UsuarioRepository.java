package br.com.agenda.AgendaRestFull.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.agenda.AgendaRestFull.models.Entity.UsuarioEntity;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Integer>{	
	
	public UsuarioEntity findByLogin(String login);
}
