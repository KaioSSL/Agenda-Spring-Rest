package br.com.agenda.AgendaRestFull.controllers;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.AgendaRestFull.models.Grupo;
import br.com.agenda.AgendaRestFull.repositorys.GrupoRepository;

@RestController
@RequestMapping(path = "/api/grupo")
public class GrupoController {

	@Autowired
	GrupoRepository grupoRepository;

	@PostMapping
	public ResponseEntity<Grupo> insertGrupo(@Validated @RequestBody Grupo grupo) {
		if (grupoRepository.save(grupo) != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(grupo);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(grupo);
		}
	}

	@PutMapping
	public ResponseEntity<Grupo> updateGrupo(@Validated @RequestBody Grupo grupo) {
		if (grupoRepository.findById(grupo.getId()).isPresent()) {
			if (grupoRepository.save(grupo) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(grupo);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(grupo);
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(grupo);
		}
	}

	@DeleteMapping
	public ResponseEntity<Grupo> deleteGrupo(@Validated @RequestBody Grupo grupo) {
		try {
			if (grupoRepository.findById(grupo.getId()).isPresent()) {
				grupoRepository.delete(grupo);
				return ResponseEntity.status(HttpStatus.OK).body(grupo);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Grupo> getGrupo(@RequestParam Integer id) {
		Optional<Grupo> opGrupo = grupoRepository.findById(id);
		Grupo grupo = opGrupo.isPresent() ? opGrupo.get() : null;
		if (grupo != null) {
			return ResponseEntity.status(HttpStatus.OK).body(grupo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping
	public ResponseEntity<Grupo> getGrupos() {
		Iterator<Grupo> itGrupo = grupoRepository.findAll().iterator();
		if (itGrupo.hasNext()) {
			return Response
		}
	}

}