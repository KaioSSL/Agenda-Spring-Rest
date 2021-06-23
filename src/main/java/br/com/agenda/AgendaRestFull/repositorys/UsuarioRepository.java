package br.com.agenda.AgendaRestFull.repositorys;

import org.springframework.data.repository.CrudRepository;

import br.com.agenda.AgendaRestFull.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{	
}
