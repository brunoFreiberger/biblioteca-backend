package com.supero.biblioteca.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.supero.biblioteca.dto.LivroDTO;
import com.supero.biblioteca.dto.LivroFilterDTO;

public interface LivroService {

	public Page<LivroDTO> findByFilters(PageRequest pageRequest, LivroFilterDTO filter);

	public LivroDTO findById(Long id);

	public Long count();

	public void deleteById(Long id);

	public LivroDTO save(LivroDTO obj);

}
