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

import br.com.agenda.AgendaRestFull.models.DTO.GrupoDTO;
import br.com.agenda.AgendaRestFull.models.Entity.GrupoEntity;
import br.com.agenda.AgendaRestFull.repositorys.GrupoRepository;

@Service
public class GrupoService implements AgendaService<GrupoDTO>{
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public ResponseEntity<GrupoDTO> insert(GrupoDTO grupoDto) {
		try {
			GrupoEntity grupo = modelMapper.map(grupoDto, GrupoEntity.class);
			if (grupoRepository.save(grupo) != null) {
				grupoDto = modelMapper.map(grupo, GrupoDTO.class);
				return ResponseEntity.status(HttpStatus.CREATED).body(grupoDto);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	@Transactional
	public ResponseEntity<GrupoDTO> update(GrupoDTO grupoDto) {
		try {
			GrupoEntity grupo = modelMapper.map(grupoDto, GrupoEntity.class);
			if (grupoRepository.findById(grupo.getId()).isPresent()) {
				if (grupoRepository.save(grupo) != null) {
					grupoDto = modelMapper.map(grupo, GrupoDTO.class);
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

	@Override
	@Transactional
	public ResponseEntity<GrupoDTO> delete(GrupoDTO grupoDto) {
		try {
			GrupoEntity grupo = modelMapper.map(grupoDto, GrupoEntity.class);
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

	@Override
	@Transactional
	public ResponseEntity<List<GrupoDTO>> get() {
		try {
			Iterable<GrupoEntity> itGrupo = grupoRepository.findAll();
			List<GrupoDTO> listGrupoDto = new ArrayList<>();
			itGrupo.forEach(x -> listGrupoDto.add(modelMapper.map(listGrupoDto, GrupoDTO.class)));
			if (itGrupo.iterator().hasNext()) {
				return ResponseEntity.status(HttpStatus.OK).body(listGrupoDto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	@Transactional
	public ResponseEntity<GrupoDTO> get(Integer id) {
		try {
			Optional<GrupoEntity> opGrupo = grupoRepository.findById(id);
			GrupoDTO grupoDto = opGrupo.isPresent() ? modelMapper.map(opGrupo, GrupoDTO.class): null;
			if (grupoDto != null) {
				return ResponseEntity.status(HttpStatus.OK).body(grupoDto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

}
