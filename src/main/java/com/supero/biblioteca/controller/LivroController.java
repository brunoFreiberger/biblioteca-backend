package com.supero.biblioteca.controller;

import javax.inject.Inject;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.supero.biblioteca.custom.CustomPageable;
import com.supero.biblioteca.custom.PagebleData;
import com.supero.biblioteca.dto.LivroDTO;
import com.supero.biblioteca.service.LivroService;

@Controller
@RequestMapping(path = "/livro")
public class LivroController implements ErrorController {

	@Inject
	private LivroService service;

	/**
	 * Salvar/Atualizar o livro.
	 * 
	 * @param obj
	 * @return CityDTO
	 */
	@PostMapping(path = "/save")
	public @ResponseBody LivroDTO save(@RequestBody LivroDTO obj) {
		return this.service.save(obj);
	}

	/**
	 * Remover o livro através do ID
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/remove/{id}")
	public @ResponseBody HttpStatus remove(@PathVariable Long id) {
		this.service.deleteById(id);
		return HttpStatus.OK;
	}

	/**
	 * Buscar a quantidade total de livros
	 * 
	 * @return
	 */
	@GetMapping(path = "/count")
	public @ResponseBody Long count() {
		Long count = this.service.count();
		return count;
	}

	/**
	 * Retornar uma lista paginada de livros.
	 * 
	 * @param pageableData
	 * @return
	 */
	@PostMapping(path = "/paginated")
	public @ResponseBody Page<LivroDTO> getPaginatedData(@RequestBody PagebleData pageableData) {
		CustomPageable pageable = pageableData.getPageable();
		Sort sort = Sort.by(pageable.getSort().getDirection(), pageable.getSort().getProperties());
		PageRequest pageRequest = PageRequest.of(pageable.getPage(), pageable.getSize(), sort);
		Page<LivroDTO> data = this.service.findByFilters(pageRequest, pageableData.getFilter());
		return data;
	}

	@GetMapping(path = "/find/{id}")
	public @ResponseBody LivroDTO getById(@PathVariable Long id) {
		LivroDTO dto = this.service.findById(id);
		return dto;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
