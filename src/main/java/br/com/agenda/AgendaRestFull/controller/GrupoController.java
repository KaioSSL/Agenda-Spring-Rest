package br.com.agenda.AgendaRestFull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.AgendaRestFull.models.DTO.GrupoDTO;
import br.com.agenda.AgendaRestFull.models.Entity.GrupoEntity;
import br.com.agenda.AgendaRestFull.repositorys.GrupoRepository;
import br.com.agenda.AgendaRestFull.service.GrupoService;

@RestController
@RequestMapping(path = "/api/grupo")
public class GrupoController {

	@Autowired
	GrupoRepository grupoRepository;
	
	@Autowired
	GrupoService service;

	@PostMapping
	public ResponseEntity<GrupoDTO> insertGrupo(@Validated @RequestBody GrupoDTO grupo) {
		return service.insert(grupo);
	}

	@PutMapping
	public ResponseEntity<GrupoDTO> updateGrupo(@Validated @RequestBody GrupoDTO grupo) {	
		return service.update(grupo);
	}

	@DeleteMapping
	public ResponseEntity<GrupoDTO> deleteGrupo(@Validated @RequestBody GrupoDTO grupo) {
		return service.delete(grupo);
	}
	
	@GetMapping
	public ResponseEntity<List<GrupoDTO>> getGrupos() {
		return service.get();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<GrupoEntity> getGrupo(@PathVariable(name = "id", required = true) Integer id) {
		Optional<GrupoEntity> opGrupo = grupoRepository.findById(id);
		GrupoEntity grupo = opGrupo.isPresent() ? opGrupo.get() : null;
		if (grupo != null) {
			return ResponseEntity.status(HttpStatus.OK).body(grupo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}



}
