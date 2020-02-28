package com.supero.biblioteca.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.supero.biblioteca.dto.LivroDTO;
import com.supero.biblioteca.dto.LivroFilterDTO;
import com.supero.biblioteca.model.Livro;
import com.supero.biblioteca.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {
	
	private ModelMapper mapper = new ModelMapper();
	
	@Inject
	private LivroRepository repository;

	@Override
	public Page<LivroDTO> findByFilters(PageRequest pageRequest, LivroFilterDTO filter) {
		mapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.LOOSE);
		Page<Livro> page = repository.findByFilters(pageRequest, filter);
		List<LivroDTO> dtos = page.getContent().parallelStream().map(entity -> mapper.map(entity, LivroDTO.class)).collect(Collectors.toList());
		return new PageImpl<LivroDTO>(dtos, page.getPageable(), page.getTotalElements());
	}

	@Override
	public LivroDTO findById(Long id) {
		Livro entity = repository.findById(id).orElse(null);
		return mapper.map(entity, LivroDTO.class);
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public LivroDTO save(LivroDTO obj) {
		Livro entity = mapper.map(obj, Livro.class);
		entity = repository.save(entity);
		return mapper.map(entity, LivroDTO.class);
	}

}
