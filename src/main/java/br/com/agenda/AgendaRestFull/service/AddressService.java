package br.com.agenda.AgendaRestFull.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.AgendaRestFull.models.DTO.BairroDTO;
import br.com.agenda.AgendaRestFull.models.DTO.CidadeDTO;
import br.com.agenda.AgendaRestFull.models.DTO.EstadoDTO;
import br.com.agenda.AgendaRestFull.models.DTO.PaisDTO;
import br.com.agenda.AgendaRestFull.models.Entity.BairroEntity;
import br.com.agenda.AgendaRestFull.models.Entity.CidadeEntity;
import br.com.agenda.AgendaRestFull.models.Entity.EstadoEntity;
import br.com.agenda.AgendaRestFull.models.Entity.PaisEntity;
import br.com.agenda.AgendaRestFull.repositorys.BairroRepository;
import br.com.agenda.AgendaRestFull.repositorys.CidadeRepository;
import br.com.agenda.AgendaRestFull.repositorys.EstadoRepository;
import br.com.agenda.AgendaRestFull.repositorys.PaisRepository;

public class AddressService {

	//Repositorys, to manipulate entity objects
	@Autowired
	PaisRepository paisRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	BairroRepository bairroRepository;
	
	//ModelMapper, to map the entity to dto, and dto to entity
	@Autowired
	ModelMapper mapper;
	
	//CRUD Pais --------
	
	
	
