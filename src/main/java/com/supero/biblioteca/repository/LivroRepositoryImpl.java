package com.supero.biblioteca.repository;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.querydsl.core.BooleanBuilder;
import com.supero.biblioteca.dto.LivroFilterDTO;
import com.supero.biblioteca.model.Livro;
import com.supero.biblioteca.model.QLivro;
import com.supero.biblioteca.utils.CommonUtils;

public class LivroRepositoryImpl implements LivroCustomRepository {
	
	@Inject
	private LivroRepository repository;

	@Override
	public Page<Livro> findByFilters(PageRequest pageRequest, LivroFilterDTO filter) {
		QLivro livro = QLivro.livro;

		BooleanBuilder predicate = new BooleanBuilder();

		if (!CommonUtils.isNull(filter.getTermo())) {
			predicate.and(livro.titulo.contains(filter.getTermo())
					.or(livro.autor.contains(filter.getTermo()))
					.or(livro.isbn.contains(filter.getTermo())));
		}

		if (filter.getAnoPublicacaoInicio() != null && filter.getAnoPublicacaoFim() != null) {
			predicate.and(livro.ano.goe(filter.getAnoPublicacaoInicio()).and(livro.ano.loe(filter.getAnoPublicacaoFim())));
		}

		Page<Livro> livros = this.repository.findAll(predicate, pageRequest);
		
		return livros;
	}

}
