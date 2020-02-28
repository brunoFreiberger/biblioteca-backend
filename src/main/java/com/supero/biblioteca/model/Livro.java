package com.supero.biblioteca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 
 * @author Bruno H. Freiberger
 *
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "livro")
@SequenceGenerator(name = "gen_livro", sequenceName = "seq_livro", allocationSize = 50)
public class Livro {

	@Id
	@SequenceGenerator(name = "gen_livro", sequenceName = "seq_livro", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_livro")
	private Long id;

	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "autor")
	private String autor;
	
	@Column(name = "editora")
	private String editora;
	
	@Column(name = "ano")
	private Integer ano;
	
	@Column(name = "idioma")
	private String idioma;
	
	@Column(name = "peso")
	private Integer peso;
	
	@Column(name = "comprimento")
	private Integer comprimento;
	
	@Column(name = "largura")
	private Integer largura;
	
	@Column(name = "altura")
	private Integer altura;
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getComprimento() {
		return comprimento;
	}

	public void setComprimento(Integer comprimento) {
		this.comprimento = comprimento;
	}

	public Integer getLargura() {
		return largura;
	}

	public void setLargura(Integer largura) {
		this.largura = largura;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	
}
