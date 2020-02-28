package com.supero.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.supero.biblioteca.dto.LivroFilterDTO;
import com.supero.biblioteca.model.Livro;

public interface LivroCustomRepository {

	public Page<Livro> findByFilters(PageRequest pageRequest, LivroFilterDTO filter);
	
}
