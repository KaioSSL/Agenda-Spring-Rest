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

import br.com.agenda.AgendaRestFull.models.Entity.Cidade;
import br.com.agenda.AgendaRestFull.repositorys.CidadeRepository;

@RestController
@RequestMapping(path = "/api/cidade")
public class CidadeController {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@PostMapping
	public ResponseEntity<Cidade> insertCidade(@Validated @RequestBody Cidade cidade){
		if(cidadeRepository.save(cidade) != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Cidade> updateCidade(@Validated @RequestBody Cidade cidade){
		if(cidadeRepository.findById(cidade.getId()).isPresent()) {
			if(cidadeRepository.save(cidade) != null) {
				return ResponseEntity.status(HttpStatus.OK).body(cidade);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Cidade> deleteCidade(@Validated @RequestBody Cidade cidade){
		try{
			if(cidadeRepository.findById(cidade.getId()).isPresent()) {
				cidadeRepository.delete(cidade);
				return ResponseEntity.status(HttpStatus.OK).body(cidade);
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Cidade>> getCidades(){
		Iterable<Cidade> itCidade = cidadeRepository.findAll();
		if(itCidade.iterator().hasNext()) {
			return ResponseEntity.status(HttpStatus.OK).body(itCidade);		
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cidade> getCidade(@PathVariable(name = "id", required = true) Integer id){
		Optional<Cidade> opCidade = cidadeRepository.findById(id);
		Cidade cidade = opCidade.isPresent()?opCidade.get():null;
		if(cidade != null) {
			return ResponseEntity.status(HttpStatus.OK).body(cidade);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	

}
