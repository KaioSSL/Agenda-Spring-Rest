package br.com.agenda.AgendaRestFull.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agenda.AgendaRestFull.models.DTO.ContatoDTO;
import br.com.agenda.AgendaRestFull.models.DTO.EnderecoDTO;
import br.com.agenda.AgendaRestFull.models.DTO.GrupoDTO;
import br.com.agenda.AgendaRestFull.models.Entity.ContatoEntity;
import br.com.agenda.AgendaRestFull.models.Entity.EnderecoEntity;
import br.com.agenda.AgendaRestFull.models.Entity.GrupoEntity;
import br.com.agenda.AgendaRestFull.repositorys.ContatoRepository;
import br.com.agenda.AgendaRestFull.repositorys.EnderecoRepository;
import br.com.agenda.AgendaRestFull.repositorys.GrupoRepository;

@Service
public class ContactService {
	
	//Repositorys, to manipulate entity objects
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@Autowired
	ContatoRepository repository;
	
	
	//ModelMapper, to map the entity to dto, and dto to entity
	@Autowired
	ModelMapper mapper;
	
	//CRUD Endereco --------
	@Transactional
	public ResponseEntity<EnderecoDTO> insertEndereco(EnderecoDTO enderecoDto){
		try{
			EnderecoEntity endereco = mapper.map(enderecoDto, EnderecoEntity.class);
			if(enderecoRepository.save(endereco)!=null) {
				enderecoDto = mapper.map(endereco, EnderecoDTO.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(enderecoDto);
			}else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Transactional
	public ResponseEntity<EnderecoDTO> updateEndereco(EnderecoDTO enderecoDto){
		try{
			EnderecoEntity endereco = mapper.map(enderecoDto, EnderecoEntity.class);
			if(enderecoRepository.findById(endereco.getId()).isPresent()) {
				if(enderecoRepository.save(endereco) !=null) {
					enderecoDto = mapper.map(endereco, EnderecoDTO.class);
					return ResponseEntity.status(HttpStatus.OK).body(enderecoDto);
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
	public ResponseEntity<EnderecoDTO> deleteEndereco(EnderecoDTO enderecoDto){
		try {
			EnderecoEntity endereco  = mapper.map(enderecoDto, EnderecoEntity.class);
			if(enderecoRepository.findById(endereco.getId()).isPresent()) {
				enderecoRepository.delete(endereco);
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
	public ResponseEntity<List<EnderecoDTO>> getEnderecos(){
		try{
			Iterable<EnderecoEntity> itEndereco = enderecoRepository.findAll();
			List<EnderecoDTO> listEnderecoDto = new ArrayList<>();
			itEndereco.forEach(x->listEnderecoDto.add(mapper.map(x, EnderecoDTO.class)));
			if(listEnderecoDto.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listEnderecoDto);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<EnderecoDTO> getEndereco(Integer id){
		try{
			Optional<EnderecoEntity> opEndereco = enderecoRepository.findById(id);
			EnderecoDTO enderecoDto = opEndereco.isPresent()?mapper.map(opEndereco.get(),EnderecoDTO.class):null;
			if(enderecoDto != null) {
				return ResponseEntity.status(HttpStatus.OK).body(enderecoDto);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	//CRUD Endereco --------
	
	//CRUD Grupo --------
	@Transactional
	public ResponseEntity<GrupoDTO> insertGrupo(GrupoDTO grupoDto) {
		try {
			GrupoEntity grupo = mapper.map(grupoDto, GrupoEntity.class);
			if (grupoRepository.save(grupo) != null) {
				grupoDto = mapper.map(grupo, GrupoDTO.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(grupoDto);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<GrupoDTO> updateGrupo(GrupoDTO grupoDto) {
		try {
			GrupoEntity grupo = mapper.map(grupoDto, GrupoEntity.class);
			if (grupoRepository.findById(grupo.getId()).isPresent()) {
				if (grupoRepository.save(grupo) != null) {
					grupoDto = mapper.map(grupo, GrupoDTO.class);
					return ResponseEntity.status(HttpStatus.OK).body(grupoDto);
				} else {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<GrupoDTO> deleteGrupo(GrupoDTO grupoDto) {
		try {
			GrupoEntity grupo = mapper.map(grupoDto, GrupoEntity.class);
			if (grupoRepository.findById(grupo.getId()).isPresent()) {
				grupoRepository.delete(grupo);
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
	public ResponseEntity<List<GrupoDTO>> getGrupos() {
		try {
			Iterable<GrupoEntity> itGrupo = grupoRepository.findAll();
			List<GrupoDTO> listGrupoDto = new ArrayList<>();
			itGrupo.forEach(x -> listGrupoDto.add(mapper.map(listGrupoDto, GrupoDTO.class)));
			if (listGrupoDto.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listGrupoDto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<GrupoDTO> getGrupo(Integer id) {
		try {
			Optional<GrupoEntity> opGrupo = grupoRepository.findById(id);
			GrupoDTO grupoDto = opGrupo.isPresent() ? mapper.map(opGrupo, GrupoDTO.class): null;
			if (grupoDto != null) {
				return ResponseEntity.status(HttpStatus.OK).body(grupoDto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	//CRUD Grupo --------	
	
	//CRUD Contato --------
	@Transactional
	public ResponseEntity<ContatoDTO> insertContato(ContatoDTO contatoDto) {
		try {
			ContatoEntity contato = mapper.map(contatoDto, ContatoEntity.class);
			if (repository.save(contato) != null) {
				contatoDto = mapper.map(contato, ContatoDTO.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(contatoDto);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<ContatoDTO> updateContato(ContatoDTO contatoDto) {
		try {
			ContatoEntity contato = mapper.map(contatoDto, ContatoEntity.class);
			if (repository.findById(contato.getId()).isPresent()) {
				if (repository.save(contato) != null) {
					contatoDto = mapper.map(contato, ContatoDTO.class);
					return ResponseEntity.status(HttpStatus.OK).body(contatoDto);
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
	public ResponseEntity<ContatoDTO> deleteContato(ContatoDTO contatoDto) {
		try {
			ContatoEntity contato = mapper.map(contatoDto, ContatoEntity.class);
			if(repository.findById(contato.getId()).isPresent()) {
				repository.delete(contato);
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
	public ResponseEntity<List<ContatoDTO>> getContatos() {
		try{
			Iterable<ContatoEntity> itContatos = repository.findAll();
			List<ContatoDTO> listContatosDto = new ArrayList<>();
			itContatos.forEach(x -> listContatosDto.add(mapper.map(x,ContatoDTO.class)));
			if(listContatosDto.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listContatosDto);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Transactional
	public ResponseEntity<ContatoDTO> getContato(Integer id) {
		try {
			Optional<ContatoEntity> opContato = repository.findById(id);
			ContatoDTO contato = opContato.isPresent()?mapper.map(opContato.get(), ContatoDTO.class):null;
			if(contato != null) {
				return ResponseEntity.status(HttpStatus.OK).body(contato);
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	//CRUD Contato --------
}
