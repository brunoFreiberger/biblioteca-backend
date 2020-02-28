package com.supero.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.supero.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>, LivroCustomRepository, QuerydslPredicateExecutor<Livro> {

}
