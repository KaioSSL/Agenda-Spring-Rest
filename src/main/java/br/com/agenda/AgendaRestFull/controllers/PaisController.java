package br.com.agenda.AgendaRestFull.controllers;

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

import br.com.agenda.AgendaRestFull.models.Pais;
import br.com.agenda.AgendaRestFull.repositorys.PaisRepository;

@RestController
@RequestMapping(path = "/api/pais")
public class PaisController {
	
	@Autowired
	PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<Pais> insertPais(@Validated @RequestBody Pais pais){
		if(paisRepository.save(pais) !=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(pais);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Pais> updatePais(@Validated @RequestBody Pais pais){
		if(paisRepository.findById(pais.getId()).isPresent()) {
			if(paisRepository.save(pais) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(pais);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Pais> deletePais(@Validated @RequestBody Pais pais){
		try{
			if(paisRepository.findById(pais.getId()).isPresent()) {
				paisRepository.delete(pais);
				return ResponseEntity.status(HttpStatus.OK).body(pais);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Pais>> getPaises(){
		Iterable<Pais> itPais = paisRepository.findAll();
		if(itPais.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(itPais);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pais> getPais(@PathVariable(name = "id", required = true) Integer id){
		Optional<Pais> opPais = paisRepository.findById(id);
		Pais pais = opPais.isPresent()?opPais.get():null;
		if(pais!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(pais);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
}
