package br.com.agenda.AgendaRestFull.controller;

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

import br.com.agenda.AgendaRestFull.models.Entity.Bairro;
import br.com.agenda.AgendaRestFull.repositorys.BairroRepository;

@RestController
@RequestMapping(path = "/api/bairro")
public class BairroController {
	
	@Autowired
	BairroRepository bairroRepository;
	
	@PostMapping
	public ResponseEntity<Bairro> insertBairro(@Validated @RequestBody Bairro bairro){
		if(bairroRepository.save(bairro)!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(bairro);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Bairro> updateBairro(@Validated @RequestBody Bairro bairro){
		if(bairroRepository.findById(bairro.getId()).isPresent()) {
			if(bairroRepository.save(bairro) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(bairro);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Bairro> deleteBairro(@Validated @RequestBody Bairro bairro){
		try{
			if(bairroRepository.findById(bairro.getId()).isPresent()) {
				bairroRepository.delete(bairro);
				return ResponseEntity.status(HttpStatus.OK).body(bairro);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Bairro>> getBairros(){
		Iterable<Bairro> itBairro = bairroRepository.findAll();
		if(itBairro.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(itBairro);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Bairro> getBairro(@PathVariable(name = "id", required = true) Integer id){
		Optional<Bairro> opBairro = bairroRepository.findById(id);
		Bairro bairro = opBairro.isPresent()?opBairro.get():null;
		if(bairro != null) {
			return ResponseEntity.status(HttpStatus.OK).body(bairro);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
