package br.com.agenda.AgendaRestFull.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.AgendaRestFull.models.Contato;
import br.com.agenda.AgendaRestFull.repositorys.ContatoRepository;

@RestController
@RequestMapping("/api/contato")
public class ContatoController {

	@Autowired
	ContatoRepository contatoRepository;

	@PostMapping
	public ResponseEntity<Contato> insertContato(@Validated @RequestBody Contato contato) {
		if (contatoRepository.save(contato) != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(contato);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(contato);
		}
	}
	/*
	 * @PutMapping
	 * 
	 * @DeleteMapping
	 * 
	 * @GetMapping(path="/{id}")
	 * 
	 * @GetMapping
	 */

}
