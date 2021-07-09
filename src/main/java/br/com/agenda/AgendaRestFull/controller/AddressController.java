package br.com.agenda.AgendaRestFull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.agenda.AgendaRestFull.models.DTO.BairroDTO;
import br.com.agenda.AgendaRestFull.models.DTO.CidadeDTO;
import br.com.agenda.AgendaRestFull.models.DTO.EstadoDTO;
import br.com.agenda.AgendaRestFull.models.DTO.PaisDTO;
import br.com.agenda.AgendaRestFull.service.AddressService;

@RestController
@RequestMapping(path = "/api/address")
public class AddressController {
	
	@Autowired
	AddressService service;
	
	//CRUD Pais --------
	
	@PostMapping(path = "/country")
	public ResponseEntity<PaisDTO> insertPais(@Validated @RequestBody PaisDTO pais){
		return service.insertPais(pais);
	}
	
	@PutMapping(path = "/country")
	public ResponseEntity<PaisDTO> updatePais(@Validated @RequestBody PaisDTO pais){
		return service.updatePais(pais);
	}
	
	@DeleteMapping(path = "/country")
	public ResponseEntity<PaisDTO> deletePais(@Validated @RequestBody PaisDTO pais){
		return service.deletePais(pais);
	}
	
	@GetMapping(path = "/country/list")
	public ResponseEntity<List<PaisDTO>> getPaises(){
		return service.getPaises();
	}
	
	@GetMapping(path = "/country/{id}")
	public ResponseEntity<PaisDTO> getPais(@PathVariable(name = "id", required = true) Integer id){
		return service.getPais(id);
	}
	
	//CRUD Pais --------
	
	//CRUD Estado --------
	
	@PostMapping(path = "/uf")
	public ResponseEntity<EstadoDTO> insertEstado(@Validated @RequestBody EstadoDTO estado) {
		return service.insertEstado(estado);
	}

	@PutMapping(path = "/uf")
	public ResponseEntity<EstadoDTO> updateEstado(@Validated @RequestBody EstadoDTO estado) {
		return service.updateEstado(estado);
	}

	@DeleteMapping(path = "/uf")
	public ResponseEntity<EstadoDTO> deleteEstado(@Validated @RequestBody EstadoDTO estado) {
		return service.deleteEstado(estado);
	}

	@GetMapping(path = "/uf/list")
	public ResponseEntity<List<EstadoDTO>> getEstados(){
		return service.getEstados();
	}

	@GetMapping(path = "/uf/{id}")
	public ResponseEntity<EstadoDTO> getEstado(@PathVariable(name = "id",required = true) Integer id){
		return service.getEstado(id);
	}
	
	//CRUD Estado --------
	
	//CRUD Cidade --------
	@PostMapping(path = "/city")
	public ResponseEntity<CidadeDTO> getCidade(@Validated @RequestBody CidadeDTO cidade){
		return service.insertCidade(cidade);
	}
	
	@PutMapping(path = "/city")
	public ResponseEntity<CidadeDTO> updateCidade(@Validated @RequestBody CidadeDTO cidade){
		return service.updateCidade(cidade);
	}
	
	@DeleteMapping(path = "/city")
	public ResponseEntity<CidadeDTO> deleteCidade(@Validated @RequestBody CidadeDTO cidade){
		return service.deleteCidade(cidade);
	}	
	
	@GetMapping(path = "/city/list")
	public ResponseEntity<List<CidadeDTO>> getCidades(){
		return service.getCidades();
	}
	
	@GetMapping(path = "/city/{id}")
	public ResponseEntity<CidadeDTO> getCidade(@PathVariable(name = "id", required = true) Integer id){
		return service.getCidade(id);
	} 
	//CRUD Cidade --------
	
	//CRUD Bairro --------
	@PostMapping(path = "/district")
	public ResponseEntity<BairroDTO> insertBairro(@Validated @RequestBody BairroDTO bairro){
		return service.insertBairro(bairro);
	}
	
	@PutMapping(path = "/district")
	public ResponseEntity<BairroDTO> updateBairro(@Validated @RequestBody BairroDTO bairro){
		return service.updateBairro(bairro);
	}
	
	@DeleteMapping(path = "/district")
	public ResponseEntity<BairroDTO> deleteBairro(@Validated @RequestBody BairroDTO bairro){
		return service.deleteBairro(bairro);
	}
	
	@GetMapping(path = "/district/list")
	public ResponseEntity<List<BairroDTO>> getBairros(){
		return service.getBairros();
	}
	@GetMapping(path = "/district/{id}")
	public ResponseEntity<BairroDTO> getBairro(@PathVariable(name = "id", required = true) Integer id){
		return service.getBairro(id);
	}	
	//CRUD Bairro --------
	
}