	@Transactional
	public ResponseEntity<PaisDTO> insertPais(PaisDTO paisDto) {
		try {
			PaisEntity pais = mapper.map(paisDto, PaisEntity.class);
			if(paisRepository.save(pais) !=null) {
				paisDto = mapper.map(pais, PaisDTO.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(paisDto);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<PaisDTO> updatePais(PaisDTO paisDto) {
		try {
			PaisEntity pais = mapper.map(paisDto, PaisEntity.class);
			if(paisRepository.findById(pais.getId()).isPresent()) {
				if(paisRepository.save(pais) != null) {
					paisDto = mapper.map(pais, PaisDTO.class);
					return ResponseEntity.status(HttpStatus.OK).body(paisDto);
				}else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<PaisDTO> deletePais(PaisDTO paisDto) {
		try{
			PaisEntity pais = mapper.map(paisDto, PaisEntity.class);
			if(paisRepository.findById(pais.getId()).isPresent()) {
				paisRepository.delete(pais);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}

	@Transactional
	public ResponseEntity<List<PaisDTO>> getPaises() {
		try {
			Iterable<PaisEntity> itPais = paisRepository.findAll();
			List<PaisDTO> listPaisesDto = new ArrayList<>();
			itPais.forEach(x->listPaisesDto.add(mapper.map(x,PaisDTO.class)));
			if(listPaisesDto.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listPaisesDto);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();			
		}
	}

	@Transactional
	public ResponseEntity<PaisDTO> getPais(Integer id) {
		try {
			Optional<PaisEntity> opPais = paisRepository.findById(id);
			PaisDTO paisDTO = opPais.isPresent()?mapper.map(opPais.get(),PaisDTO.class):null;
			if(paisDTO!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(paisDTO);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//CRUD Pais --------

	//CRUD Estado --------
	
	
	@Transactional
	public ResponseEntity<EstadoDTO> insertEstado(EstadoDTO estadoDto) {
		try {
			EstadoEntity estado = mapper.map(estadoDto, EstadoEntity.class);
			if (estadoRepository.save(estado) != null) {
				estadoDto = mapper.map(estado, EstadoDTO.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(estadoDto);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<EstadoDTO> updateEstado(EstadoDTO estadoDto) {
		try {
			EstadoEntity estado = mapper.map(estadoDto, EstadoEntity.class);
			if (estadoRepository.findById(estado.getId()).isPresent()) {
				if (estadoRepository.save(estado) != null) {
					estadoDto = mapper.map(estado, EstadoDTO.class);
					return ResponseEntity.status(HttpStatus.OK).body(estadoDto);
				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<EstadoDTO> deleteEstado(EstadoDTO estadoDto) {
		try {
			EstadoEntity estado = mapper.map(estadoDto, EstadoEntity.class);
			if (estadoRepository.findById(estado.getId()).isPresent()) {
				estadoRepository.delete(estado);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<List<EstadoDTO>> getEstados() {
		try {
			Iterable<EstadoEntity> itEstado = estadoRepository.findAll();
			List<EstadoDTO> listEstadoDto = new ArrayList<>();
			itEstado.forEach(x->listEstadoDto.add(mapper.map(x, EstadoDTO.class)));
			if(listEstadoDto.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listEstadoDto);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<EstadoDTO> getEstado(Integer id) {
		try {
			Optional<EstadoEntity> opEstado = estadoRepository.findById(id);
			EstadoDTO estadoDto = opEstado.isPresent()?mapper.map(opEstado.get(),EstadoDTO.class):null;
			if(estadoDto !=null ) {
				return ResponseEntity.status(HttpStatus.OK).body(estadoDto);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception  e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	//CRUD Estado --------
	
	//CRUD Cidade --------
	@Transactional
	public ResponseEntity<CidadeDTO> insertCidade(CidadeDTO cidadeDto){
		try {
			CidadeEntity cidade = mapper.map(cidadeDto, CidadeEntity.class);
			if(cidadeRepository.save(cidade) != null) {
				cidadeDto = mapper.map(cidade, CidadeDTO.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(cidadeDto);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Transactional
	public ResponseEntity<CidadeDTO> updateCidade(CidadeDTO cidadeDto){
		try {
			CidadeEntity cidade = mapper.map(cidadeDto, CidadeEntity.class);
			if(cidadeRepository.findById(cidade.getId()).isPresent()) {
				if(cidadeRepository.save(cidade) != null) {
					cidadeDto = mapper.map(cidade, CidadeDTO.class);
					return ResponseEntity.status(HttpStatus.OK).body(cidadeDto);
				}else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Transactional
	public ResponseEntity<CidadeDTO> deleteCidade(CidadeDTO cidadeDto){
		try{
			CidadeEntity cidade = mapper.map(cidadeDto, CidadeEntity.class);
			if(cidadeRepository.findById(cidade.getId()).isPresent()) {
				cidadeRepository.delete(cidade);
				cidadeDto = mapper.map(cidade, CidadeDTO.class);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}

	@Transactional
	public ResponseEntity<List<CidadeDTO>> getCidades(){
		try{
			Iterable<CidadeEntity> itCidade = cidadeRepository.findAll();
			List<CidadeDTO> listCidadeDto = new ArrayList<>();
			itCidade.forEach(x->listCidadeDto.add(mapper.map(x, CidadeDTO.class)));
			if(listCidadeDto.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listCidadeDto);		
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<CidadeDTO> getCidade(Integer id){
		try{
			Optional<CidadeEntity> opCidade = cidadeRepository.findById(id);
			CidadeDTO cidadeDto = opCidade.isPresent()?mapper.map(opCidade.get(),CidadeDTO.class):null;
			if(cidadeDto != null) {
				return ResponseEntity.status(HttpStatus.OK).body(cidadeDto);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//CRUD Cidade --------
	
	//CRUD Bairro --------
	@Transactional
	public ResponseEntity<BairroDTO> insertBairro(BairroDTO bairroDto){
		try{
			BairroEntity bairro = mapper.map(bairroDto, BairroEntity.class);
			if(bairroRepository.save(bairro)!=null) {
				bairroDto = mapper.map(bairro, BairroDTO.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(bairroDto);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Transactional
	public ResponseEntity<BairroDTO> updateBairro(BairroDTO bairroDto){
		try{
			BairroEntity bairro = mapper.map(bairroDto, BairroEntity.class);
			if(bairroRepository.findById(bairro.getId()).isPresent()) {
				if(bairroRepository.save(bairro) != null) {
					bairroDto = mapper.map(bairro, BairroDTO.class);
					return ResponseEntity.status(HttpStatus.OK).body(bairroDto);
				}else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Transactional
	public ResponseEntity<BairroDTO> deleteBairro(BairroDTO bairroDto){
		try{
			BairroEntity bairro = mapper.map(bairroDto, BairroEntity.class);
			if(bairroRepository.findById(bairro.getId()).isPresent()) {
				bairroRepository.delete(bairro);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Transactional
	public ResponseEntity<List<BairroDTO>> getBairros(){
		try{
			Iterable<BairroEntity> itBairro = bairroRepository.findAll();
			List<BairroDTO> listBairroDto = new ArrayList<>();
			itBairro.forEach(x->listBairroDto.add(mapper.map(x, BairroDTO.class)));
			if(listBairroDto.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listBairroDto);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<BairroDTO> getBairro(Integer id){
		try{
			Optional<BairroEntity> opBairro = bairroRepository.findById(id);
			BairroDTO bairroDto = opBairro.isPresent()?mapper.map(opBairro.get(), BairroDTO.class):null;
			if(bairroDto != null) {
				return ResponseEntity.status(HttpStatus.OK).body(bairroDto);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	//CRUD Bairro --------
}
